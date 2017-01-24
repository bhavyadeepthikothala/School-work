/*********************************************************************************************************
 * @author Bhavya Deepthi Kothala
 * Description:
 *              This program finds the no. of ways one can climb n no.of stairs by taking 1, 2, 3,
 *              or 4 steps at a time.
 *              
 *              Use of recursion solves this problem easily 
 *              If there is only one step no. of ways one can climb the steps is one way
 *              If there are two steps no. of ways one can climb them is 2 ways 
 *              Take these as base cases and when n = 3 and n = 4 there will be one way to climb them
 *              so the recursive function will be sum of no.of ways if taking one step at a time, 
 *              no.of ways if taking two steps at a time =, no.of ways if taking three steps at a time
 *              and no. of ways if taking four steps at a time. 
 ********************************************************************************************************/
public class ClimbingStairs 
{
	public static void main(String[] args)
	{
		// print no. of ways climbing the given no. of steps
		System.out.println(getSteps(6));
	}
	
	//function to find no. of ways to climb given no. of ways
	public static long getSteps(int n)
	{
		// if no. of steps = 2 or 1 then the no. of ways to climb them is 2 or 1 respectively
		if(n == 2 || n == 1 )
		{
			return n;
		}
		/* if no. of steps = 3 or 4 then the recursive function passes zero and there is on eway to climb them 
		   one can 3 or 4 steps at a time */
		if( n == 0 )
		{
			return 1;
		}
		//if n is a negative number
		if(n < 0)
		{
			return 0;
		}
		
		// recursive Function to find no. of ways to climb n steps 1 or 2 or 3 or 4 at a time
		return getSteps(n - 1) + getSteps(n - 2) + getSteps(n - 3) + getSteps(n - 4);
	}
}
