/*******************************************************************************************************************
 * 
 * @author bhavya
 *  Description: Finding the no. of ways to climb n stairs when one can climb 1 or 2 or 3 or 4 steps at a time 
 *               using Dynamic Programming where we store the no. of ways to climb the steps n - 1 in an array and 
 *               then add the previous values to find the value in ith position 
 *******************************************************************************************************************/
public class climbingStairs 
{
	public static void main(String[] args)
	{
		System.out.println(getSteps(6));
	}
	// method to get the no. of ways to climb n steps
	public static long getSteps(int n)
	{
		if (n == 1 || n == 2 )
		{
			return n;
		}
		if ( n == 3) 
		{
			return 4;
		}
		// array to store the previous values
		long[] ways = new long[n + 1];
		
		ways[0] = 0;
		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 4;
		
		for(int i = 4; i < ways.length; i++)
		{
			// no. of ways to reach ith step would be sum of no. ways to i-1, i-2, i-3, i-4
			ways[i] = ways[i - 1] + ways[i - 2]+ways[i - 3] + ways[i - 4];
		}
		
		return ways[n] + 1;
	}
}
