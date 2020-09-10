/**Assignment1_4: This program implements a generic iterable circular linked list in
 * which elements can be inserted and removed to/from the front and back end of the queue. 
 * At the end a unit test is implemented.
 *
 * Author: M K Riaze Chowdhury  
 * Course: ID1020_TCOMK_HT20
 */



import java.util.NoSuchElementException;
import java.util.Iterator;

public class CirculerLinkedList<Item> implements Iterable<Item> {
	
	public Node<Item> head;         //Starting flag 
	public int  n;					//Number of item on the list.
	
	//Node object to hold an item value and a link to next node.
	@SuppressWarnings("hiding")
	private class Node<Item>{
		Node<Item> next;
		Item value;
		
		//object constructor.
		public Node (Item value) {
			this.value = value;
		}
	}
	
	//Initialization of the list.
	public CirculerLinkedList() {
		head = null;
		n = 0;
	}
	
	/***********************************************************
	 * method to check if the stack is empty or not.
	 * true if stack is full else false.
	 **********************************************************/
	public boolean isEmpty() {
		return n == 0;
	}
	
	//return total number of item in stack.
	public int size() {
		return n;
	}

	/** Add value to the start of this list.
	 * 	@param value The value of the item.
	 */
	public void addFirst (Item value) {
		Node<Item> oldFirst = head;
		head = new Node<Item>(value);  	//Make a new node using @param value as head 
										//of the list
		if (isEmpty()) {
			head.next = head;			//If this is the first element then it points to 
										//itself to make it circular.
		}
		else {
			Node<Item> node = oldFirst;	//search for the last node of the list. 
			do {
				node = node.next;
			} while (node.next != oldFirst);
			node.next = head;			//Last node points to new head node as next.
			head.next = oldFirst;		//New head node points to old head node as next.
		}
	
		n++;							//increment of number of elements.
	}
	
	public void addLast (Item value) {
		Node<Item> newNode = new Node<Item>(value);
		if (isEmpty()) {
			head = newNode;
			head.next = head;			//If this is the first element then it points to 
										//itself to make it circular.
		}
		else {
			Node<Item> node = head;
			do {
				node = node.next;		//search for the last element of the list.
			} while (node.next != head);
			newNode.next = head;		//New node points to head to make it circular.
			node.next = newNode;		//Push the old last as second last.
		}
		n++;							//increment of number of elements.
	}
	
	public Item removeFirst() {
		if (isEmpty()) 
			throw new NoSuchElementException();
		Item value = head.value;		//take out the removed element.
		if (head.next == head) {
			head = null;				//if only one element then it makes the list empty 
		}
		else {
			Node<Item> node = head;		//search for the last node of the list. 
			do {
				node = node.next;		
			} while (node.next != head);
			
			node.next = head.next;		//Last node points to second node.
			head = head.next;			//update second node as new head.
		}
		n--;
		return value;
	}
	
	public Item removeLast() {
		if (isEmpty()) 
			throw new NoSuchElementException();
		Item value ;
		if (head.next == head) {		//if only one element then it makes the list empty 
			value = head.value;			//take out the removed element.
			head = null;
		}
		else {
			Node<Item>  node = head;	//Search for the second last node.
			Node<Item>  lastNode; 
			/*****************************************************************************
			 * At the beginning node points to head and lastNode point to second node.
			 * At the end of the iteration lastNode point to the last node and node points 
			 * to second last node
			 *****************************************************************************/
			do {
				node = node.next;		
				lastNode = node.next;
			} while (lastNode.next != head);
			value = lastNode.value;		//take out the removed element
			node.next = head;			//update the link between new last node and head.
		}
		n--;
		return value;
	}
	
	// Method that returns a string representation of the elements
	public String toString() {
		String sb = "[";
		for (Item value : this)
			sb += value.toString()+" ";
		sb += "]";
		return sb;
	}
	
	/***********************************************************
	 * Returns an iterator to this stack that iterates through
	 *  the elements.
	 ************************************************************/
	public Iterator<Item> iterator(){
		return new CirculerLinkedListIterator();
	}
	
	private class CirculerLinkedListIterator implements Iterator<Item> {
		private Node <Item> current = head;
		private boolean endList = false; 
		
		/*****************************************************************************
		 * Method checks weather there is any element on the list or iterator 
		 * has iterated through the whole list
		 *****************************************************************************/
		public boolean hasNext() {
			if( current ==null)
				return false;
			return ((current != head) || (!endList));
		}
		
		//Method that return current element and iterates to the next element in the queue
		public Item next() {
			if(current.next == head)
				endList = true;
			Item value = current.value;
			current = current.next; 
			return value;
		}
	}
	public static void main(String[] args) {
		CirculerLinkedList <Integer> circulerLinkedList = new CirculerLinkedList<Integer>();
		//test of addFirst methode:
		int[]   ints = { 1,2,3,4,5,6,7,8,9,10 };
		for (int i: ints)
			circulerLinkedList.addFirst(i);
		System.out.print("After adding 10 elements from front, the list is "+ circulerLinkedList+'\n');
		
		int[]   ints2 = { 11,12,13,14,15,16,17,18,19,20 };
		for (int i: ints2)
			circulerLinkedList.addLast(i);
		System.out.print("After adding 10 elements from back, the list is "+ circulerLinkedList+'\n');
		
		for(int i=0; i<=9; i++) {
			circulerLinkedList.removeLast();
		}
		System.out.print("After removing 10 elements from back, the list is "+ circulerLinkedList+'\n');
		
		for(int i=0; i<=9; i++) {
			circulerLinkedList.removeFirst();
		}
		System.out.print("After adding elements from front, the list is "+ circulerLinkedList +'\n');
		
		circulerLinkedList.addFirst(1);
		System.out.print("After adding single element, the list is "+ circulerLinkedList+'\n');

		circulerLinkedList.removeFirst();
		System.out.print("After removing single element, the list is "+ circulerLinkedList+'\n' );
		
		circulerLinkedList.addLast(1);
		System.out.print("After adding single element from back the list is "+ circulerLinkedList+'\n' );

		circulerLinkedList.removeLast();
		System.out.print("After removing single element from back the list is"+ circulerLinkedList +'\n');
	}

}
