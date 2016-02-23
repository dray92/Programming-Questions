/*
Vishesh Sood [1239599]
CSE 374 Homework 4
02/12/2016

t9.c

This is my implementation of T9 English in C. It allows
a user to pass in a dictionary as an argument, and use
T9 to find words. 
USAGE: ./t9 [DictionaryFile] ...
*/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <regex.h>
#include "t9.h"  // include header file

/*
main Function
This function takes in the expected arguments, which should
contain the dictionary file. It parses through the document,
and allows the user to search for words by entering numbers
from 2 to 9 and use the # key to shift between words. 
Users can exit by entering 'exit' or entering Control-D.

Returns 0 on completion, and other integers if error occured.
*/
int main(int argc, char** argv) {
    if (argc != 2) {
        fprintf(stderr, "USAGE: ./t9 [file]\n");
        return 0;
    }
    FILE* dictionary = fopen(argv[1], "r");
    char word[MAX_WORD_LENGTH];
    if (!dictionary) {
        fprintf(stderr, "File does not exist\n");
        return -1;
    }
    Trie_t *Trie = initializeTrie();
    while (fgets(word, MAX_WORD_LENGTH, dictionary)) {
        char *space = strstr(word, "\n");
        if (space) {
            *space = '\0';
        }
        insertWord(Trie, word);  // to build trie with words
    }
    fclose(dictionary);
    startUserInteractionSession(Trie);
    freeResources(Trie);
    return 0;
}

/*
startUserInteractionSession Function
This function initiates conversation between the user. It 
provides the user instructions regarding what to do. It uses
regex to validate input, and calls the search function to 
find the perfect word matching the user input.
Does not return anything.
*/
void startUserInteractionSession(Trie_t *Trie) {
    WordList* lastVisitedNodeWordList = NULL;
    printf("Enter \"exit\" to quit.\n");
    char *validationRegex = "^[2-9#|exit|^D]*$";
    while (true) {
        printf("Enter Key Sequence (or \"#\" for next word):\n> ");
        char userInput[MAX_WORD_LENGTH];
        scanf("%s", userInput);
        if (feof(stdin)) {
            free(validationRegex);
            return;
        }
        if (validateUserInput(userInput, validationRegex)) {
            if (strcmp(userInput, "exit") == 0) {
                return;
            }
            lastVisitedNodeWordList = search(Trie, userInput,
                                    lastVisitedNodeWordList);
            if (lastVisitedNodeWordList) {
                fprintf(stdout, "    \'%s\'\n", lastVisitedNodeWordList->word);
            }
        }
    }
}

/*
validateUserInput function
This function ensures that the user has entered acceptable input.
It makes sure the user hasnt used invalid characters using regex.
Takes the user input and a regular expresison string, and returns
whether it is acceptable or not.
*/
bool validateUserInput(char *userInput, char *validationRegex) {
    regex_t regex;
    int reti;
    reti = regcomp(&regex, validationRegex, 0);
    reti = regexec(&regex, userInput , 0, NULL, 0);
    if (!reti) {
        regfree(&regex);  // free memory from regex
        return true;
    } else if (reti == REG_NOMATCH) {
        printf("    Please enter values between 2-9 and #\n");
        regfree(&regex);
        return false;
    }
    return false;
}

/*
search Function
This function searches for the word in the trie built by the 
dictionary. It accepts a pointer to the trie, the word being
searched, and a node pointer to the last node that was pointed.
It returns a linked list of words that matched the pattern.
*/
WordList* search(Trie_t *Trie, char *searchSequence, WordList*
                                    lastVisitedNodeWordList) {
    char* hashChar = strstr(searchSequence, "#");  // get hashes
    if (!hashChar) {
        lastVisitedNodeWordList = searchWord(Trie, searchSequence);
        return lastVisitedNodeWordList;
    } else {
        if (searchSequence == hashChar) {
            if (strlen(searchSequence) == 1) {
                if (lastVisitedNodeWordList &&
                    lastVisitedNodeWordList->next) {
                    return lastVisitedNodeWordList->next;
                }
                printf("    There are no more T9onyms\n");
                return NULL;
            } else {
                printf("    Not found in current dictionary\n");
                return NULL;
            }
        } else {
            for (int i = strlen(searchSequence) - 1 ; i >=
                        (hashChar-searchSequence) ; i--) {
                if (searchSequence[i] != '#') {
                    fprintf(stderr, "Invalid T9 sequence found. ");
                    fprintf(stderr, "Resetting to default state...\n");
                    return NULL;
                }
            }
            lastVisitedNodeWordList = searchWord(Trie, searchSequence);
            int numHashes = strlen(hashChar);
            while (numHashes > 0) {
                if (!lastVisitedNodeWordList) {
                    printf("    There are no more T9onyms\n");
                    return NULL;
                } else {
                    lastVisitedNodeWordList = lastVisitedNodeWordList->next;
                }
                numHashes--;
            }
        }
        return lastVisitedNodeWordList;
    }
}

/*
freeResources Function
This function frees any trie nodes and the trie tree.
*/
void freeResources(Trie_t *Trie) {
    freeNode(Trie->root);
    free(Trie);
}
