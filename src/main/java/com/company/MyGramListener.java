package com.company;

import com.company.grammar.gramBaseListener;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class MyGramListener extends gramBaseListener {

    private PrintStream out;
    private Map<String, Integer> facts = new HashMap<>(), givenFacts = new HashMap<>();
    private Map<String, MPContainer> aRuleRequiredMP = new HashMap<>(), possibleMP = new HashMap<>();
    private gramParser.ExpressionContext movingCtx = null;
    private Set<gramParser.ExpressionContext> previousExprs = new HashSet<>();
    private int currentLine = 0;

    private DeductionWriter dw;

    public MyGramListener() {
        out = System.out;
    }

    public MyGramListener(PrintStream ps) {
        out = ps;
    }

    @Override
    public void exitHeader(gramParser.HeaderContext ctx) {
        List<gramParser.ExpressionContext> exprList = ctx.expression();
        for (int i = 0; i < exprList.size() - 2; i++) {
            givenFacts.put(PrefixBuilder.stringify(exprList.get(i)), i + 1);
        }
        if (exprList.size() >= 2) {
            movingCtx = exprList.get(exprList.size() - 2);
        }
        dw = new DeductionWriter(movingCtx, out);
        currentLine++;

        if (exprList.size() <= 1) {
            out.println(ctx.getText());
            return;
        }

        int size = exprList.size() - 1;

        String newTarget = "(" + exprList.get(size - 1).getText() +
                ")->(" + exprList.get(size).getText() + ")";
        exprList.remove(size);
        exprList.remove(size - 1);

        out.print(exprList.stream().map((e) -> e.getText()).collect(Collectors.joining(",")));
        out.print(ctx.TARGET().getText());
        out.println(newTarget);
    }

    public void addFact(gramParser.RootExpressionContext ctx, String prefixed) {
        if (aRuleRequiredMP.containsKey(prefixed)) {
            MPContainer mpc = aRuleRequiredMP.get(prefixed);
            aRuleRequiredMP.remove(prefixed);
            mpc.anum = currentLine;
            possibleMP.put(mpc.brule, mpc);
        }
        ParserRuleContext context = Util.getRootMeaningful(ctx);
        if (context instanceof gramParser.ExpressionContext) {
            MPContainer mpc =
                    new MPContainer((gramParser.ExpressionContext) context, currentLine, prefixed);
            previousExprs.add((gramParser.ExpressionContext) context);
            if (facts.containsKey(mpc.arule)) {
                mpc.anum = facts.get(mpc.arule);
                possibleMP.put(mpc.brule, mpc);
            } else {
                aRuleRequiredMP.put(mpc.arule, mpc);
            }
        }
        facts.put(prefixed, currentLine);
    }

    private boolean checkInduction(ParserRuleContext ctx) {
        ParserRuleContext zero, from, to, result;
        String x;
        {
            if (!(ctx instanceof gramParser.ExpressionContext)) {
                return false;
            }
            result = ((gramParser.ExpressionContext) ctx).expression();
            ParserRuleContext temp = Util.getRootMeaningful(((gramParser.ExpressionContext) ctx).disj());
            if (!(temp instanceof gramParser.ConjContext)) {
                return false;
            }
            zero = ((gramParser.ConjContext) temp).conj();
            temp = Util.getRootMeaningful(((gramParser.ConjContext) temp).unary());
            if (!(temp instanceof gramParser.TieVariableForAllContext)) {
                return false;
            }
            x = ((gramParser.TieVariableForAllContext) temp).Variable().getText();
            temp = Util.getRootMeaningful(((gramParser.TieVariableForAllContext) temp).unary());
            if (!(temp instanceof gramParser.ExpressionContext)) {
                return false;
            }
            from = ((gramParser.ExpressionContext) temp).disj();
            to = ((gramParser.ExpressionContext) temp).expression();
        }

        String repl = AxiomChecker.canReplace(zero, from, x);
        String repl2 = AxiomChecker.canReplace(to, from, x);
        String repl3 = AxiomChecker.canReplace(result, from, x);
        if ("0".equals(repl) && ("'" + x + "_").equals(repl2) && repl3 != null) {
            return true;
        }
        return false;
    }

    public void predicateCheck(gramParser.RootExpressionContext ctx) throws PredicateException {
        ParserRuleContext coreCtx = Util.getRootMeaningful(ctx);
        if (coreCtx instanceof gramParser.ExpressionContext) {
            ParserRuleContext from = Util.getRootMeaningful(((gramParser.ExpressionContext) coreCtx).disj());
            ParserRuleContext to = Util.getRootMeaningful(((gramParser.ExpressionContext) coreCtx).expression());
            if (from instanceof gramParser.TieVariableForAllContext) {
                // axiom 11
                gramParser.TieVariableForAllContext fr = (gramParser.TieVariableForAllContext) from;
                if (AxiomChecker.canGetBySubstitution(to, fr.unary(), fr.Variable())) {
                    throw new PredicateSuccess("Сх. акс. 11");
                }
            }
            if (to instanceof gramParser.TieVariableExistContext) {
                // axiom 12
                gramParser.TieVariableExistContext tt = (gramParser.TieVariableExistContext) to;
                if (AxiomChecker.canGetBySubstitution(from, tt.unary(), tt.Variable())) {
                    throw new PredicateSuccess("Сх. акс. 11");
                }
            }
            if (from instanceof gramParser.TieVariableExistContext) {
                // inference 1
                for (gramParser.ExpressionContext prevCtx : previousExprs) {
                    ParserRuleContext prevQuantor = prevCtx.disj();
                    ParserRuleContext thisQuantor = ((gramParser.TieVariableExistContext) from).unary();
                    ParserRuleContext prevStatic = prevCtx.expression();
                    ParserRuleContext thisStatic = to;
                    TerminalNode tiedVar = ((gramParser.TieVariableExistContext) from).Variable();
                    if (PrefixBuilder.stringify(prevStatic).equals(PrefixBuilder.stringify(thisStatic)) &&
                            PrefixBuilder.stringify(prevQuantor).equals(PrefixBuilder.stringify(thisQuantor))) {
                        if (FreeFixedFinder.getFree(thisStatic).contains(tiedVar.getText())) {
                            throw new PredicateException
                                    ("переменная " + tiedVar.getText() + " входит свободно в формулу " + thisStatic.getText());
                        } else if (movingCtx != null && FreeFixedFinder.getFree(movingCtx).contains(tiedVar.getText())) {
                            throw new PredicateException
                                    ("используется правило с квантором по переменной " + tiedVar.getText()
                                            + ", входящей свободно в допущение " + movingCtx.getText());
                        } else {
                            dw.printInfer(DeductionWriter.ProofType.ExistsInference,
                                    thisQuantor, thisStatic, tiedVar.getText());
                            throw new PredicateSuccess("Правило вывода 1");
                        }
                    }
                }
            }
            if (to instanceof gramParser.TieVariableForAllContext) {
                // inference 2
                for (gramParser.ExpressionContext prevCtx : previousExprs) {
                    ParserRuleContext prevQuantor = prevCtx.expression();
                    ParserRuleContext thisQuantor = ((gramParser.TieVariableForAllContext) to).unary();
                    ParserRuleContext prevStatic = prevCtx.disj();
                    ParserRuleContext thisStatic = from;
                    TerminalNode tiedVar = ((gramParser.TieVariableForAllContext) to).Variable();
                    if (PrefixBuilder.stringify(prevStatic).equals(PrefixBuilder.stringify(thisStatic)) &&
                            PrefixBuilder.stringify(prevQuantor).equals(PrefixBuilder.stringify(thisQuantor))) {
                        if (FreeFixedFinder.getFree(thisStatic).contains(tiedVar.getText())) {
                            throw new PredicateException
                                    ("переменная " + tiedVar.getText() + " входит свободно в формулу " + thisStatic.getText());
                        } else if (movingCtx != null && FreeFixedFinder.getFree(movingCtx).contains(tiedVar.getText())) {
                            throw new PredicateException
                                    ("используется правило с квантором по переменной " + tiedVar.getText()
                                            + ", входящей свободно в допущение " + movingCtx.getText());
                        } else {
                            dw.printInfer(DeductionWriter.ProofType.ForallInference,
                                    thisStatic, thisQuantor, tiedVar.getText());
                            throw new PredicateSuccess("Правило вывода 2");
                        }
                    }
                }
            }
        }
        if (checkInduction(coreCtx)) {
            throw new PredicateSuccess
                    ("Сх. акс. индукции");
        }
    }

    @Override
    public void exitRootExpression(gramParser.RootExpressionContext ctx) {
        dw.reset();
        String prefixed = PrefixBuilder.stringify(ctx.expression());
        Integer axiomNumber = AxiomChecker.isAxiomUsage(prefixed);
        try {
            if (axiomNumber != null) {
                throw new PredicateSuccess("Сх. акс. " + axiomNumber.toString());
            } else if (givenFacts.containsKey(prefixed)) {
                throw new PredicateSuccess("Предп. " + givenFacts.get(prefixed).toString());
            } else if (possibleMP.containsKey(prefixed)) {
                MPContainer mpc = possibleMP.get(prefixed);
                dw.printMP(mpc.context);
                throw new PredicateSuccess("M.P. " + Integer.toString(mpc.anum) + ", " + Integer.toString(mpc.moverNum));
            } else if (movingCtx != null && PrefixBuilder.stringify(movingCtx).equals(prefixed)) {
                dw.printSelf();
                throw new PredicateSuccess("Предп. " + Integer.toString(givenFacts.size() + 1));
            } else {
                predicateCheck(ctx);
                throw new PredicateException(); //"Не доказано"
            }
        } catch (PredicateSuccess e) {
            dw.print(ctx);
            System.out.println("(" + Integer.toString(currentLine) + ") "
                    + e.getMessage());
        } catch (PredicateException e) {
            String msg = "Вывод некорректен начиная с формулы номер " + Integer.toString(currentLine);
            if (e.getMessage() != null) {
                msg += ": " + e.getMessage();
            }
            System.err.println(msg);
            out.println(msg);
            System.exit(0);
        }
        addFact(ctx, prefixed);
        currentLine++;
    }

    public static class MPContainer {
        public final String arule, brule, mover;
        public final int moverNum;
        public int anum;

        public final gramParser.ExpressionContext context;

        MPContainer(gramParser.ExpressionContext context, int num, String moverStr) {
            this.context = context;
            moverNum = num;
            mover = moverStr;
            arule = PrefixBuilder.stringify(context.disj());
            brule = PrefixBuilder.stringify(context.expression());
        }
    }
}
