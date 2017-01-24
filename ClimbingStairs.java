
public class ClimbingStairs {
	
	public static long getSteps(int steps)
	{
		if(steps <= 2)
			return steps;
		if(steps == 3)
			return getSteps(steps-1)+getSteps(steps-2)+1; 
		
		return getSteps(steps-1)+getSteps(steps-2)+getSteps(steps-3)+getSteps(steps-4); 
		
	}
	
	
	public static void main(String args[])
	{
		System.out.print(getSteps(5)); 
		
	}

}
