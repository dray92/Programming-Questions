/*
Vishesh Sood [1239599]
CSE 374 Homework 4
02/12/2016

trie.c

This is my trie file. It creates structs for t9.c to
use, allowing it to implement a trie of linked lists.
*/
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "trie.h"  // include header file

char MAP[LETTERS_SIZE] = {'2', '2', '2', '3', '3', '3', '4',
                          '4', '4', '5', '5', '5', '6', '6',
                          '6', '7', '7', '7', '7', '8', '8',
                          '8', '9', '9', '9', '9'};

/*
initializeTrie Function
This function creates a new trie, and allocates
memory for the trie. 
*/
Trie_t *initializeTrie(void) {
    Trie_t *Trie = malloc(sizeof(Trie_t));
    Trie->root = (Trie_Node_t*)getNode();
    return Trie;
}

/*
charToDigit function
This function accepts a character and returns the
corresponding digit.
*/
char charToDigit(char ch) {
    if (ch > 'z' || ch < 'a') {
        return '\0';
    }
    int index = (int)ch - 'a';
    return MAP[index];
}

/*
insertWord Function
This function accepts a pointer to a trie and a char
array and inserts that word appropriately into the 
passed trie. It does not return anything.
*/
void insertWord(Trie_t *Trie, char word[]) {
    int length = strlen(word);
    char numpadDigit;
    int index;
    Trie_Node_t *trieNode;
    trieNode = Trie->root;
    for (int i = 0 ; i < length ; i++) {
        numpadDigit = charToDigit(word[i]);
        index = numpadDigit - '2';
        if (!trieNode->children[index]) {
            trieNode->children[index] = getNode();
        }
        trieNode = trieNode->children[index];
    }
    addWordToList(trieNode, word);
}

/*
addWordToList Function
This function accepts a node and adds the passed word
into the list of words for the corresponding node.
If the list already contains that word, it doesn do
anything
*/
void addWordToList(Trie_Node_t *node, char word[]) {
    if (!node) {
        return;
    }
    WordList *words = node->words;
    if (listContains(words, word)) {
        return;
    }
    if (!words) {
        node->words = getWordListNode(word);
        return;
    }
    WordList *curNode = words;
    while (curNode->next != NULL) {
        curNode = curNode->next;
    }
    curNode->next = getWordListNode(word);
}
/*
listContains Function
This function takes a pointer to a list and a word, 
and returns a boolean value based on whether the
word exists in the list or not.
*/
bool listContains(WordList *list, char *word) {
    WordList *cur = list;
    while (cur != NULL) {
        if (strcmp(cur->word, word) == 0) {
            return true;
        }
        cur = cur->next;
    }
    return false;
}

/*
searchWord Function
This function accepts a pointer to a trie and an array of
digits, and then searches for the digit in the trie passed
down to it, and then returns the corresponding WordList.
*/
WordList* searchWord(Trie_t *Trie, char digitSequence[]) {
    int sequenceLength = strlen(digitSequence);
    int index;
    int i;
    Trie_Node_t *trieNode;
    trieNode = Trie->root;
    for (i = 0 ; i < sequenceLength ; i++) {
        if (digitSequence[i] >= '2' && digitSequence[i] <= '9') {
            index = digitSequence[i] - '2';
            if (!trieNode->children[index]) {
                return NULL;
            }
            trieNode = trieNode->children[index];
        }
    }
    return trieNode->words;
}


/*
getNode Function
This function gets and returns a new trie node if memory
was correctly allocated.
*/
Trie_Node_t *getNode(void) {
    Trie_Node_t *newNode = NULL;
    newNode = (Trie_Node_t*)malloc(sizeof(Trie_Node_t));
    if (newNode) {
        for (int i = 0 ; i < NUM_SIZE ; i++) {
            newNode->children[i] = NULL;
        }
        newNode->words = NULL;
    } else {  // node creation failed
        fprintf(stderr, "Could not allocate memory for newNode");
        }
    return newNode;
}

/*
getWordListNode Function
This function accepts a word and returns a WordList node for
that corresponding word.
*/
WordList* getWordListNode(char word[]) {
    WordList *wordListNode = (WordList*)malloc(sizeof(WordList));
    wordListNode->word = (char*)malloc(sizeof(char)*strlen(word));
    strncpy(wordListNode->word, word, strlen(word));
    wordListNode->next = NULL;
    return wordListNode;
}

/*
freeNode Function
This function frees any memory allocated to all nodes.
*/
void freeNode(Trie_Node_t *node) {
    if (!node) {
        return;
    }
    // check for children and free
    // if necessary
    for (int i = 0; i < NUM_SIZE ; i++) {
        if (node->children[i]) {
            freeNode(node->children[i]);
        }
    }
    // delete node's linked list
    freeWordsList(node->words);
    // delete node
    free(node);
}

/*
freeWordsList Function
This function frees all allocated memory to the linked lists.
*/
void freeWordsList(WordList *words) {
    if (!words) {
        return;
    }
    WordList *cur = NULL;
    while (words) {
        cur = words->next;
        free(words->word);
        free(words);
        words = cur;
    }
}
