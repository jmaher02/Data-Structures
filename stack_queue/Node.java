/**  Node class implementation
 *    stores the Node's value and next pointer
 *    
 *    Implementation for integer values only
 *    
 *    @author Jillian Maher
 *    date  March 2, 2021
 */


public class Node 
{
	private int value;
	private Node next;
	
	public Node(int value)
	{
		this.value = value;
		next = null;
	}
	
	public Node(int value, Node nxt)
	{
		this.value = value;
		next = nxt;
	}
	
	// Update the next pointer
	public void setNext( Node next )
	{
		this.next = next;
	}
	
	// Access Node's value
	public int getValue()
	{
		return value;
	}
	
	// Access the next Node
	public Node getNext()
	{
		return next;
	}
	
	public String toString()
	{
		return "Node " + value; 
	}
}
