/**********************************************************************************************************
 * @author Bhavya Deepthi Kothala
 * Description:
 *              This program finds the no. of unique paths a robot can take from (1,1) to (m,n) if it can 
 *              only go either right or down.
 *              
 *              Use of recursion solves this problem easily.
 *              For solving this problem we start from the end. 
 *              For the robot to go to (m,n) cell it either has to go there from (m-1,n) or from (m,n-1).
 *              so no. of ways to reach (m,n) is sum of no. of ways to reach (m-1,n) and no. of ways 
 *              to reach (m,n-1).  
 *              so when the recursive function reaches the cell (1,1) no. of ways will become 1 because thats 
 *              the first cell. 
 **************************************************************************************************************/

public class UniquePath 
{
	public static void main(String[] args)
	{
		// print no. of paths the robot can take to given cell
		System.out.println(getUnique(3,3));
	}
	
	// Function to find no. of paths the robot can take to reach the given cell from 1,1
	public static long getUnique(int m, int n)
	{
		// if the cell  is 1,1 then return 1
		if( m == 1 || n == 1 )
		{
			return 1;
		}
		
		// recursive function to find the no. of paths to (m-1,n) and (m,n-1)
		return getUnique(m - 1, n) + getUnique(m, n - 1);
	}

}
