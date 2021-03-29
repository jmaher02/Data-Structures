// TreeNode class, store data about a single Node for a BST
// 
// Class provided by the course

public class TreeNode {
	private int item;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int newitem) {
		item = newitem;
		left = null;
		right = null;
	}
	
	public TreeNode(int newItem, TreeNode newLeft, TreeNode newRight){
		item = newItem;	
		left = newLeft;    //Added by student
		right = newRight;    //Added by student
	}
	
	public int getItem() {
		return item;
	}
	
	public void setItem(int newItem) {
		item = newItem;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public TreeNode getRight() {
		return right;
	}
	
	public void setLeft(TreeNode newLeft) {
		left = newLeft;
	}
	
	public void setRight(TreeNode newRight) {
		right = newRight;
	}
	
}
