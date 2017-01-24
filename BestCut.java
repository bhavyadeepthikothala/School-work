
public class BestCut {
	static long max = 0; 

	public static long bestCut( int length, int stick, int[] prices)
	{
		if(length == 1)
			return prices[0];
		
		int left = length-1; 
		int right = stick-left; 
	
		long max = prices[left - 1] + prices[right-1]; 
		
		return Math.max(max, bestCut(left, stick, prices)); 
		
	}
	
	public static void main(String args[])
	{
		int stick = 8; 
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20}; 
		
		System.out.print(bestCut(stick, stick, prices)); 
		
	}

}
