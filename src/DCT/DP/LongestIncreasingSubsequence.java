package DCT.DP;
//https://leetcode.com/problems/longest-increasing-subsequence/
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		int arr[] = {10,22,9,33,21,50,41,60};
		System.out.println("Longest subsequence is: "+getLongestSeq(arr));
	}
	
	public static int getLongestSeq(int arr[]) {
		Integer[] lis = new Integer[arr.length];
		
		for (int i=0; i<lis.length;i++) {
			lis[i] = 1;
		}
		
		for (int i =1; i<arr.length; i++) {
			for (int j=0; j<i;j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
		}
		
		return Collections.max(Arrays.asList(lis));
	}

}
