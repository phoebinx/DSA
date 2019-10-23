package DCT.DP;
//https://leetcode.com/problems/decode-ways/

import java.util.Arrays;
import java.util.Hashtable;

public class DecodeWays {
	
	public static void main(String args[]) {
		char [] data = {'2','2','6'};
		System.out.println(totalWays(data,data.length)); 
	}
	static Hashtable<Integer, Integer> ht = new Hashtable<>();	
	public static int totalWays(char []data, int k) {
		int s= data.length-k;
		if (k == 0) {
			return 1;
		} else if (data[s] == '0') {
			return 0;
		} else if (ht.contains(k) ) {
			return ht.get(k);
		}
		int count = 0;
		count = count + totalWays(data, k-1);
		if (k>=2 && Integer.parseInt((""+data[s]+data[s+1])) < 27) {
			System.out.println(""+data[s]+data[s+1]);
			count = count + totalWays(data, k-2);
		}
		ht.put(k, count);
	return count;	
	}
}
//https://www.youtube.com/watch?v=qli-JCrSwuk

//	int count = 0;
//	System.out.println("ko"+num);
//	if (num == 0) {
//		return 0;
//	} else if (num <= 9) {
//		return 1;
//	}
//	count = count + totalWays((int)Math.floor(num/10));
//	System.out.println(num);
//	if ( num>9 && num%100<27 && num%100 > 9) {
//		System.out.println(":"+num);
//		count = count+totalWays((int)Math.floor(num/100));
//	}
//	return count;
//	
//}

//base cases
//k = arr.length
//if k = 0 -> return 0
//if arr[0] == 0->return 0
//


//int count = 0;
//String[] arr = Integer.toString(num).split("");
//
//if (arr.length==0) {
//	return 0;
//}
//count = count+1;
//
//int array [] = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
//for (int i=0;i<array.length-1;i++) {
//	String j = (Integer.toString(array[i])+Integer.toString(array[i+1]));
//	if (Integer.parseInt(j) <= 26) {
//		count = count+1;
//	}
//}
//return count;