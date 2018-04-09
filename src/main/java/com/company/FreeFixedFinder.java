package com.company;

import com.company.grammar.gramBaseListener;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.ref.SoftReference;
import java.util.*;

public class FreeFixedFinder extends gramBaseListener {

    private final static Map<ParserRuleContext, SoftReference<Set<String>>> cache = new HashMap<>();

    public static Set<String> getFree(ParserRuleContext context) {
        context = Util.getRootMeaningful(context);
        SoftReference<Set<String>> ffh = cache.get(context);
        if (ffh != null) {
            Set<String> val = ffh.get();
            if (val != null) {
                return val;
            }
        }
        FreeFixedFinder fff = new FreeFixedFinder();
        new ParseTreeWalker().walk(fff, context);
        cache.put(context, new SoftReference<>(fff.free));
        return fff.free;
    }

    public static boolean canSubstitute(ParserRuleContext context, Set<String> from, String to) {
        FreeFixedFinder fff = new FreeFixedFinder();
        fff.from = from;
        fff.to = to;
        new ParseTreeWalker().walk(fff, context);
        return !fff.danger;
    }

    private final Deque<String> lastFixed = new ArrayDeque<>();
    private final Deque<Set<String>> freeFx = new ArrayDeque<>();
    private Set<String> free = new HashSet<>();
    private Set<String> from = null;
    private String to = null;
    private boolean danger = false;

    void tie(String var) {
        lastFixed.push(var);
        freeFx.push(free);
        free = new HashSet<>();
    }

    @Override
    public void enterTieVariableExist(gramParser.TieVariableExistContext ctx) {
        tie(ctx.Variable().getText());
    }

    @Override
    public void enterTieVariableForAll(gramParser.TieVariableForAllContext ctx) {
        tie(ctx.Variable().getText());
    }

    private void untie() {
        String wasFixed = lastFixed.pop();
        free.remove(wasFixed);
        if (wasFixed.equals(to) && !Collections.disjoint(free, from) ||
                free.contains(to) && from.contains(wasFixed)) {
            this.danger = true;
        }
        Set<String> freePrev = freeFx.pop();
        freePrev.addAll(free);
        free = freePrev;
    }

    @Override
    public void exitTieVariableExist(gramParser.TieVariableExistContext ctx) {
        untie();
    }

    @Override
    public void exitTieVariableForAll(gramParser.TieVariableForAllContext ctx) {
        untie();
    }

    @Override
    public void enterTerm(gramParser.TermContext ctx) {
        TerminalNode var = ctx.Variable();
        if (var != null && ctx.arglist() == null) {
            free.add(var.getText());
        }
    }
}
