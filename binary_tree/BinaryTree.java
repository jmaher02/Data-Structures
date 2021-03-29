/** Binary Tree Implementation
 * 
 * @author Jillian Maher
 * @date March 28, 2021
 *
 */

public class BinaryTree 
{
	private TreeNode root;
	private int size;

	public BinaryTree()
	{
		root = null;
		size = 0;
	}
	
	/*
	 * Add a new Node to the Tree with the given value
	 *   Only distinct values are added
	 */
	public void insert(int value)
	{
		root = insertRecur(value, root);
	}
	
	/*
	 * Helper method to recursively search through the tree
	 *    If the current node is null, add new Node to tree, end
	 *    Recursively call the the method with right or left node 
	 *       depending on value comparison 
	 *    End if current node data matches the value
	 */
	private TreeNode insertRecur(int value, TreeNode current)
	{
		if( current == null )
		{
			TreeNode next = new TreeNode(value);
			size++;
			return next;
		}
		else if( current.getItem() > value )  // Insert into left of current node
		{
			TreeNode child = insertRecur(value, current.getLeft());
			current.setLeft(child);
			return current;
		}
		else if( current.getItem() < value ) //Insert into right of current node
		{
			TreeNode child = insertRecur(value, current.getRight());
			current.setRight(child);
			return current;
		}
		else   //value already exists in Tree
		{
			return current;
		}		
	}
	
	/*
	 * Remove the TreenNode with the given value
	 *   If the value does not exist, output an Error
	 */
	public void delete(int value)
	{
		root = deleteRecur(value, root);
	}
	
	/*
	 * Helper method to recursively search through the tree
	 *    If the current node is null, delete value is not found
	 *    If value found, shift new Node into existing Node
	 *    If not found, search the left or right child Node
	 */
	private TreeNode deleteRecur( int value, TreeNode current)
	{
		if( current == null)
		{
			System.out.println("Error " + value + " Not Found");
			return null;
		}
		else if( current.getItem() == value)   //Found value to remove
		{
			//System.out.println("Value " + value + " Found");
			//Check for single child and return
			if(current.getLeft() == null)  //will also catch for no child, sets deleted node to null
			{
				size--;
				return current.getRight();
			}
			else if(current.getRight() == null)
			{
				size--;
				return current.getLeft();
			}
			//Remove value when there are two children
			else
			{
				//Get next value by moving one right then moving left as far as possible
				TreeNode temp = current.getRight();
				while( temp.getLeft() != null)
				{
					temp = temp.getLeft();
				}
				//Replace current data with next data, find and remove next data Node
				current.setItem( temp.getItem() );
				TreeNode deleteNext = deleteRecur( temp.getItem(), current.getRight() );
				current.setRight( deleteNext );
				return current;
			}
		}
		else if( current.getItem() > value)  //Continue searching into left node
		{
			//System.out.println("Search Left");
			TreeNode newLeft = deleteRecur( value, current.getLeft());
			current.setLeft(newLeft);
			return current;
		}
		else   //Continue searching into right node
		{
			//System.out.println("Search Right");
			TreeNode newRight = deleteRecur( value, current.getRight());
			current.setRight(newRight);
			return current;
		}
	}
	
	/*
	 * Set root to null, removing all existing values
	 */
	public void destroy()
	{
		root = null;
		size = 0;
	}
	
	/*
	 * Diagnostic output for the Binary Tree including
	 *   Size, Height, and Root Value
	 */
	public void diag()
	{
		System.out.print("Binary Tree |  isEmpty():" + isEmpty() + "  |  Size=" + getSize() + "  |  Height=" + getHeight() + "  |  Root Value=");
	
		if(root == null)
		{
			System.out.println(root);
		}
		else
		{
			System.out.println(root.getItem());
		}
		
	}
	
	/*
	 * Return the height of the Tree, the maximum level
	 */
	public int getHeight()
	{
		return heightRecur(root);
	}
	
	/*
	 * Helper method to recursively find each nodes level
	 *    and compare to calculate the maximum level
	 */
	private int heightRecur(TreeNode current)
	{
		if(current == null)
			return 0;
		else
			return 1 + Math.max(heightRecur(current.getLeft()), heightRecur(current.getRight()));
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	/*
	 * Traverse the tree such that, starting with the root
	 *   visit the node, recursively visit left, recursively visit right
	 */
	public void startPreorder()
	{
		preorder( root );
	}
	
	/*
	 * Recursive method for startPreorder
	 */
	private void preorder(TreeNode node)
	{
		if(node != null)
		{
			System.out.print( node.getItem() + " " );
			preorder( node.getLeft());
			preorder( node.getRight());
		}
	}

	/*
	 * Traverse the tree such that, starting with the root
	 *   recursively visit left, visit the node, recursively visit right
	 */
	public void startInorder()
	{
		inorder(root);
	}
	
	/*
	 * Recursive method for startInorder
	 */
	private void inorder(TreeNode node)
	{
		if(node != null)
		{
			inorder(node.getLeft());
			System.out.print( node.getItem() + " " );
			inorder(node.getRight());
		}
	}
	
	/*
	 * Traverse the tree such that, starting with the root
	 *   recursively visit left, recursively visit right, visit the node
	 */
	public void startPostorder()
	{
		postorder(root);
	}
	
	/*
	 * Recursive method for postorder
	 */
	private void postorder(TreeNode node)
	{
		if( node != null)
		{
			postorder(node.getLeft());
			postorder(node.getRight());
			System.out.print(node.getItem() + " ");
		}
	}
	
	/*
	 * Return the Node with the given value
	 *    If node does not exist, returns null
	 */
	public TreeNode search(int value)
	{
		return searchRecur(value, root);
	}
	
	/*
	 * Helper method to recursively search through the tree
	 *    If the current node is null, delete value is not found
	 *    If value found, shift new Node into existing Node
	 *    If not found, search the left or right child Node
	 */
	private TreeNode searchRecur( int value, TreeNode current)
	{
		if( current == null)
		{
			//System.out.println("Error " + value + " Not Found");
			return null;
		}
		else if( current.getItem() == value)   //Found value to remove
		{
			return current;
		}
		else if( current.getItem() > value)  //Continue searching into left node
		{
			return searchRecur( value, current.getLeft() );
		}
		else   //Continue searching into right node
		{
			return searchRecur( value, current.getRight());
		}
	}
	
	public String toString()
	{
		return "Binary Tree with root: " + root + " size: " + size;
	}
}
