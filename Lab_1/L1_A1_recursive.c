/*
 ============================================================================
 Name        : L1_A1.c
 Author      : M K Riaze Chowdhury
 Version     : 1
 Description : Recursive version of a function which reads characters from
  	  	  	   stdin until a newline character is read and then prints them
  	  	  	   on stdout in reverse order.
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void reverse_recursively(void){
	char c = getchar();				//read new char.
	if (c != '\n'){					//check if inserted char. was a new line or not.
		reverse_recursively();
		putchar(c);					//
	}
}

int main(void) {
	reverse_recursively();
	return 0;
}
