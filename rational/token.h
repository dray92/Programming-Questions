/*
 * Interface for lexical tokens returned by calculator scanner
 * CSE 374 16wi, courtesy of Hal Perkins
 */

#ifndef TOKEN_H
#define TOKEN_H

// lexical classes
enum lex_class {
  UNKNOWN,          // illegal or unknown character
  INT,              // integer constant
  PLUS,             // operator +
  MINUS,            // operator -
  TIMES,            // operator *
  DIV,              // operator %
  SLASH,            // slash to separate numerator/denominator
  LPAREN,           // (
  RPAREN,           // )
  EOL               // end of input line
};

// lexical token returned by scanner
struct token {
  lex_class kind;   // lexical class of the token
  int       ival;   // integer value if kind == INT (undefined otherwise)
};

#endif
