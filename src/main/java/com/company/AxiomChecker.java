package com.company;

import com.company.grammar.gramLexer;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AxiomChecker {

    private static final String[] axiomsBase = {
            "(A)->((B)->(A))",
            "((A)->(B))->((A)->(B)->(C))->((A)->(C))",
            "(A)->(B)->(A)&(B)",
            "(A)&(B)->(A)",
            "(A)&(B)->(B)",
            "(A)->(A)|(B)",
            "(B)->(A)|(B)",
            "((A)->(C))->((B)->(C))->((A)|(B)->(C))",
            "((A)->(B))->((A)->!(B))->!(A)",
            "!!(A)->(A)",
            "a = b -> a' = b'",
            "a = b -> a = c -> b = c",
            "a' = b' -> a = b",
            "!a' = 0",
            "a + b' = (a + b)'",
            "a + 0 = a",
            "a * 0 = 0",
            "a * b' = a * b + a"
    };

    private static final String[] axiomsPrefix;

    static {
        axiomsPrefix = new String[axiomsBase.length];
        for (int i = 0; i < axiomsBase.length; i++) {
            String axiom = axiomsBase[i];
            gramParser parser = new gramParser(new CommonTokenStream(new gramLexer(CharStreams.fromString(axiom))));
            gramParser.ExpressionContext ctx = parser.expression();

            axiomsPrefix[i] = PrefixBuilder.stringify(ctx);
        }
    }

    public static String getExprSubstring(String original, int offset) {
        return getExprSubstring(original, offset, null);
    }

    public static String getExprSubstring(String original, int offset, Set<String> freeVars) {
        int depth = 1;
        int offs = offset;
        Map<Integer, String> fixed = new HashMap<>();
        while (depth > 0) {
            switch (original.charAt(offs)) {
                case '0': // zero variable
                    depth--;
                    offs++;
                    break;
                case '!': // unary operators
                case '\'':
                    offs++;
                    break;
                case '>': // binary operators
                case '|':
                case '&':
                case '?':
                case '@':
                case '+':
                case '*':
                case '=':
                    depth++;
                    offs++;
                    break;
                default:
                    if (!Character.isAlphabetic(original.charAt(offs))) {
                        throw new RuntimeException("WTF is " + original.charAt(offs) + " in " + original);
                    } else {
                        int origOffs = offs;
                        depth--;
                        while (Character.isLetterOrDigit(original.charAt(offs))) {
                            offs++;
                        }
                        if (original.charAt(offs) == '#') {
                            offs++;
                            int dadd = 0;
                            while (Character.isDigit(original.charAt(offs))) {
                                dadd = dadd * 10 + original.charAt(offs) - '0';
                                offs++;
                            }
                            depth += dadd;
                        } else {
                            if (freeVars != null) {
                                String currentVar = original.substring(origOffs, offs);
                                if (origOffs > 0 && (
                                        original.charAt(origOffs - 1) == '?' ||
                                                original.charAt(origOffs - 1) == '@')) {
                                    fixed.put(depth - 1, currentVar);
                                } else {
                                    if (!fixed.containsValue(currentVar)) {
                                        freeVars.add(currentVar);
                                    }
                                }
                                fixed.remove(depth);
                            }
                        }
                        assert (original.charAt(offs) == '_');
                        offs++;
                    }
            }
        }
        return original.substring(offset, offs);
    }

    private static boolean isAxiom(String prefixedExpression, String prefixedAxiom) {
//        System.err.println(prefixedExpression + " ? " + prefixedAxiom);
        int ePos = 0, aPos = 0;
        String modFiles[] = new String[3];
        while (aPos < prefixedAxiom.length()) {
            if (ePos >= prefixedExpression.length()) {
                return false;
            }
            switch (prefixedAxiom.charAt(aPos)) {
                case 'A':
                case 'B':
                case 'C':
                    int ps = prefixedAxiom.charAt(aPos) - 'A';
                    if (modFiles[ps] == null) {
                        modFiles[ps] = getExprSubstring(prefixedExpression, ePos);
                    } else {
                        if (!prefixedExpression.startsWith(modFiles[ps], ePos)) {
                            return false;
                        }
                    }
                    ePos += modFiles[ps].length();
                    aPos += 2;
                    break;
                default:
                    if (prefixedExpression.charAt(ePos) != prefixedAxiom.charAt(aPos)) {
                        return false;
                    }
                    ePos++;
                    aPos++;
            }
        }
        return true;
    }

    /**
     * Whether we can get To expression from From expression by replacing all instances of replStr variable to some term
     *
     * @param to      what we want to get
     * @param from    what we have
     * @param replStr variable to be replaced
     * @return null if cannot replace, empty string if no replacement needed or term if can
     */
    public static String canReplace(ParserRuleContext to, ParserRuleContext from, String replStr) {
        String toStr = PrefixBuilder.stringify(to);
        String fromStr = PrefixBuilder.stringify(from);
        int findIndexStart = fromStr.indexOf(replStr + "_");
        if (findIndexStart == -1) {
            if (fromStr.equals(toStr)) {
                return "";
            } else {
                return null;
            }
        }
        if (!toStr.startsWith(fromStr.substring(0, findIndexStart))) {
            return null;
        }
        String findStr = getExprSubstring(toStr, findIndexStart);
        String replaced = fromStr.replace(replStr + "_", findStr);
        if (replaced.equals(toStr)) {
            return findStr;
        } else {
            return null;
        }
    }

    private static Set<String> freeStrings(String term) {
        Set<String> stringSet = new HashSet<>();
        getExprSubstring(term, 0, stringSet);
        if (stringSet.size() == 1) {
            String cand = term.endsWith("_") ?
                    term.substring(0, term.length() - 1) :
                    term;
            if (stringSet.contains(cand)) {
                return stringSet;
            }
        }
        if (term.equals("0")) {
            return stringSet;
        }
        return stringSet;
    }

    public static boolean canGetBySubstitution(ParserRuleContext from, ParserRuleContext to, TerminalNode variable) throws PredicateException {
        String replStr = variable.getText();
        String findStr = canReplace(from, to, replStr);
        boolean possible = findStr != null;
        if (!possible) {
            return false;
        }
        if (findStr.equals("") || FreeFixedFinder.canSubstitute(from, freeStrings(findStr), replStr)) {
            return true;
        } else {
            throw new PredicateException("терм " + from.getText() + " не свободен для подстановки в формулу вместо переменной " + replStr);
        }
    }

    public static Integer isAxiomUsage(String prefixedExpression) {
        for (int i = 0; i < axiomsPrefix.length; i++) {
            if (isAxiom(prefixedExpression, axiomsPrefix[i])) {
                return i + 1;
            }
        }
        return null;
    }
}
