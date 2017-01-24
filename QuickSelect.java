

public class QuickSelect 
{
	public static int findkthLargest(int[] arr, int k)
	{
		int value = 0;
		int left = 0;
		int right = arr.length - 1;
		
		
		while (left <= right)
		{
			int pivot = partition(arr, left, right);
			
			if(pivot == k - 1)
			{
				return arr[pivot];
			}
			else if(pivot <  k)
			{
				left =  pivot + 1;
			
			}
			else
			{
				right = pivot - 1;
				
			}
		}
		return value;
	}
	
	public static int partition(int[] arr, int left, int right)
	{		
		int random = (left + right) / 2;
		
		int pivotValue = arr[random];
		
		int end = right;
		
		swap(arr,random,right);
		
		
		while(true)
		{
			while(arr[left] > pivotValue && left < end)
			{
				left++;
			}
		
			while(arr[end] <= pivotValue && left < end)
			{
				end--;
			}
		
			swap(arr,left,end);
			
			
			if(left > end || left == end )
			{
				break;
			}
		}
		
		swap(arr,left,right);
		
		
		return left;
	}

	public static void swap(int[] arr, int first, int next)
	{
		int temp = arr[first];
		arr[first] = arr[next];
		arr[next] = temp;
	}

	
	public static void main(String[] args)
	{
		int[] arr = {100,-1,0,6,25,78,91,5,3,2,11,12,67,69};
		int k = 10;
		System.out.println( findkthLargest(arr,k));
	}
	
}
