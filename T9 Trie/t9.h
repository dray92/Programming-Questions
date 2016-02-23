/*
Vishesh Sood [1239599]
CSE 374 Homework 4
02/12/2016

t9.h

This is my header file for t9.c. It is used to prototype
my functions and constants in my main file.
*/
#ifndef T9_H
#define T9_H

#include "trie.h"

#define MAX_WORD_LENGTH 183
// Fun Fact: 183 is the longest word ever to appear in literature.

WordList* search(Trie_t *Trie, char *searchSequence, WordList*
                                      lastVisitedNodeWordList);

bool validateUserInput(char *userInput, char* validationRegex);
void startUserInteractionSession(Trie_t *Trie);
void freeResources(Trie_t *Trie);

#endif
