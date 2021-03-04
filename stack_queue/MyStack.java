/** Stack Implementation using Linked Lists
 * 
 * @author Jillian Maher
 * date: March 2, 2021
 *
 */

public class MyStack 
{
	private Node top;
	private int size;
	
	/* Default constructor
	 * 
	 * Define an empty stack
	 */
	public MyStack()
	{
		top = null; 
		size = 0;
	}
	
	/* Pushes a new item onto the stack
	 * 
	 * @parameter value: the value of the new item
	 */
	public void push(int value)
	{
		Node newTop = new Node(value, top);
		top = newTop;
		size++;
	}
	
	/* View the item at the top of the stack; return -9999 if empty
	 * 
	 */
	public int peek()
	{
		if(!isEmpty())
		{
			return top.getValue();
		}
		return -9999;
	}
	
	/* Remove and return the top item of the stack; return -9999 if empty
	 * 
	 */
	public int pop()
	{
		if(!isEmpty())
		{
			int value = top.getValue();
			top = top.getNext();
			size--;
			return value;
		}
		return -9999;
	}
	
	/* Test to see if the stack is empty
	 * 
	 */
	public boolean isEmpty()
	{
		return top == null;
	}
	
	/* Returns the number of items in the stack
	 * 
	 */
	public int getSize()
	{
		return size;
	}
	
	/* Output Stack in the form [ Stack: bottom, next, ..., top]
	 * 
	 */
	public String toString()
	{
		String output = "[ Stack:  ";
		
		if(isEmpty())
		{
			return output + "]";
		}
		
		Node current = top;
		
		String stack = "";
		while(current != null)
		{
			stack = current.getValue() + ", " + stack;
			current = current.getNext();
		}
		
		return output + stack.substring(0,stack.length()-2) + " ]";
	}

}




