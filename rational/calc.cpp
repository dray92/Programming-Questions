/*
 * Interactive calculator for expressions with rational numbers.
 * CSE 374, 16wi, courtesy of Hal Perkins
 */

#include "rational.h"
#include "token.h"
#include "scan.h"
#include "parse.h"
#include <iostream>
#include <string>
using namespace std;

// print rational r followed by a newline
void prrat(Rational r) {
  cout << r.n() << "/" << r.d() << endl;
}

/* Read and print expressions until eof */
int main() {
  string input_line;
  cout << "Enter expressions with integer rational numbers (n/d) and" << endl;
  cout << "the operations +, -, *, and %.  One line per expression." << endl;
  cout << "Enter eof (cntrl-D) to stop." << endl;
  while (getline(cin, input_line)) {
    set_input(input_line);
    prrat(expr());
  }

  return 0;
}
