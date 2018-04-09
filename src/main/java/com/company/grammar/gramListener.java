// Generated from C:/Users/MY/IdeaProjects/hw2/src/main\gram.g4 by ANTLR 4.7
package com.company.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(gramParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(gramParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(gramParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(gramParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void enterRootExpression(gramParser.RootExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#rootExpression}.
	 * @param ctx the parse tree
	 */
	void exitRootExpression(gramParser.RootExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(gramParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(gramParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#disj}.
	 * @param ctx the parse tree
	 */
	void enterDisj(gramParser.DisjContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#disj}.
	 * @param ctx the parse tree
	 */
	void exitDisj(gramParser.DisjContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#conj}.
	 * @param ctx the parse tree
	 */
	void enterConj(gramParser.ConjContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#conj}.
	 * @param ctx the parse tree
	 */
	void exitConj(gramParser.ConjContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(gramParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(gramParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#tieVariable}.
	 * @param ctx the parse tree
	 */
	void enterTieVariable(gramParser.TieVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#tieVariable}.
	 * @param ctx the parse tree
	 */
	void exitTieVariable(gramParser.TieVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#tieVariableExist}.
	 * @param ctx the parse tree
	 */
	void enterTieVariableExist(gramParser.TieVariableExistContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#tieVariableExist}.
	 * @param ctx the parse tree
	 */
	void exitTieVariableExist(gramParser.TieVariableExistContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#tieVariableForAll}.
	 * @param ctx the parse tree
	 */
	void enterTieVariableForAll(gramParser.TieVariableForAllContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#tieVariableForAll}.
	 * @param ctx the parse tree
	 */
	void exitTieVariableForAll(gramParser.TieVariableForAllContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(gramParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(gramParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(gramParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(gramParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(gramParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(gramParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(gramParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(gramParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(gramParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(gramParser.ArglistContext ctx);
}