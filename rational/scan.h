/*
 * Interface to scanner for rational number calculator
 * CSE 374, 16wi, courtesy of Hal Perkins
 */

#ifndef SCAN_H
#define SCAN_H

#include "token.h"
#include <string>
using namespace std;

// Next unprocessed token on current input line.
// Undefined if set_input has not been called.
extern token next_tok;

// Advance next_tok to next token on current input line, if any.
// If next_tok.kind == EOL on input, do nothing.
// pre: set_input has been called.
void scan();

// Set input line to new_line and advance next_tok to the first token
// in that new line (which might be EOL if the line is empty).
void set_input(string new_line);

#endif
