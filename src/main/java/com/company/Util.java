package com.company;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Util {
    public static final int poolSize = 26 * 2 + 10;

    private static char getchar(int number) {
        if (number < 0 || number >= poolSize) {
            throw new IllegalArgumentException();
        }
        if (number < 26) {
            return (char) ('a' + number);
        } else if (number < 26 * 2) {
            return (char) ('A' + number - 26);
        } else {
            return (char) ('0' + number - 26 * 2);
        }
    }

    public static ParserRuleContext getRootMeaningful(ParserRuleContext ctx) {
        int ruleContextCount = 0;
        ParserRuleContext child = null;
        for (ParseTree cand : ctx.children) {
            if (cand instanceof ParserRuleContext) {
                child = (ParserRuleContext) cand;
                ruleContextCount++;
            } else if (cand instanceof TerminalNode) {
                String tokenText = ((TerminalNode) cand).getSymbol().getText();
                if (!tokenText.equals("(") && !tokenText.equals(")")) {
                    ruleContextCount++;
                }
            }
        }
        if (ruleContextCount == 1 && child != null) {
            return getRootMeaningful(child);
        } else {
            return ctx;
        }
    }
}
