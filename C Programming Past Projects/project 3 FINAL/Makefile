all: main.o getword.o tnode.o
	gcc main.c getword.o tnode.o -o work
	
main.o: getword.c tnode.c tnode.h
	gcc -c main.c

getword.o:
	gcc -c getword.c
	
tnode.o: tnode.h
	gcc -c tnode.c
	
clean:
	-rm -f work *.o core
