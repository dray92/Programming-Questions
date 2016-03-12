/*
 * Implementation of rational number type
 * CSE 374 hw6, 16wi
 */

#include "rational.h"
#include <stdlib.h>
#include <stdexcept>

/* replace this line with your implementation of the Rational type */

int getGCD(int n, int d);

// Construct Rational 0/1
Rational::Rational() {
	num = 0;
	denom = 1;
}

// Construct Rational n/1
Rational::Rational(int n) {
	num = n;
	denom = 1;
}

// Construct Rational n/d
Rational::Rational(int n, int d) {
	if(d == 0)
		throw std::invalid_argument("denomominator=0 is undefined");

	// if numerator is 0, denomominator doesn't matter
	if(n == 0) {
		num = 0;
		denom = 1;
		return;
	}

	num = n;
	denom = d;

	// if denomominator negative and numerator positive
	// must flip denominator, must flip numerator; if both 
	// numerator and denominator are negative, flip numerator
	// and flip the denominator
	if(denom < 0) {
		num = -num;
		denom = -denom;
	}

	int gcd = getGCD(num, denom);
	num = num/gcd;
	denom = denom/gcd;
}


// get numerator
int Rational::n() {
	return num;
}


// get denominator
int Rational::d() {
	return denom;
}


Rational Rational::plus(Rational other) {
	// p1/q1 + p2/q2
	// = (p1q2 + p2q1)/q1q2

	int p1 = n();
	int q1 = d();

	int p2 = other.n();
	int q2 = other.d();

	return Rational( (p1*q2 + p2*q1) , q1*q2 ); 
}


Rational Rational::minus(Rational other) {
	Rational newOther  = Rational( -1 * other.n() , other.d() );
	return plus( newOther );
}


Rational Rational::times(Rational other) {
	// p1/q1 * p2/q2
	// = (p1*p2)/(q1*q2)

	int p1 = n();
	int q1 = d();

	int p2 = other.n();
	int q2 = other.d();

	return Rational( p1*p2 , q1*q2 ); 
}

 
Rational Rational::div(Rational other) {
	// p1/q1 // p2/q2
	// = (p1*q2)/(q1*p2)

	return times( Rational( other.d() , other.n() ) );
}


int getGCD(int n, int d) {

	// need to think about this....
	if(n == 0 || d == 0)
		return 0;

	// get rid of negative signs
	n = abs(n);
	d = abs(d);

	while(n != d) {
		// if numerator > denomominator
		if(n > d) {
			n -= d;
		} else {
			d -= n;
		}
	}

	return n;
}