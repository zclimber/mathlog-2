grammar gram;

TERMINATOR : '\n' | '\r' | '\r\n' | EOF;
WS : (' ' | '\t')+ -> skip;

COMMA  : ',' ;
TARGET : '|-' ;
MEANS  : '->' ;
OR     : '|' ;
AND    : '&' ;
NOT    : '!' ;
LPAREN : '(' ;
RPAREN : ')' ;
EXISTS : '?';
FORALL : '@';
EQUALS : '=';
PLUS   : '+';
MUL    : '*';
ADDONE : '\'';
ZERO   : '0';

Name: '$'?[A-Z][0-9]*;
Variable: [a-z][0-9]*;
GenericPredicate: [A-Z]+;

file : header TERMINATOR+ (rootExpression TERMINATOR+)* ;
header : (expression (COMMA expression)*)? TARGET expression ;
rootExpression: expression;

expression : disj | (disj MEANS expression);
disj: conj | disj OR conj;
conj: unary | conj AND unary;
unary : predicate | NOT unary | LPAREN expression RPAREN | tieVariable | Name;

tieVariable : tieVariableExist | tieVariableForAll;
tieVariableExist : EXISTS Variable unary;
tieVariableForAll: FORALL Variable unary;

predicate : Name arglist | add EQUALS add;

add: mul | add PLUS mul;
mul: term | mul MUL term;
term: Variable arglist | Variable | LPAREN add RPAREN | term ADDONE | ZERO;

arglist: LPAREN (add (COMMA add)*)? RPAREN;
