
public class Linklist {

	IntegerNode head;         		 
	public void insert(int pos, IntegerNode item)   
	{
		IntegerNode dummy = new IntegerNode(-1, null);  
		dummy.next = head;	 
		IntegerNode curr = dummy;	 
		while(--pos >= 0)                            
		{
			curr = curr.next;				 
		}	 
		item.next = curr.next;                    
		curr.next = item;	 
		head = dummy.next;                          
	} 


	public IntegerNode get(int index)			
	{
		IntegerNode gets = head;

		if(index+1 == 0)							
		{
			return gets;   
		}
		for(int i =0;i<index+1;i++)
		{
			gets = gets.next;
		}

		return gets;
	}

	

	public void remove(int value)
	{
		IntegerNode ref1 = head;					
		IntegerNode ref2 = head.next;	
		while(ref2!=null)		
		{
			if(ref2.item==value)   
			{
				ref1.next = ref2.next;
				ref2.next = null;
			}
			ref2 = ref2.next;						
			ref1 = ref1.next;
		}
	} 
	public String toString()   
	{
		StringBuilder ret = new StringBuilder();
		IntegerNode curr = head;	
		while (curr != null)
		{
			if(curr != head)
			{
				ret.append("->"); 
			}
			ret.append(curr.item);
			curr = curr.next;
		}			
		return ret.toString();			
	}		


	public boolean checkPalindrome() {
		String elements = toString();
		String[] elementsArray = elements.split("->");
		String result = "";
		for (int i=elementsArray.length - 1; i>=0; i--) {
			if (i == 0) {
				result += elementsArray[i];
			} else {
				result += elementsArray[i];
				result += "->";
			}
		}
		return elements.equalsIgnoreCase(result);
	}

	public static void main( String [] args) {
		Linklist list = new Linklist();
		list.insert(0,new IntegerNode(10));
		list.insert(0,new IntegerNode(20));
		list.insert(0,new IntegerNode(10));
		System.out.println(list);
		System.out.println(list. checkPalindrome());
		list.insert(1,new IntegerNode(30));
		System.out.println(list);
		System.out.println(list. checkPalindrome());
	}


}
