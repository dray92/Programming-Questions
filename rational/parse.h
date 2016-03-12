/*
 * Interface to parser/calculator for rational numbers
 * CSE 374, 16wi, courtesy of Hal Perkins
 */

#ifndef PARSE_H
#define PARSE_H

#include "rational.h"

/* Return value of next expression on current input line.        */
/* (If errors are detected, a bogus number like 0/0 is returned. */
Rational expr();

#endif
