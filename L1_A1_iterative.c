/**Assignment1_1: Iterative version of a function which reads characters from
 * stdin until a newline character is read and then prints them
 * on stdout in reverse order.
 *
 * Author: M K Riaze Chowdhury
 * Course: ID1020_TCOMK_HT20
 */


#include <stdio.h>
#include <stdlib.h>

int main(void) {

	char s[11]; 						// create an array to save up to 10 char.
	int  index = 0;						// variable to keep track of no of text.
	printf("Insert up to 10 characters: \n");

	while(s[index-1] != '\n'){			//check if last inserted char. was a new line or not.
		s[index] = getchar();			//read new char.
		index++;						//increase char. count.
	}


	for (int i = index-1; i >=0; i--){ 	//print char. by iterating over the array backward, except 'new line'.
		putchar(s[i]);
	}

	printf("\n");
	return 0;
}
