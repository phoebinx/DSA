//https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/

package DCT.Arrays;

public class BitDiff {
	public static void main(String args[]) {
		int[] arr = { 1, 3, 5 };
		System.out.println(findSum(arr));

	}

	public static int findSum(int[] arr) {
		int sum = 0;
		int count;
		for (int i = 0; i < 32; i++) {
			count = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) == 0) {
					count = count + 1;
				}
			}
			sum = sum + (count * (arr.length - count) * 2);
		}
		return sum;

	}

}

/*
 * Given an integer array of n integers, find sum of bit differences in all
 * pairs that can be formed from array elements. Bit difference of a pair (x, y)
 * is count of different bits at same positions in binary representations of x
 * and y. For example, bit difference for 2 and 7 is 2. Binary representation of
 * 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).
 */



//To calculate the sum of bit difference among pairs in the array we use the formula:
//	count*(arr.length-count) * 2
//	where count is no of elements in an array where ith bit is set and
//	arr.length-count is rest of the elements where ith bit is not set; 
//	i goes from 0 to 31 (32 bit representation of integer)
//	
//this is because as per Combination formula countC1 = count and n-countC1 = n-count, combination is
//count*(n-count) and since (1,3) and (3,1 ) are considerd seperate for sum, we multiply by 2


//In order to find if a particular bit is 1 or 0 we bitwise or it with 1 but 1 leftshifted to that bit 
//so if the bit is 1, 1&1 = 1 else 0, left shift if move to left and add 0 on right.

//* Int is 4byte which is 32 bit
//* Long is 8byte which 64 bit so if you want to do the bit diff question for long, run loop for 64.
//* Float is 4byte like it but double is 8byte like long
