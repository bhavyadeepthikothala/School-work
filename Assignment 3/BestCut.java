/*********************************************************************************************************
 * @author Bhavya Deepthi Kothala
 * Description:
 *               This program is used find the best possible cut to sell a rod and maximize the profit.              
 *********************************************************************************************************/


public class BestCut 
{
	 
    // test case to find the solution
	public static void main(String[] args)
	{
		
		int[] price = {3, 10, 8, 9, 10, 17, 17, 26}; 
		
		//System.out.println(bestCut(1,8,price)
		
		// print the max value you can obtain
		System.out.print(bestCut( price, 8)); 
		
	}
	
	// Tried implementing without using loop but could get past the test cases for the extreme values of price array
	
	/*public static long bestCut( int piece, int stick, int[] prices)
	{
		if(stick == 1)
		{
			return prices[0];
		}
		int start = piece - 1; 
		
		long max = prices[stick - 1]; 
		
		max = Math.max(max, (prices[start] + bestCut(start + 1, stick - piece, prices))); 
		
		return max;
	}*/
	
	// Function to find the maximum value by cutting the rod into different lengths or by selling whole
	public static long bestCut( int[] price, int ActualLength)
	{
		//if the length of the rod is 1, the minimum we can cut, return the price for that length 
		if(ActualLength == 1)
		{
			return price[0];
		}
		
		long max = 0;
		
		// loop through all the possible values we can cut the rod and make maximum profit out of it
		
		for( int piece = 1; piece < ActualLength; piece++ )
		{
			max = Math.max(max, (price[piece] + bestCut(price, ActualLength - piece - 1))); 
		}
		return max;
	}
	
}
