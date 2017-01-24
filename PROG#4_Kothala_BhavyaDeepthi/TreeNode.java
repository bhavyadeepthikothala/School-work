
public class TreeNode
{
	public int value;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int newItem) 
	{
		// Initializes tree node with item and no children (a leaf).
		value = newItem;
		left  = null;
		right = null;
	}  // end constructor
	
	public TreeNode(int newItem, TreeNode leftChild, TreeNode rightChild) 
	{
		// Initializes tree node with item and
		// the left and right children references.
		value = newItem;
		left  = leftChild;
		right = rightChild;
	}  // end constructor
}
