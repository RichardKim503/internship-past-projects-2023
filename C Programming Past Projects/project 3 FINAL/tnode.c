#include "tnode.h"


/**
tnode.c

Contains the functions needed to add a new
customer, alter their information, and
display their information.

Richard Kim n00923815
 */


/**
addtree

Adds a new node to the tree with the ID.

@param p The node to add, which will be the root.
@param w The piece of information to add.
@return The node that is added.
 */
struct tnode *addtree( struct tnode *p, char *w ){
  int cond;

  if(p == NULL){
    p = talloc();
    if(p != NULL){
      p->id = strdupp(w);
      p->count = 1;
      p->name = "<no name>";
      p->left = p->right = NULL;
    }
  }
  else if((cond = strcmp(w, p->id)) == 0)
    p->count++;
  else if(cond < 0)
    p->left = addtree(p->left, w);
  else
    p->right = addtree(p->right, w);
    
  return p;
}


/**
talloc

Allocates memory to a tnode struct.
 */
struct tnode *talloc( void ){
  return (struct tnode *)malloc(sizeof(struct tnode));
}


/**
strdupp

Allocates memory for a duplicate of a string
and returns it.

@param s The string to duplicate
@return The duplicated string.
 */
char *strdupp( char *s ){
  char *p;

  p = (char *)malloc(strlen(s) + 1);
  if(p != NULL)
    strncpy(p, s, strlen(s));
  return p;
}


/**
treeprint

Prints what the tree looks like in order. An ID, a name,
and the balance from each tnode will be printed.

@param p A node, which would be the root.
 */
void treeprint( struct tnode *p){
  if(p != NULL){
    treeprint(p->left);
    printf("%s%s%s%s%.2f\n", p->id," ", p->name," $", p->money);
    treeprint(p->right);
  }
}

void treeprintfile( struct tnode *p, FILE *fp){
  if(p != NULL){
    treeprintfile(p->left, fp);
    fprintf(fp, "%s%s%s%s%.2f\n", p->id," ", p->name," $", p->money);
    treeprintfile(p->right, fp);
  }
}


void treeprintNOZERO( struct tnode *p){
  
  if(p != NULL){
    treeprintNOZERO(p->left);

    if(p->money != 0){
      printf("%s%s%s%s%.2f\n", p->id," ", p->name," $", p->money);
    }
   
    treeprintNOZERO(p->right);
  }
  
}


void treeprintfileNOZERO( struct tnode *p, FILE *fp){
  if(p != NULL){
    treeprintfileNOZERO(p->left, fp);
    if(p->money != 0){
      fprintf(fp, "%s%s%s%s%.2f\n", p->id," ", p->name," $", p->money);
    }
    treeprintfileNOZERO(p->right, fp);
  }
}


/**
traversetree

Traverses through the binary tree to search for a node.

@param p The initial node, or the root node.
@param s The ID of the node to search for.
@return The node if it is found.
 */
struct tnode *traversetree( struct tnode *p, char *s ){
  
  if(p != NULL){

    if(strcmp(s, p->id) == 0)
      return p;
    
    traversetree(p->left, s); 

    traversetree(p->right, s);
  }
}


/**
changemoney

Changes the balance based on the parameter.
Also prints changes made to balance.

@param p The initial node, which is the root node.
@param s The ID of the node to change to balance for.
@param amount The amount of money to add or subtract from the balance.
@param key If the key +, add. If the key is -, subtract.
If the key is *, the clear the balance.
 */
void changemoney( struct tnode *p, char *s, float amount, char key ){
  if(p != NULL){
    
    changemoney(p->left, s, amount, key);

    changemoney(p->right, s, amount, key);

    if(strcmp(s, p->id) == 0){
      
      if(key == '+'){
	p->money += amount;
	
	printf("%s%s%s%s", p->id, " ", p->name, " ");
	printf("%s%.2f", "+$", amount);
	printf("%s%.2f\n", " $", p->money);

      }
      else if(key == '-'){
	p->money -= amount;

	printf("%s%s%s%s", p->id, " ", p->name, " ");
	printf("%s%.2f", "-$", amount);
	printf("%s%.2f\n", " $", p->money);
      }
      else if(key == '*'){

	printf("%s%s%s%s", p->id, " ", p->name, " ");
	printf("%s%.2f", "-$", p->money);
	printf("%s\n", " $0.00");

	p->money = 0;
      }
      
    }
    
  }
}


/**
setname

Sets or changes the name of the specific node.

@param p The initial node, or the root.
@param s The ID to change the name.
@param fullname What to change the name to.
 */
void setname( struct tnode *p, char *s, char *fullname ){
  if(p != NULL){
    setname( p->left, s, fullname );

    if(strcmp(s, p->id) == 0 ){
      p->name = fullname;
    }
   
    setname( p->right, s, fullname );
  }
}


/**
totalmoney

Adds up the sum of all balances and returns it.

@param p The initial node, or the root.
@param result The sum of all balances.
 */
float totalmoney( struct tnode *p, float result ){
  
  if(p != NULL){
    result +=  p->money;
    
    result = totalmoney( p->left, result );
    
    result = totalmoney( p->right, result );

  }

  return result;
}

/**
repeatname

Checks to see if a name has been repeated or not.

@param p The initial node, or the root,
@param s The ID to check
@return result 1 if a name already exists, 0 if not.
 */
int repeatname( struct tnode *p, char *s, int result){
  
  if(p != NULL){
    result = repeatname( p->left, s, result);

    if(strcmp(s, p->id) == 0 ){
      if(strcmp(p->name, "<no name>") != 0){
	return 1;
      }
      else{
	return 0;
      }
    }

    result = repeatname( p->right, s, result);
  }  
}
