/**Assignment1_2: This program implements an recursive version in JAVA which reads 
 * characters from stdin until a newline character is read and then prints them on
 *  stdout in reverse order.
 *
 * Author: M K Riaze Chowdhury 
 * Course: ID1020_TCOMK_HT20
 */

import java.util.Scanner;
import java.util.Locale; // Scanner , Locale

public class Recursive {
	public static void main(String[] args) {
		
		
		//input tools
		Scanner in = new Scanner(System.in);
		in.useLocale (Locale.US);
		
		System.out.println("Type some characters \n");
		
		char input;
		boolean done = false;
		String str = "";
	    while (!done){
	    	try {
	    		input =(char) System.in.read();
			    if (input == '\n')
			       done = true;
			    else
			    	str += input;
	    	}
		    catch(java.io.IOException e){
		    	 done = true;
		    }
		 }
		
		
		//char s = in.next().charAt(0);
		String result = recursive1(str);
		System.out.println(result);
	}

	public static String recursive1(String s) {

		if (s .isEmpty()) {
			//subStr = s.substring(1);
			//recursive1(s.substring(1),x);	
			return s;
		}
		
		String x = recursive1(s.substring(1)) + s.charAt(0);
		return x ;

		
			
	}

}
