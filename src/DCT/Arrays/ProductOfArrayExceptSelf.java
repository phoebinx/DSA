package DCT.Arrays;
//https://leetcode.com/problems/product-of-array-except-self/

public class ProductOfArrayExceptSelf {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4};
		int arr2[] = getProductArray(arr);
		for (int i:arr2) {
			System.out.print(i+" ");
		}
	}
	

	public static int[] getProductArray(int arr[]) {
		int arr2[] = new int[arr.length];
		arr2[arr2.length-1] = 1;
		for (int i = arr.length-2;i>0;i--) {
			arr2[i] = arr[i+1] * arr2[i+1];
		}
		int left =1;
		for (int j = 0; j<arr.length;j++) {
			arr2[j] = arr2[j]*left; 
			left = left*arr[j];
		}
		return arr2;
	}
}

//hint-> number 2 is product of all numbers before it and all numbers after it
//instead of a nested loop , we have two seperate loops, one to calculate after and other to calculate before
//


//https://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/

//public static int[] getProductArray2(int arr[]) {
//	int temp1[] = new int[arr.length];
//	int temp2[] = new int[arr.length];
//	temp1[0] = 1;
//	for (int i = 1; i<arr.length; i++) {
//		temp1[i] = temp1[i-1]*arr[i-1];
//	}
//	temp2[arr.length-1] = 1;
//	for (int i=arr.length-2;i>=0;i--) {
//		temp2[i] = temp2[i+1] * arr[i+1];
//	}
//	for (int i = 0;i<arr.length;i++) {
//		temp2[i] = temp1[i]*temp2[i];
//	}
//	return temp2;
//}
//