/**Linked List with dummy node implementation
 *  List is singly-linked
 * 
 * The provided implementation uses the course provided
 *  List interface, implementing the following methods:
 *  - isEmpty 
 *  - size
 *  - add (end of list and insert)
 *  - remove (index and element)
 *  - duplicate (list and reversed)
 *  
 *  
 * @author Jillian Maher
 * date  2.1.2021
 * course  CSC 501
 * 
 */
public class LinkedList implements List 
{
	public Node head;
	public Node tail;
	public int size;

	public LinkedList()
	{
		head = new Node(null);
		tail = head;
		size = 0;
	}

	// returns true if the list is empty, false otherwise
	public boolean isEmpty() 
	{	
		return size == 0;
	}

	// returns the number of items in the list
	public int size() 
	{
		return size;
	}

	// adds an item to the list
	// precondition: none
	// postcondition: item is added at the end of the list
	public void add(Object item) 
	{
		Node newNode = (Node) item;
		tail.setNext( newNode );
		tail = newNode;
		size++;
	}

	// adds an item to the list at the given index
	// precondition: none
	// postcondition: item is added at the given index;
	// the indices of following items are increased by 1.
	// Assumes dummy head is index 0
	public void add(int index, Object item) 
	{
		if(index > size  || index <= 0)
			return;   //Prevent out of bounds issue
		
		Node current = head.getNext();
		Node previous = head;
		int count = 1;
		
		do
		{
			if(count == index)
			{
				Node insert = new Node(item);
				insert.setNext(current);
				previous.setNext( insert );
				size++;
				break;
			}
			count++;
			previous = current;
			current = current.getNext();
		}while(current != null);
	}
	
	// removes the item from the list that has the given index
	// precondition: none
	// postcondition: removes the first item in the list whose
	// index location matches that of the given item
	// Assumes dummy head is index 0
	public void remove(int index) 
	{
		if(index > size  || index <= 0)
			return;   //Prevent out of bounds issue
		
		Node current = head.getNext();
		Node previous = head;
		int count = 1;
		
		while(current != null)
		{
			if(count == index)
			{
				previous.setNext( current.getNext());
				size--;
				if(previous.getNext() == null)
				{
					tail = previous;
				}
				break;
			}
			count++;
			previous = current;
			current = current.getNext();
		}
	}

	// removes an item from the list
	// precondition: none
	// postcondition: removes the first item in the list whose
	// equal method matches that of the given item; the indices
	// of the following items are decreased by 1
	public void remove(Object item) 
	{
		Node current = head.getNext();
		Node previous = head;
		
		while(current != null)
		{
			if(current.getValue().equals(item))
			{
				previous.setNext( current.getNext());
				size--;
				if(previous.getNext() == null)
				{
					tail = previous;
				}
				break;
			}
			previous = current;
			current = current.getNext();
		}
	}

	// creates a duplicate of the list
	// precondition: none
	// postcondition: returns a copy of the linked list
	public List duplicate() 
	{
		LinkedList dup = new LinkedList();
		Node current = head.getNext();
		
		while(current != null)
		{
			Node node = new Node( current.getValue() );
			dup.add(node);
			current = current.getNext();
		}
		
		return dup;
	}

	// creates a duplicate of the list with the nodes in reverse
	// order
	// precondition: none
	// postcondition: returns a copy of the linked list with the
	// nodes in reverse order
	public List duplicateReversed() 
	{
		LinkedList dup = new LinkedList();
		Node current = head.getNext();
		
		duplicateReverseRecur( current, dup );
		
		return dup;
	}
	
	// helper method to traverse list in reverse
	private void duplicateReverseRecur( Node current, List list )
	{
		if( current != null )
		{
			duplicateReverseRecur(current.getNext(), list);
			list.add(new Node(current.getValue()));
		}
	}

	// generates printout of the list in the format
	// [ size: the_size_of_the_list - item1, item2, …. ]
	public String toString()
	{
		String output = "[ size: " + size + " - ";
		
		Node current = head.getNext();
		
		while(current != null)
		{
			output += current.getValue() + ", ";
			current = current.getNext();
		}
		
		return output.substring(0,output.length()-2) + " ]\n";
	}
}


/**  Node class implementation
 *    stores the Node's value and next pointer
 */
class Node 
{
	private Object value;
	private Node next;
	
	public Node(Object value)
	{
		this.value = value;
		next = null;
	}
	
	// Update the next pointer
	public void setNext( Node next )
	{
		this.next = next;
	}
	
	// Access Node's value
	public Object getValue()
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