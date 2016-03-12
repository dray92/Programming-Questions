/*
 * Implementation of scanner for rational number calculator
 * CSE 374, 16wi, courtesy of Hal Perkins
 */

#include "token.h"
#include "scan.h"
#include <string>
#include <cctype>
#include <cstdlib>
using namespace std;

// Next unprocessed token on current input line.
// Undefined if set_input has not been called.
token next_tok;

// Current input line.
// line[pos..line.size()-1] is the unprocessed part of the line
string            line = "";
string::size_type pos  = 0;

// Advance next_tok to next token on current input line, if any.
// If next_tok.kind == EOL, then return and leave next_tok unaltered.
// pre: set_input has been called.
void scan() {
  string::size_type nextpos;  // declared here to get rid of a g++ warning

  if (next_tok.kind ==EOL) {
    return;
  }

  // Skip whitespace.
  while (pos < line.size() && isspace(line[pos])) {
    pos++;
  }

  // Skipped leading whitespace.  Either past end of line, or
  // next character is not blank.  Return if past end of line.
  if (pos >= line.size()) {
    next_tok.kind = EOL;
    return;
  }

  // next character is not blank.  classify and return next token.
  switch(line[pos]) {

    // single-character tokens
  case '+':
    next_tok.kind = PLUS; pos++; return;
  case '-':
    next_tok.kind = MINUS; pos++; return;
  case '*':
    next_tok.kind = TIMES; pos++; return;
  case '%':
    next_tok.kind = DIV; pos++; return;
  case '/':
    next_tok.kind = SLASH; pos++; return;
  case '(':
    next_tok.kind = LPAREN; pos++; return;
  case ')':
    next_tok.kind = RPAREN; pos++; return;

    // integer tokens
  case '0': case '1': case '2': case '3': case '4':
  case '5': case '6': case '7': case '8': case '9':

    // line[pos] is a digit.
    // Find last digit in the integer.
    nextpos = pos+1;
    while (nextpos < line.size() && isdigit(line[nextpos])) {
      nextpos++;
    }
    // line[pos..nextpos-1] holds the integer characters
    next_tok.kind = INT;
    next_tok.ival = atoi(line.substr(pos, nextpos-pos).c_str());
    pos = nextpos;
    return;

    // unknown character in input
  default:
    next_tok.kind = UNKNOWN; pos++; return;
  }

}

// Set input line to new_line and advance next_tok to the first token
// in that new line (which might be EOL if the line is empty).
void set_input(string new_line) {
  line = new_line;
  pos = 0;
  next_tok.kind = UNKNOWN;
  scan();
}

