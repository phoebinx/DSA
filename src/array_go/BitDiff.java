//https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

package array_go;

public class BitDiff {
	public static void main(String args[]) {
		int [] arr = {1,3,5};
		//int sum = findSum(arr);		
		//System.out.println(sum);
		System.out.println(0 << 0);
		System.out.println(0 << 1);
		System.out.println(0 << 2);
		System.out.println(0 << 3);
		System.out.println(0 << 4);
		System.out.println();
		System.out.println(1 << 0);
		System.out.println(1 << 1);
		System.out.println(1 << 2);
		System.out.println(1 << 3);
		System.out.println(1 << 4);
		System.out.println();
		System.out.println(2 << 0);
		System.out.println(2 << 1);
		System.out.println(2 << 2);
		System.out.println(2 << 3);
		System.out.println(2 << 4);
		
	}
	
	public static int findSum(int [] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				sum = sum + getBitDiff(arr[i] ^ arr[j]);
			}
		}
		return sum*2;
		
	}
	
	public static int getBitDiff(int input) {
		String temp = Integer.toBinaryString(input);
		int sum = 0;
		//System.out.println("hi");
		for (int i = 0; i<temp.length(); i++) {
			sum = sum + (temp.charAt(i)=='1'? 1 : 0);
		}
		return sum;
	}

}



/*Given an integer array of n integers, find sum of bit differences in all
 *pairs that can be formed from array elements. Bit difference of a pair 
 *(x, y) is count of different bits at same positions in binary 
 *representations of x and y. 
 *For example, bit difference for 2 and 7 is 2. Binary representation of 2 
 *is 010 and 7 is 111 ( first and last bits differ in two numbers).*/