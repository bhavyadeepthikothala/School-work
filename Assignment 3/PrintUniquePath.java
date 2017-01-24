/**********************************************************************************************************
 * @author Bhavya Deepthi Kothala 
 * Description:
 *              This program prints the different paths robot can take to go from cell (1,1) to cell (m,n).
 *      		store every cell the robot enters into in the form of a string and store that string in a 
 *              HashMap.
 *              For printing from (1,1) to (m,n) consider two other variables that does the traversing 
 *              starting from (1,1) while the actual (m,n) stays as reference variables.
 *              once we reach then (m,n) i.e both the i = m and j = n then add the path that is being 
 *              created at every step in to a hash map.
 *              
 *              The index/ key of HashMap is the count of paths i.e no. of ways a robot can take.
 *              Finally print those paths in the main function using the HashMap get method 
 **********************************************************************************************************/

import java.util.*;

public class PrintUniquePath 
{	
	// HashMap to store all the paths 
    static HashMap<Integer,String> map = new HashMap<Integer,String>();
    
    // key for the HashMap
    static int index = 0;
    
    public static void main(String args[])
    {
    	// call the function to print the paths with size of the grid and the starting point
        getUnique(3, 3, 1, 1, " ");
        
        // print all the paths
        for (int i = 0; i < map.size(); i++)
        {
        	System.out.println( "path " + (i + 1) + ": " + map.get(i));
        } 

    }

    // function to find all the paths and store them in a string variable path and finally add it to the HashMap
    public static int getUnique(int m, int n, int i, int j, String path)
    {
    	// if it is the last cell create a path without an arrow after the cell
        if(i == m && j == n)
        {
        	path += ("(" + i + ", " + j + ") ");
        }
        // if not the last cell then create a path with an arrow in the end that shows the flow
        else
        {
        	path += ("(" + i + ", " + j + ") - > ");
        }

        //if last cell add the path to the HashMap and increment the key for HashMap 
        if(i == m && j == m)
        {       
            map.put(index,path); 
            index++;
        }
        //if exceeding the limit of the grid return 0 
        if( i > m || j > m)
        {
            return 0;               
        }
        
        /* recursive function to update the path followed by the robot to reach (m,n) from (1,1) taking one step at 
           a time either to right or to down */ 
       return getUnique(m, n, i, j + 1 , path) + getUnique(m, n, i + 1, j, path); 

    }
}
