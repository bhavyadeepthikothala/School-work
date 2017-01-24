/************************************************************************************************************************
 * 
 * @author bhavya
 * 
 * Description: no. of unique ways a robot can reach cell (m,n) from cell (1,1) using dynamic Programming
 *             1. consider a two dimensional array 
 *             2. if there are m rows but only 1 column then the robot can each end in only one way 
 *             3. If there are n columns but only one row then the robot can reach the end in only one way
 *             4. If not, the robot can reach there in no. of ways to m-1,n + m,n-1   
 *
 ************************************************************************************************************************/
public class uniquePaths 
{
	public static void main(String[] args)
	{
		System.out.println("the no. of unique paths are: " + getUnique(3,3) );
	}
	
	//Method to find the no.of unique paths
	public static long getUnique(int m, int n)
	{
		long[][] up = new long[m][n];
		// if there are no cells at all 
		if(m == 0 && n == 0)
		{
			return 0;
		}
		// if there is only one cell
		if(m == 1 && n == 1)
		{
			return 1;
		}
		//if there are M rows but only one column
		for(int rowCount = 0; rowCount < m; rowCount++)
		{
			up[rowCount][0] = 1;
		}
		// if there are N columns but only one row
		for(int colCount = 0; colCount < n; colCount++)
		{
			up[0][colCount] = 1;
		}
		
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j < n; j++)
			{
				up[i][j] = up[i][j-1] + up[i-1][j];
			}
		}
		return up[m-1][n-1];
	}
	
}
