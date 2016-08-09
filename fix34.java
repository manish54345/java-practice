
//Return an array that contains exactly the same numbers as the given array, 
//but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
//but every other number may move. The array contains the same number of 3's and 4's, 
//every 3 has a number after it that is not a 3 or 4, and a 3 appears in the array before any 4.

//fix34([1, 3, 1, 4]) => [1, 3, 4, 1]
//fix34([1, 3, 1, 4, 4, 3, 1]) => [1, 3, 4, 1, 1, 3, 4]
//fix34([3, 2, 2, 4]) => [3, 4, 2, 2]
                       
public class fix34 {


	public static void main(String[] args) {
		printArray( fix34(new int[]{1, 3, 1, 4}) ); // => [1, 3, 4, 1]
		printArray( fix34(new int[]{1, 3, 1, 4, 4, 3, 1}) ); // => [1, 3, 4, 1, 1, 3, 4]
		printArray( fix34(new int[]{3, 2, 2, 4}) ); // => [3, 4, 2, 2]
	}
	public static int[] fix34(int[] nums) {

		  if (nums.length<=2){
		    return nums;
		  }
		  
		  int arr[] = new int[nums.length];
		    
		  int[] t = new int[nums.length];
		  int j=-1;
		  int three=-1;

		  int[] f = new int[nums.length];
		  int k=-1;
		  int four =0;
		  
		  for (int i = 0; i<nums.length; i++) {
		    if (nums[i] == 3) {
		      t[++j] = i;
		    }
		    if (nums[i] == 4) {
		      f[++k] = i;
		    }
		    arr[i]=nums[i];
		  }
		  
		  j=0;
		  for(int i=0; i<t.length ; i++) {
		    if (i<nums.length-1 && j<nums.length-1 && t[i]+1<t.length) {
		        if (arr[t[i]+1] !=3 && arr[t[i]+1] != 4 ) {
		          int tmp = arr[t[i]+1];
		          arr[t[i]+1] = arr[f[j]]; 
		          arr[f[j++]] = tmp;
		        }
		    }
		  }
		  return arr;
		}
	
	
	    public static void printArray(int[] a) {
	    	System.out.print("[");
	    	for(int i=0; i<a.length; i++) {
	    		System.out.print(a[i]);
	    		if (i < a.length-1)
	    			System.out.print(",");
	    		else 
	    			System.out.println("]");
	    	}
	    }
}
