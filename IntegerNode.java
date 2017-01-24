public class IntegerNode
{
	protected int item;     
	protected IntegerNode next;
	IntegerNode(int itemArg ) {
		item = itemArg;  
		next = null;
		} 
	IntegerNode( int itemArg, IntegerNode nextArg )   // constructor
	{
		item = itemArg; 
		next = nextArg;
		} 
	public String toString()  // returns string representation
	{
		return item+"";
	}