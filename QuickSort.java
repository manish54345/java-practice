
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{17,41,5,22,54,6,29,3,13};
		quickSort(arr);
	}
	
	public static int[] quickSort(int[] a) {
		if (a.length == 1) {
			return a;
		}
		int tmp=0;
		int[] sorted = new int[a.length];
		int pivot = a.length-1;
		int i=0;
		int j=pivot-1;
		System.out.println("*** Iteration ****");
		for (;;){
			printArray(a);
			System.out.println(" ---> " + a[i] + " " + a[j] + " " + a[pivot]);
			
			if (a[i] > a[pivot] && a[j] < a[pivot]) {
					tmp=a[i];
					a[i]=a[j];
					a[j]=tmp;
					i++;
					j--;
			} else if (a[i] < a[pivot]) {
					i++;
			} else if (a[j] > a[pivot]) {
					j--;
			}
			if (i==j && a[i] > a[pivot]) {
					tmp = a[pivot];
					a[pivot]=a[i];
					a[i]=tmp;
					break;
			}
			if (i==j) break;

			try {Thread.sleep(1000);  } catch (Exception e) {}
		}
		
		printArray(a);
		if (a.length <= 3) {
			return a;
		}
		
		
		
		pivot=i;
		System.out.println("=================================== pivot:" + pivot);
					int[] sorted1 = new int[pivot];
			int[] sorted2 = new int[a.length-pivot];
			System.out.println("*** Split & Sort 1 ****");
			sorted1 = quickSort(giveArraySlice(a, 0, pivot-1));
			printArray(sorted1);
			System.out.println("*** Split & Sort 2 **** Pivot:" + pivot + " Length:" + a.length );
			sorted2 = quickSort(giveArraySlice(a, pivot+1, a.length-1));
			printArray(sorted2);
			System.out.println("*** Join Arrays **** - pivot element " + a[pivot] );
			sorted=joinArrays(sorted1,a[pivot],sorted2);
			System.out.println("=============SORTED====================== ");
			printArray(sorted);
			return sorted;
		 
	}
	public static void printArray(int[] a) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static int[] giveArraySlice(int[] a, int begin, int end) {
		if (begin > end) {
			System.out.println("begin > end : " + begin + " > " + end);
			throw new RuntimeException();
		}
		
		int[] slice=new int[1+end-begin];
		int j=0;
		for (int i=begin; i<=end; i++,j++) {
			slice[j]=a[begin+j];
		}
		return slice;
	}
	public static int[] joinArrays(int[] a, int pElement, int[] b) {
		int[] c = new int[a.length+b.length+1];
		int i=0;
		for(;i<a.length ; i++) {
			c[i]=a[i];
		}
		c[i]=pElement; i++;
		for(int j=0;j<b.length ; i++,j++) {
			c[i]=b[j];
		}		
		return c;
	}
}
