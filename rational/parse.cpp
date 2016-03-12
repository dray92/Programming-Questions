/*
 * Implementation of parser/calculator for rational numbers
 * CSE 374, 16wi, courtesy of Hal Perkins
 */

#include "rational.h"
#include "token.h"
#include "scan.h"

/*
 * This parser/evaluator is a recursive-descent parser for expressions
 * defined by the following traditional expression grammar:
 *
 * <expr> ::= <term> | <expr> + term | <expr> - <term>
 * <term> ::= <factor> | <term> * <factor> | <term> % <factor>
 * <factor> ::= <int> | <int> / <int> | ( <expr> )
 *
 * <int> represents integer constants.  A rational is either a single <int>
 * or two <int>s separated by a /.  The symbol % is used in expressions
 * for division.  There is no unary minus for entering negative numbers
 * directly, although that wouldn't be too hard to add.  Subexpressions
 * may be parenthesized.
 *
 * Each function in the parser returns the value of the expression it
 * parses.  If an error is encountered, 0/0 is returned when the error
 * is first encountered, which may lead to further errors (i.e., there
 * is no attempt to do graceful error handling).
 *
 * Precondition for all parser functions: next_tok contains the next
 * unprocessed token in the input stream.  (Which implies that each
 * function consumes all of the input corresponding to the construct
 * it parses.)
 */

/* Forward declarations: */
Rational expr();
Rational term();
Rational factor();


/* parse <expr> ::= <term> | <expr> + term | <expr> - <term> */
Rational expr() {
  Rational val = term();
  while (next_tok.kind == PLUS || next_tok.kind == MINUS) {
    lex_class op = next_tok.kind;
    scan();  // advance past op
    if (op == PLUS) {
      val = val.plus(term());
    } else { // op == MINUS
      val = val.minus(term());
    }
  }
  return val;
}

/* parse <term> ::= <factor> | <term> * <factor> | <term> % <factor> */
Rational term() {
  Rational val = factor();
  while (next_tok.kind == TIMES || next_tok.kind == DIV) {
    lex_class op = next_tok.kind;
    scan();  // advance past op
    if (op == TIMES) {
      val = val.times(factor());
    } else { // op == DIV
      val = val.div(factor());
    }
  }
  return val;
}

/* parse  <factor> ::= <int> | <int> / <int> | ( <expr> ) */
Rational factor() {
  int num; int denom;
  Rational val;
  switch(next_tok.kind) {
  case INT:
    // <int> or <int>/<int>
    num = next_tok.ival;
    denom = 1;
    scan();   // skip past first <int>
    if (next_tok.kind == SLASH) {
      scan();
      denom = next_tok.ival;
      scan();
    }
    return Rational(num, denom);

  case LPAREN:
    // parenthesized expression.  parse expr but consume parens
    scan();
    val = expr();
    scan();
    return val;

  default:
    // something that's not a factor - skip past it so we don't get stuck
    scan();
    return Rational(0,0);
  }
}
