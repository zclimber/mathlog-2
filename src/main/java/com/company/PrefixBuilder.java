package com.company;

import com.company.grammar.gramBaseListener;
import com.company.grammar.gramParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

class PrefixBuilder extends gramBaseListener {
    public final StringBuilder sb = new StringBuilder();

    private int variableCount = 0;

    public PrefixBuilder() {
    }

    private static Map<ParserRuleContext, SoftReference<String>> ruleCache = new HashMap<>();

    public static String stringify(ParserRuleContext context) {
        context = Util.getRootMeaningful(context);
        SoftReference<String> value = ruleCache.get(context);
        if (value != null) {
            String result = value.get();
            if (result != null) {
                return result;
            }
        }
        PrefixBuilder pb = new PrefixBuilder();
        ParseTreeWalker.DEFAULT.walk(pb, context);
        String result = pb.sb.toString();
        ruleCache.put(context, new SoftReference<>(result));
        return result;
    }

    private String getArgsSize(gramParser.ArglistContext ctx) {
        return Integer.toString((ctx.getChildCount() - 1) / 2);
    }

    @Override
    public void enterExpression(gramParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append(">");
        }
    }

    @Override
    public void enterDisj(gramParser.DisjContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("|");
        }
    }

    @Override
    public void enterConj(gramParser.ConjContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("&");
        }
    }

    @Override
    public void enterUnary(gramParser.UnaryContext ctx) {
        if (ctx.NOT() != null) {
            sb.append('!');
        } else if (ctx.Name() != null) {
            sb.append(ctx.Name().getText());
            sb.append('_');
        }
    }

    public void enterTieVariable(boolean isExists, TerminalNode variable) {
        if (isExists) {
            sb.append('?');
        } else {
            sb.append('@');
        }
        sb.append(variable.getText());
        sb.append('_');
    }

    @Override
    public void enterTieVariableExist(gramParser.TieVariableExistContext ctx) {
        enterTieVariable(true, ctx.Variable());
    }

    @Override
    public void enterTieVariableForAll(gramParser.TieVariableForAllContext ctx) {
        enterTieVariable(false, ctx.Variable());
    }

    @Override
    public void enterPredicate(gramParser.PredicateContext ctx) {
        if (ctx.EQUALS() != null) {
            sb.append('=');
        } else if (ctx.arglist() != null) {
            String oName = ctx.Name().getText();
            sb.append(oName);
            sb.append('#');
            sb.append(getArgsSize(ctx.arglist()));
            sb.append('_');
        }
    }

    @Override
    public void enterAdd(gramParser.AddContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("+");
        }
    }

    @Override
    public void enterMul(gramParser.MulContext ctx) {
        if (ctx.getChildCount() == 3) {
            sb.append("*");
        }
    }

    @Override
    public void enterTerm(gramParser.TermContext ctx) {
        if (ctx.Variable() != null) {
            String oldName = ctx.Variable().getText();
            sb.append(oldName);
            if (ctx.arglist() != null) {
                sb.append('#');
                sb.append(getArgsSize(ctx.arglist()));
            }
            sb.append('_');
        } else {
            if (ctx.ADDONE() != null) {
                sb.append("'");
            } else if (ctx.ZERO() != null) {
                sb.append('0');
            }
        }
    }
}
