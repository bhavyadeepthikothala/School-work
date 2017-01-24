/*
 * @author:   EMMANUEL IKONNE
 * 
 * java implementation to determine the best way to cut a stick to maximize profit
 */
public class BestCut {
	static long max = 0; 
	static int sub = 0; 
	static long maximum; 
	
	/*
	 * I tried to solve it without a for loop but doesn't work for all cases. It works for the test cases though.
	 */
	
	/*public static long bestCut( int length, int stick, int[] prices)
	{
		 if the left side becomes 1, return price at the first index 
		 
		if(length == 1)
			return prices[0];
		
		 if you sell the stick as a whole, 
		 * price should be the price at the highest index	 
		 
		if(length == stick )
			maximum = prices[stick-1]; 
		
		keep decreasing the left	 
		int left = length-1; 
		
		keep increasing the right
		int right = stick-left; 
		
		get the price of both left + price of right,
		 * left-1 and right-1 helps to get the index of the array because it starts at 0
		 
		max = prices[left-1] + prices[right-1]; 
		
		 divide stick into 8 		
		if(left == 1 )
		max = prices[left-1] * stick; 
		
		
		
		 * recurse through the function again with the new left side of the stick, the original side of the stick
		 * and the price list. Also, compare maximum prices of instance where you don't cut the stick at all 
		 
		return Math.max(maximum, Math.max(max, bestCut(left, stick, prices))); 
			
	}
*/	
	/* function to test the function above 
	 * 
	 */
	
	
	
	
	public static void main(String args[])
	{
		int stick = 8;     
		int[] prices = {3, 5, 8, 9, 10, 17, 17, 20}; 
		
		//System.out.print(bestCut(stick, stick, prices)); 

		System.out.print(cutRod(prices, stick)); 
	}
	
	
	 public static int cutRod(int[] price, int n) {
	        /* if there is no rod, then there is no price 
	         * 
	         */
		 	if (n == 0) {
	            return 0;
	        }
		 	/* assume max to be the minimum value possible an integer can  have
		 	 * 
		 	 */
	        int max = Integer.MIN_VALUE;
	        
	        /* loop through the stick 
	         * 
	         */
	        for (int i = 0; i < n; i++) {
	              
	        	/*take the price of the current, length to be the optimal solution
	        	 * keep adding the price of the current position to  itself with subsequent cuts
	        	 */
	            max = Math.max(max, price[i] + cutRod(price, n - i - 1));
	        }
	        return max;
	    }
	
	
	public static int withLoop(int length, int stick, int[] prices)
	{
		
		return 0; 
	}
}
