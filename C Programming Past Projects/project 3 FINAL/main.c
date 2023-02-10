#include "tnode.h"
#include <fcntl.h>

/**
main

Stores and manages information from an index card that
contains four pieces of infomation about a customer:
ID, Name, add or subtract money, total money/balance.
The code uses a binary search tree to store and
organize the data. Reads from input.

TODO:
you only have to read in input that looks like:
444 Richard Kim $123.45
probably should do that after

redirect output using a separate function in tnode.c

*--argv[0]

Richard Kim n00923815
 */
int main(int argc, char *argv[]){
  struct tnode *root;   // The root node.
  char word[ MAXWORD ]; // The word from input.
  int proceed = 0;      // Determines what to do with input.
  char *id;             // The ID of a customer.
  char nextchar;        // Temporary variable to see char 1 space after node.
  char nextcharafter;   // Temporary variable to see char 2 spaces after node.
  root = NULL;          // Initialize root to NULL, so it's an empty tree.

  int inputswitch = 0; // for -i
  char *inputfilename = " ";
  char inputline[ 100 ]; // read in a line of input

  int outputswitch = 0; // for -o
  char *outputfilename = "customer.txt"; // default output file name
  
  int allowzero = 0; // for -z
  int c;
  
  char command; // the command to process

  int segmentationtest = argc - 1;

  // iterates through all arguments
  for(int i = 1; i < argc; i++){

    if(argv[i][0] == '-'){
      command = argv[i][1];
      switch(command){
      case 'i':
	if(i == segmentationtest){
	  fprintf(stderr, "%s\n", "seg for -i");
	  exit(0);
	}
	else{
	  inputfilename = argv[i+1];

	  if(inputfilename[0] == '-'){
	    fprintf(stderr, "%s\n", "Must have a file name after -i");
	  }
	  else{
	    inputswitch = 1;
	  }
	}
      case 'o':
	if(i == segmentationtest){
	  fprintf(stderr, "%s\n", "seg for -o");
	  exit(0);
	}
	else{
	  outputfilename = argv[i+1];

	  if(outputfilename[0] == '-'){
	    fprintf(stderr, "%s\n", "Must have a file name after -o");
	  }
	  else{
	    outputswitch = 1;
	  }
	}
	
	break;
      case 'z':
	allowzero = 1;
	break;
      }
    }
  }
  



  // While there is still input.
  while( getword(word, MAXWORD) != EOF ){

    // Gets ID, must be numerical
    if(proceed == 0){
      if( isdigit( word[0] ) && word[3] == 0){
	if(word[0] != 46) {
	  root = addtree(root, word);
	}

	// Copies the ID and proceeds
	proceed = 1;
	id = strdupp(word);
      }
      // If it is not a numeric ID.
      else{
	nextchar = getchar();
	nextcharafter = getchar();

	if(isalpha(nextcharafter)){
	  fprintf(stderr, "%s%s%s\n", word,
		  " - Invalid line, must start with numeric ID",
		  " or numeric value found without W or P");
	}

	ungetc(nextcharafter, stdin);
	ungetc(nextchar, stdin);
      }
    }

    // Goes here once ID is received.
    else if(proceed == 1){
      // If it is W
      if(word[0] == 87 && word[1] == 0){
	proceed = 2;

	nextchar = getchar();
	nextcharafter = getchar();

	// Error checks to make sure there is a number right after W
	if(nextchar == '\n' || nextcharafter == '\n'){
	  fprintf(stderr, "%s%s\n", word,
		  " - Invalid line, must be a number after W");
	  proceed = 0;
	}
	if(isalpha(nextcharafter)){
	  fprintf(stderr, "%s%s\n", word,
		  " - Invalid line, there is a letter after W");
	  proceed = 0;
	}
	if(nextcharafter == ' '){
	  fprintf(stderr, "%s%s\n", word,
		 " - Invalid line, there are too many spaces after W");
	  proceed = 0;
	}

	ungetc(nextcharafter, stdin);
	ungetc(nextchar, stdin);
      }
      // If it is P
      else if(word[0] == 80 && word[1] == 0){
	
	nextchar = getchar();

	// If it is only P with no value, remove balance.
	if(nextchar == '\n' || nextchar == -1){
	  proceed = 4;
	  changemoney(root, id, strtof(word, NULL), '*');
	}
	else if(nextchar == ' '){
	  proceed = 3;
	}
	
	ungetc(nextchar, stdin);
      }
      // If it is a number, reset because must be W, P, or name after ID.
      else if(word[0] >= 48 && word[0] <= 57){
	fprintf(stderr,
		"%s%s\n", word, " - Invalid line, must be W, P, or name after ID");
	proceed = 0;
      }
      // If it is a name.
      else{
	
	char *name = strdupp(word);
	int result;
	strcat(name, " ");
	
	getword(word, MAXWORD);
	strcat(name, word);

	// If the name already exists.
	result = repeatname(root,id,result);
	if(result == 1){
	  fprintf(stderr, "%s%s\n", name,
		  " - Name already exists or is stored as something else");
	}
	if(result == 0){
	  setname(root, id, name);
	}
	
	proceed = 1;

      }
      
    }
    // If it was 'W'
    else if(proceed == 2){

      nextchar = getchar();

      // Checks to make sure that a nothing exists after line of input.
      if(nextchar != '\n'){
	getword(word, MAXWORD);
	fprintf(stderr, "%s%s\n", word,
		" - Invalid input, cannot be anything after an amount is called.");
	proceed = 0;
      }
      // Adds money to the balance
      else{
	changemoney(root, id, strtof(word, NULL), '+'); 
      }

      ungetc(nextchar, stdin);

      // Resets and goes to next line of input
      proceed = 0;

    }
    // If it was 'P' with numeric value
    else if(proceed == 3){
      
      nextchar = getchar();

      // Checks to make sure that nothing exists after line of input.
      if(nextchar != '\n'){
	getword(word, MAXWORD);
	fprintf(stderr, "%s%s\n", word,
		" - Invalid input, cannot be anything after an amount is called.");
	proceed = 0;
      }
      // Subtracts money from balance.
      else{
	changemoney(root, id, strtof(word, NULL), '-'); 
      }

      ungetc(nextchar, stdin);

      // Resets and goes to next line of input
      proceed = 0;
    }
    // If it is 'P' with nothing else, remove balance.
    else if(proceed == 4){
      changemoney(root, id, strtof(word, NULL), '*');
      proceed = 0;
    }
  }




  FILE *inputfile = fopen(inputfilename, "r");
  FILE *outputfile = fopen(outputfilename, "w");

  
  if(inputswitch == 1){

    while( fgets(inputline, 99, inputfile) != NULL){
      fprintf( outputfile, "%s", inputline);
    }

    
  }
  
  // IF -Z DOES NOT EXIST
  if(allowzero == 0){
     treeprintfileNOZERO(root, outputfile);
  }
  // IF -Z EXIST
  else if(allowzero == 1){
     treeprintfile(root, outputfile);
  }



  

  

  printf("%s%.2f\n","Total $", totalmoney(root, 0.0));

  

}
