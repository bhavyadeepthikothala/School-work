/***************************************************************************************************
 * @author Bhavya Deepthi Kothala
 * Description:
 *              This program reverses the given string and prints its in reverse order
 *              start from the end of the string and print each char at the last index and keep on
 *              decreasing the length of the string  and pass it to the recursive function again 
 *              and when the length of the string reaches to 1 print the last character. 
 **************************************************************************************************/
public class ReverseString 
{
	
	public static void main(String[] args)
	{
		// passing value to the function
		 System.out.println(reverseString("bhavya deepthi kothala")) ;
	}
	
	// Function to print the string in reverse order
	public static String reverseString(String str)
	{
		// if the length of the string passed is 1 return the only character of the string
		if(str.length() == 1 )
		{
			return str;
		}
		
		// print the last character of the string
		System.out.print(str.charAt(str.length() -  1));
		
		// pass the string by decreasing its length by 1 and call the function recursively
		return reverseString(str.substring(0, str.length() - 1));
	}

}
