package DCT.DP;
// https://leetcode.com/problems/house-robber/
import java.util.Arrays;
import java.util.Collections;

public class Robber {
	//[1,2,3,1]

	public static void main(String args[]) {
		//int houses[] = {2,3,2};
		int houses[] = {1,2,3,1};
		int arr[] = new int[houses.length];
		System.out.println("Robber I:"+maxAmount(houses, arr));
		//System.out.println("Robber II:"+maxAmountCircle(houses, arr));
	}
	public static int maxAmount(int houses[], int arr[]) {
		if (houses.length == 0) 
			return 0;
		arr[0] = houses[0];
		arr[1] = houses[1];
		int even=0;
		int odd=0;
		for (int i=0;i<houses.length;i++) {
			//arr[i] = houses[i] + arr[i-2];
			if (i%2==0)
				even+=houses[i];
			else
				odd+=houses[i];
		}
		//Arrays.sort(arr);
		
//		return arr[arr.length-1] ;
		return Math.max(even, odd);
	}
	//even -> already skip the last one
	//odd -> iterate till last -2
	public static int maxAmountCircle(int houses[], int arr[]) {
		if (houses.length == 0) 
			return 0;
		arr[0] = houses[0];
		arr[1] = houses[1];
		boolean even = houses.length%2 == 0;
		
		for (int i=2;i<houses.length;i++) {
			if (even || i!=houses.length-1) {
				arr[i] = houses[i] + arr[i-2];
			}
		}
		Arrays.sort(arr);
		
		return arr[arr.length-1] ;
	}
}
