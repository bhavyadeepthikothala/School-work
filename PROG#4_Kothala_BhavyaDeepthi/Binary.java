/****************************************************************************************************************************
 * Author: Bhavya Deepthi Kothala
 * Problem: Given an array, Conevrt that array into a binary search tree and print that tree level by level and check whether
 *          that tree is balanced or not
 * solution:
 *       Converting an array to a binary search tree
 *       1. As the given array is in pre order traversal of the tree, the first element of the array becomes the root of the 
 *           tree
 *       2. Now as we have the root of the tree compare the root value with every element of the array and decide whether it 
 *          goes to the right side of the tree or the left side of the tree
 *       3. Once we have child nodes for the root we will have the left subtree and right subtree we continue doing the step
 *          2, for every subtree and insert the elements of the array as the child nodes on either of the subtrees
 *       
 *       Printing the tree level by level
 *       1. add the node to a queue 
 *       2. remove the node from the queue
 *       3. print the value in the current polled node of the queue
 *       4. add the left and right children to the queue
 *       5. repeat the above steps until all the queue is empty
 *       
 *       Check if the given tree is balanced or not
 *       1. get the height of left subtree
 *       2. get the height of right subtree
 *       3. if the difference between the heights of left subtree and right subtree is greater than one, the tree is siad to
 *          be unbalanced. Otherwise it is balanced    
 *           
 ****************************************************************************************************************************/




import java.util.LinkedList;
import java.util.Queue;


public class Binary 
{
	public static void main(String[] args)
	{
		int[] arr = { 10, 5, 1, 7, 40, 35, 80, 100};
		
		//convert the above array to Binary Search tree
		TreeNode root = BST(arr);
		
		System.out.println("the first answer is:");
		// Print the elements of the tree  
		printTree(root);
		
		System.out.println("\n\nthe second answer is:  \n");
		// Print a given tree level by level
		printTreeLevel(root);
		
		System.out.println("\n\nthe third answer is: \n");
		// check if the tree is balanced
		if(checkBalance(root))
		{
			System.out.println("the tree is balanced binary search tree");
		}
		else
		{
			System.out.println("the tree is not a balanced binary search tree");
		}
	}
	
	// Method to construct a Binary Search Tree from the array
	public static TreeNode BST(int[] arr)
	{
		// The first element of the array will be the root because the given array is in pre order traversal of tree
		TreeNode root = new TreeNode(arr[0]);
		
		TreeNode current = root;
		// go through the entire array starting from the second element of the array  and insert them in the tree
		for(int i= 1; i < arr.length; i++)
		{
			
			while(current != null )
			{
				// check if the array element is less than the current node value 
				if(arr[i] <= current.value)
				{
					// and the current node doesnot have any left child create new left chid and link it to the current node
					if(current.left == null)
					{
						TreeNode leftChild = new TreeNode(arr[i]);
						current.left = leftChild;
						break;
						
					}
					else
					{
						// make the left child the current node
						current = current.left;
					}
				}
				// if the array element is greater than the current node value
				else if(arr[i] > current.value)
				{
					// and the current node doesnot have a right child create a right child and link it to the current node
					if(current.right == null)
					{
						TreeNode rightChild = new TreeNode(arr[i]);
						current.right = rightChild;
						break;
					}
					else
					{
						// make the right child the current node
						current = current.right;
					}
				}
			}
			current = root; // set the current node back to the root
		}
		
		return root;
	}
	
	// method to traverse the tree in pre order and print it
	public static void printTree(TreeNode root)
	{
		if(root == null)
		{
			return ;
		}
		System.out.print(root.value + "   ");
		printTree(root.left);
		
		printTree(root.right);
	}
	
	//method to print the tree level by level
	public static void printTreeLevel(TreeNode root)
	{
		// queue to store the nodes of the tree 
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root == null)
		{
			return ;
		}
		// add the root value
		queue.add(root);
		int counter = 0;// variable to count no. of nodes in each level
		
		while(!queue.isEmpty())
		{
			counter = queue.size();
			
			while(counter > 0)

			{
				// remove the node from the queue and make it the current node
				TreeNode Current = queue.poll();
				// print the current nodes value
				System.out.print(Current.value + "  ");
                // if the current node has left child add it to the queue
				if(Current.left != null)
				{
					queue.add(Current.left);
				}
				// if the current node has the right child add it to the queue
				if(Current.right != null)
				{
					queue.add(Current.right);
				}
				counter--;
			}
			System.out.println();	
		}
	}
	
	//Method to check if the given tree is balanced or not based on height
	public static boolean checkBalance(TreeNode root)
	{
		if(root == null)
		{
			return true;
		}
		// get the height of left subtree
		int left = getHeight(root.left);
		// get the height of right subtree
		int right = getHeight(root.right);
		
		// check if the difference in height is greater than 1, if yes, unbalanced
		if(Math.abs(left - right) > 1)
		{
			return false;
		}
		
		return checkBalance(root.left) && checkBalance(root.right);
	}
	
	// Method to return the height of the tree
	public static int getHeight(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		
		return 1+Math.max(getHeight(root.left), getHeight(root.right));
	}

}
