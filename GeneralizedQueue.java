/**Assignment1_5: This program implements a generalized queue which allows the user to remove the 
 * kth element from the queue. Assumed the most recently added element has index 1.
 *
 * Author: M K Riaze Chowdhury 
 * Course: ID1020_TCOMK_HT20
 */


import java.util.NoSuchElementException;

public class GeneralizedQueue<Item> {
	
	private Item [] queue;			//Array for the queue
	private int nofElement;			//Number of elements in the queue
	

	//Initializes an empty queue with 8 slots of type Object. 
	public GeneralizedQueue() {
		queue = (Item[]) new Object[2];
		nofElement = 0;
	}
	
	public boolean isEmpty() {
		return nofElement == 0;
	}
	
	public int size () {
		return nofElement;
	}
	private void reSizeArray(int newSize) {
		Item [] copy = (Item[])new Object[newSize];
		for (int i=0; i<nofElement; i++) {
			copy[i] = queue[i];
		}
		queue = copy;
	}
	
	public void enqueue(Item value) {
		if(nofElement == queue.length)			//double size of array if queue is full.	
			reSizeArray(2* queue.length);
		for(int i = nofElement; i>=1; i--) {
			queue[i] = queue[i-1];				//move all object by one index to make space for new element..
		}
		queue[0] = value;
		nofElement++;
	}
	
	//removes kth item 
	public void dequeue(int position) {
		if (isEmpty()||position > nofElement||position < 0 ) 
			throw new NoSuchElementException("Wrong position!");
		for (int i = position; i < queue.length; i++)
	     {
	         queue[i-1] = queue[i];              	//Move all objects to the right of the object
	         										//to be deleted to the left one index
	     }
		nofElement--;
		if(nofElement == queue.length/4)			//resize the array by half if no of element is 1/4th of array size.
			reSizeArray(queue.length/2);
	}
	public String toString(){
		String sb = "[";
		for (int i=0; i<=nofElement-1;i++ )
			sb += queue[i]+" ";
		sb += "]";
		return sb;
	}
		
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner (System.in);
		GeneralizedQueue<Integer> q = new GeneralizedQueue<Integer>();
		
		int[]   ints = { 1,2,3,4,5,6,7,8,9,10 };
		for (int i: ints)
			q.enqueue(i);
		
		System.out.print("After adding 10 elements, the queue is "+ q +'\n');
		
		
		//delete element from position 4
		q.dequeue(4);
		System.out.print("After deleting 4th element, the queue is "+ q +'\n');
		
		//try to delete element from a nonexistent  position 14
		//q.dequeue(14);
		
	}

}
	
