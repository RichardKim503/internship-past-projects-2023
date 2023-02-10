#include "tnode.h"


/**
getword

A modified version of the getword function
from the textbook.

This function gets a word from std input.

@param word The word to receive and initialize to from std input.
@param lim The max length of the word.
@return The length of the word.

Richard Kim n00923815
 */
int getword(char *word, int lim){
  int c;
  char *w = word;
  
  while(isspace(c = getchar()))
    ;
  //printf("%s\n", "here");
  if(c != EOF)
    *w++ = c;
  if(!isalnum(c) && c != 46){

    *w = '\0';
    return c;
  }
  
  for( ; --lim > 0; w++)
    if(!isalnum(*w = getchar())){
      if(*w != 46){
	ungetc(*w, stdin);
	break;
      }
  
    }
  *w = '\0';

  //printf("%d\n", isspace());
  return word[0];
  //printf("%d\n", MAXWORD - lim);
  //printf("%d\n", lim);
  //return MAXWORD - lim;
}
