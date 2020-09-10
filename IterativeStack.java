/**Assignment1_2: This program implements an iterative version in JAVA which reads 
 * characters from stdin until a newline character is read and then prints them on
 *  stdout in reverse order.
 *
 * Author: M K Riaze Chowdhury 
 * Course: ID1020_TCOMK_HT20
 */


import java.util.NoSuchElementException;
import java.io.*;
import java.util.Iterator;

public class IterativeStack<Item> implements Iterable<Item> {
	private Node<Item> top;     // representing the most recently added item into stack
	private int nofItem;		// total number of item in stack.
	
	
	//Node object to hold an item value and a link to next node.
	private class Node <Item> {
		public Item value;
		public Node<Item> next;
		
		//object constructor.
		public Node (Item value){
			this.value = value;
		}
		
		//method to create link between two nodes.
		void setNext(Node<Item> node) {
			this.next = node;
		}
		
		//method to get value of a node.
		Item getItem() {
			return value;
		}
	}
	
	//Initialization of the list.
	public IterativeStack() {
		top = null;
		nofItem = 0;
	}
	
	//method to add item into stack.
	public void push(Item value) {
		Node<Item> node = new Node <Item>(value);  
		Node<Item> tempNode;

		if (nofItem == 0)
			top = node;
		else {
			tempNode = top;
			top = node;
			top.setNext(tempNode);
		}
		nofItem++;
	}
	
	//remove the most recently added node and return the value of that node.
	public Item pull() {
		if (isEmpty()) {
			throw new NoSuchElementException ("stack is empty");
		}
									
		Item tempNode = top.getItem() ;		//save the most recently added node's value.
		top = top.next;						//set the next node as top.
		nofItem--;
		return tempNode;					//return saved value.
		
	}
	/***********************************************************
	 * method to check if the stack is empty or not.
	 * true if stack is full else false.
	 **********************************************************/
	public boolean isEmpty() {
		return nofItem == 0;
	}
	
	//return total number of item in stack.
	public int size() {
		return nofItem;
	}
	
	/***********************************************************
	 * Returns an iterator to this stack that iterates
	 * through the items in LIFO order.
	 ************************************************************/
	public Iterator<Item> iterator() {
		return new ItemsIterator(top);
	}
	
	private class ItemsIterator implements Iterator<Item> {
		private Node<Item> current;
		
		public ItemsIterator(Node <Item>top) {
			current = top;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) 
				throw new NoSuchElementException();
			Item value = current.value;
			if (current.next!=null) {
				current = current.next;
			}
			return value;
		}

	}

	public static void main(String[] args) throws IOException {
		
		//initialize a iterableStack as a character type stack.
		IterativeStack <Character> iterableStack = new IterativeStack<Character>();

		System.out.println ("Please enter your characters: ");
		/*******************************************************************
		 * input tools 
		 * read character until a character is available, an I/O error occurs,
		 * or the end of the stream is reached
		 ***************************************************************** */
		char input;
		boolean done = false;
	    while (!done){
	    	try {
	    		input =(char) System.in.read();
			    if (input == '\n')
			       done = true;
			    else
			    	iterableStack.push(input);
	    	}
		    catch(java.io.IOException e){
		    	 done = true;
		    }
		 }
		 
		
		System.out.println("Here is the string in reversed order:");
		for(char c :iterableStack ) {
			while(!iterableStack.isEmpty())
			System.out.print(iterableStack.pull());
			if (iterableStack.isEmpty()) break;
		}
		
		System.out.println();
	}

	
}
