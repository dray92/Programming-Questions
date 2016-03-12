# Makefile for rational number calculator
# CSE 374, 16wi, courtesy of Hal Perkins

calc: rational.o scan.o parse.o calc.o
	g++ -Wall -g -std=c++11 -o calc calc.o rational.o scan.o parse.o

rational.o: rational.cpp rational.h
	g++ -Wall -g -std=c++11 -c rational.cpp

scan.o: scan.cpp token.h scan.h
	g++ -Wall -g -std=c++11 -c scan.cpp

parse.o: parse.cpp rational.h token.h scan.h
	g++ -Wall -g -std=c++11 -c parse.cpp

calc.o: calc.cpp rational.h token.h scan.h parse.h
	g++ -Wall -g -std=c++11 -c calc.cpp

clean:
	rm -f *.o *~ calc
