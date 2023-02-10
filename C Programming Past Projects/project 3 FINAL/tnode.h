#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define MAXWORD 100


// tnode.h
//
// Contains all of the function prototypes
// and a node that holds information about
// a customer including ID, name, and balance.
//
// Richard Kim n00923815

int getword(char *, int);
struct tnode *addtree( struct tnode *, char *);
struct tnode *talloc(void);
char *strdupp( char *);
void treeprint( struct tnode *);
void treeprintfile( struct tnode *, FILE *);
void treeprintNOZERO( struct tnode *);
void treeprintfileNOZERO( struct tnode *, FILE *);
struct tnode *traversetree( struct tnode *, char *);
void changemoney( struct tnode *, char *, float, char );
void setname( struct tnode *, char *, char *);
float totalmoney( struct tnode *, float);
int repeatname( struct tnode *, char *, int);


struct tnode{
  char *id;            // The ID of a customer.
  char *name;          // Their first and last name.
  float money;         // Their balance.
  int count;           // How many times this node was called.
  struct tnode *left;  // Pointer to left tnode.
  struct tnode *right; // Pointer to right tnode.
};
