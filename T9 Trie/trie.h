/*
Vishesh Sood [1239599]
CSE 374 Homework 4
02/12/2016

trie.h

This is my trie header file. It creates the required
structs and also prototypes my functions in the main file.
*/
#ifndef TRIE_H

#include <stdbool.h>

#define TRIE_H
#define NUM_SIZE 8 /* 2,3,4,5,6,7,8,9 */
#define LETTERS_SIZE 26

extern char MAP[];  // externed to prevent conflicts

// WordList struct
typedef struct Words WordList;
struct Words {
    char *word;
    WordList *next;
};

// Trie_Node struct
typedef struct Trie_Node Trie_Node_t;
struct Trie_Node {
    Trie_Node_t *children[NUM_SIZE];
    WordList *words;
};

// Trie struct
typedef struct Trie Trie_t;
struct Trie {
    Trie_Node_t *root;
};

// Prototype functions in main file
Trie_t *initializeTrie(void);
Trie_Node_t *getNode(void);
WordList* getWordListNode(char word[]);
void freeWordsList(WordList *words);

// following prototypes are indirectly accessed by t9.c
// externed to prevent conflicts
extern void insertWord(Trie_t *root, char word[]);
extern void addWordToList(Trie_Node_t *node, char word[]);
extern WordList* searchWord(Trie_t *Trie, char digitSequence[]);
extern char charToDigit(char ch);
extern bool listContains(WordList *list, char *word);
extern void freeNode(Trie_Node_t *node);

#endif
