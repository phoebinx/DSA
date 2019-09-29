package DCT;

import java.util.Hashtable;
import java.util.Scanner;

public class ApurvaMaxProfitDP {

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("enter total amount");
		long n = s.nextInt();
		long amt = Math.max(n, maxProfit(n));
		System.out.println("Max profit is "+ amt);
	}
	static Hashtable<Long, Long> ht = new Hashtable<>();
	
	public static long maxProfit(long n) {
		if (n<4) return n;
		else if (ht.containsKey(n)) return ht.get(n);
		
		long total = maxProfit((long)Math.floor(n/2))+maxProfit((long)Math.floor(n/3))+maxProfit((long)Math.floor(n/4));
		
		if (total>n) {
			ht.put(n,total);
			return total;
		} else {
			ht.put(n,n);
			return n;
		}
	}
}

//long profit = 0;
//long arr[] = {2,3,4};
//if(ht.containsKey(n)) {
//	return ht.get(n);
//} else {
//	for (long i = 0; i<arr.length; i++) {
//		if (Math.floor(n/arr[i])>=1) {
//			long m=(long)Math.floor(n/arr[i]);
//			if(ht.containsKey(m)) {
//				profit = profit+ ht.get(m);
//				System.out.println(profit);
//			} else {
//			profit = profit+(long)Math.floor(n/arr[i]);
//			}
//		}
//	}
//	ht.put(n, profit);
//}
//return profit;
