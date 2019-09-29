package DCT;

import java.util.Arrays;
import java.util.Collections;

public class MaxSubArraySum {
	public static void main(String args[]) {
		int arr[] = {-1, 2,4,-3,5,2,-5,2};
		System.out.println("Max subarray sum is "+maxSum(arr));
	}
	
	static int maxSum(int arr[]) {
		int best =0, sum = 0;
		for (int k = 0; k <arr.length;k ++) {
			sum =  Collections.max(Arrays.asList(arr[k], sum+arr[k]));
			best= Collections.max(Arrays.asList(best, sum));
		}
		return best;
	}

}

//The idea is to calculate, for each array position, the
//maximum sum of a subarray that ends at that position. After this, the answer
//for the problem is the maximum of those sums.
//Consider the subproblem of finding the maximum-sum subarray that ends at
//position k. There are two possibilities:
//1. The subarray only contains the element at position k.
//2. The subarray consists of a subarray that ends at position k −1, followed by
//the element at position k.
//In the latter case, since we want to find a subarray with maximum sum, the
//subarray that ends at position k −1 should also have the maximum sum. Thus,
//we can solve the problem efficiently by calculating the maximum subarray sum
//for each ending position from left to right.