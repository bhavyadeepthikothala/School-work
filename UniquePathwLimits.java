import java.awt.Point;
import java.util.*;

public class UniquePathwLimits 
{
	static HashMap<Integer, String> path = new HashMap<Integer, String>();
	static HashMap<Point, Boolean> offlimits = new HashMap<Point, Boolean>();
	static int index = 0;
	public static void main(String[] args)
	{
		 int rows = 5;
		 int columns = 5;
		 createOffLimits(rows,columns);
		 UniquePath(rows, columns," ");
		 int pathCount = 1;
		 if(path.size() == 0)
		 {
			 System.out.println("there is no path to reach the last cell");
		 }
		 else
		 {
			 System.out.println("There are " + path.size() + " possible paths  and they are: ");
			 
			 for(int i = 0; i < path.size(); i++ )
			 {
				
			    System.out.println("PathNumber " + pathCount + ": " + path.get(i));
			    pathCount++;
			 }
			 
		 }
		
	}
	
	public static boolean UniquePath(int x, int y, String pathTaken)
	{
		Point p = new Point(x,y);
		if(x == 1 && y == 1 )
		{
			pathTaken = pathTaken + " ( " + (x) + " , " + (y) + " )";
			path.put(index,pathTaken);
	    	index ++;
	    	
		}
		
		else
		{
			pathTaken = pathTaken + " ( " + (x) + " , " + (y) + " )"  + " - > ";
		}
			    
	  
	    if(x < 1 || y < 1)
	    {
	    	return false;
	    	
	    }   
	    
	    boolean exists = false;
	  
	    if(x >= 1 && isFree(x - 1 , y))
	    {
	    	exists = UniquePath(x - 1, y, pathTaken);
	    }
	    
	    if(!exists && y >= 1 && isFree(x, y - 1))
	    {
	    	exists = UniquePath(x, y - 1, pathTaken);
	    }
	      
	    return exists; 
		
	}
	
	public static boolean isFree(int x, int y)
	{
		Point next = new Point(x,y);
		
		for(int j = 0 ; j < offlimits.size(); j++)
		{
			if(offlimits.containsKey(next))
			{
				return false;
			}
		}
		return true;
	}
	
	
	public static void createOffLimits(int x, int y)
	{
		boolean off = false;
		System.out.println("The offlimit cells are:");
		for(int i = 0 ; i < ((x + y)/2) ; i++)
		{
			int x1 = (int) (Math.random() * x + 1);
			int y1 = (int) (Math.random() * y + 1);
			
			Point offpoint = new Point(x1, y1); 
			if((x1 == 1 && y1 == 1) || (x1 == 3 && y1 == 3) )
			{
				i--;
				continue;
			}
			if(offlimits.containsKey(offpoint))
			{
				i--;
				continue;
			}
			offlimits.put(offpoint, off);
			System.out.println("( " + x1 +", " + y1 + " )");
		}
	}

}
