#include <stdio.h>
#define MAXLINE 1000

int kr_getline(char [], int);
int isAlphabetical(int, char []);
void removeWhitespace(int, char[]);
char toLowercase(char);
void result(int, char[]);


/**
Richard Kim n00923815
 */
int main(){
  char line[MAXLINE];      // The line of input.
  int isAlpha;             // The boolean to see if line is in order.
  int len;                 // Stores the length of the line of input.

  // While there still is content in the text file.
  while((len = kr_getline(line, MAXLINE)) > 0){

    // Returns 1 if alphabetical, 0 otherwise.
    isAlpha = isAlphabetical(len, line);

    // Prints the result if it is or is not alphabetical.
    // Ignores the line if it is blank.
    if(len != 1){
      result(isAlpha, line);
    }
  }
  
  return isAlpha;
}


/**
kr_getline

Gets a line of input from a text file.

@param char s[] The array to store the string.
@param int lim The max length of the string.

@return the length of the string.
 */
int kr_getline(char s[], int lim){
  int c, i;
  
  for(i = 0; i < lim - 1 && (c = getchar()) != EOF &&
	c != '\n'; ++i){
    s[i] = c;
  }

  
  if(c == '\n'){
    s[i] = c;
    ++i;
  }
  
  s[i] = '\0';

  return i;
}


/**
isAlphabetical

Gets input from a text file and determines if each line
is in alphabetical order or not.

@param int len The length of the input.
@param char line[] The line of input.
@return 1 if it is alphabetical, 0 otherwise.
 */
int isAlphabetical(int len, char line[]){
  int isAlpha;             // The boolean to see if line is in order
  char compare1, compare2; // The two characters that will be compared
  
  // Removes the endline character and any
  // whitespace at the end of the String.
  removeWhitespace(len, line);
  
  // By default, it is in order.
  isAlpha = 1;

  // Gets input from a file and stores length.  
  compare1 = line[0];
  compare2;
    
  // Goes through the char array. Once it finds a blank space,
  // it starts the comparison.
  for(int j = 1; j < len - 1; j++){
    if(line[j] == ' '){

      // The char after the blank line (the start of the word).
      compare2 = line[j + 1];

      // Converts to lowercase.
      compare1 = toLowercase(compare1);
      compare2 = toLowercase(compare2);
        
      // If the first letter of the previous word is larger,
      // then it breaks the for loop and sets boolean to false.
      if(compare1 > compare2){
	isAlpha = 0;
	j = len;
      }

      compare1 = compare2;
    }
  }
  
  return isAlpha;
}


/**
removeWhitespace

Removes the newline character and the
white spaces to get the line ready
for comparison.

@param int len The length of the text.
@param char line[] The line of text.
 */
void removeWhitespace(int len, char line[]){
  line[len - 1] = 0;

  int index = len - 2;

  while(line[index] == ' '){
    line[index] = 0;
    index--;
  }  
}


/**
toLowercase

Converts a char to lowercase using ASCII.

@param char character The char to convert to lowercase.
@return The lowercase char.
 */
char toLowercase(char character){
  if(character <= 90 && character >= 65){
     character += 32;
  }

  return character;
}


/**
result

Determines if the line of text
is in alphabetical order.

@param int isAlpha If it is 0, they are not in order.
                   If it is 1, they are in order.
@param char line[] The line of text.
 */
void result(int isAlpha, char line[]){
  if(isAlpha == 0){
    printf("%s%s%s\n", "The words in \"", line,
	   "\" are NOT in alphabetical order." );
  }
  else{
    printf("%s%s%s\n", "The words in \"", line,
	   "\" are IN alphabetical order." );
  }    
}
