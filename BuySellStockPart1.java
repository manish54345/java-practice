
import java.util.*;
public class BuySellStockPart1 {

	public static void main(String[] args) {
		String str = "6 1 3 2 4 7";
		StringTokenizer st = new StringTokenizer(str, " ");
		
		int[] price = new int[st.countTokens()];
		int i=0;
		while (st.hasMoreElements()) {
			price[i++] = BuySellStockPart1.parse((String)st.nextElement());
		}
		
		getMaxProfit(price);
	}
	
	public static int getMaxProfit(int[] arr) {
		int p = 0;
		int b=0;
		int s=0;
		int k=0;
		int profit = 0;
		int maxprofit = 0;
		for(k=0; k<arr.length-1; k++){
			profit = 0;
			b=k; s=k+1;
			for(; b<arr.length || s<arr.length;) {
				for(; s<arr.length;s++) {
					if (arr[b]<arr[s] && b<s) {
						profit += (arr[s] - arr[b]);
						System.out.println("k="+k+",b,s="+ b+","+s+","+"profit="+profit);
						b=s; 
					}
					if (s>=arr.length-1) {
						b=arr.length;
					}
				}
			}
			if (profit > maxprofit) {
				maxprofit = profit;
			}
		}
		System.out.println("maxprofit="+maxprofit);
		return maxprofit;
	}
	
	public static int parse(String s) {
		int i=0;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			System.out.println("Failed to parse string " + s );
		} 
		return i;	
	}

}
