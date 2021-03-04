/** Queue Implementation using Linked Lists
 * 
 * @author Jillian Maher
 * date  March 2, 2021
 *
 */

public class MyQueue 
{
	private Node front;
	private Node back;
	private int size;
	private int limit;
	
	/* Default constructor
	 * 
	 * Define an empty queue, with 10 item limit
	 */
	public MyQueue()
	{
		front = null;
		back = null;
		size = 0;
		limit = 10;
	}
	
	/* Initialization constructor
	 * 
	 * Define an empty queue, with @parameter capacity as the limit
	 */
	public MyQueue(int capacity)
	{
		front = null;
		back = null;
		size = 0;
		limit = capacity;
	}
	
	/* Add a new item to the rear of the queue
	 * 
	 * @parameter value: the value of the new item
	 * 
	 */
	public void enqueue(int value)
	{
		if(isEmpty())
		{
			Node start = new Node(value);
			front = start;
			back = start;
			size++;
		}
		else if(size < limit)
		{
			Node end = new Node(value);
			back.setNext(end);
			back = end;
			size++;
		}
		else
		{
			System.out.println("Queue is full");
		}
	}
	
	/* Remove item from the front of the queue; return -9999 if empty
	 * 
	 */
	public int dequeue()
	{
		if(!isEmpty())
		{
			int value = front.getValue();
			front = front.getNext();
			size--;
			if(isEmpty())
			{
				back = null;
			}
			return value;
		}
		return -9999;
	}
	
	/* View the item at the front of the queue; return -9999 if empty
	 * 
	 */
	public int peek()
	{
		if(!isEmpty())
		{
			return front.getValue();
		}
		return -9999;
	}
	
	/* Test to see if the queue is empty
	 * 
	 */
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/* Test to see if the queue is at capacity
	 * 
	 */
	public boolean isFull()
	{
		return size == limit;
	}
	
	/* Returns the number of items currently in the queue
	 * 
	 */
	public int getSize()
	{
		return size;
	}
	
	/* Returns the total possible number of items in the queue
	 * 
	 */
	public int getCapacity()
	{
		return limit;
	}
	
	/* Output Queue in the form [ Queue: front, next, ..., back]
	 * 
	 */
	public String toString()
	{
		String output = "[ Queue:  ";
		
		Node current = front;
		
		while(current != null)
		{
			output += current.getValue() + ", ";
			current = current.getNext();
		}
		
		return output.substring(0,output.length()-2) + " ]";
	
	}
}
