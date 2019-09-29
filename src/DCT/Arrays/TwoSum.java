package DCT.Arrays;

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {
	public static void main(String args[]) {
		int arr [] = {13, 44, 1, 56, 2, 7, 11, 15};
		int arr2[] = TwoInt(arr,9);
		if (arr2!=null) {
			for  (int i: arr2) {
				System.out.print(i+" ");
			}
		}
	}
	
	
	public static int[] TwoInt(int [] arr, int num) {
		int arr2 [] = new int[2];
		if (arr.length==0) {
			return null;
		}
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		for (int i = 0; i<arr.length;i++) {
			if(arr[i]<=num) {
				if (ht.get(arr[i]) == null ) {
					ht.put(num-arr[i], i);
				} else {
					arr2[0] = ht.get(arr[i]);
					arr2[1] = i;
					return arr2;
				}
			}
		}
		return null;
	}
}

//wrong coz you are sorting so original indixes dont remain same

//public static int[] TwoInt(int [] arr, int num) {
//	int arr2 [] = new int[2];
//	if (arr.length==0) {
//		return null;
//	}
//	Arrays.sort(arr);
//	int j = arr.length-1;
//	while(arr[j]>num) {
//		j--;
//	}
//	int i=0;
//	if (arr[i] + arr[j] < num) {
//		i++;
//	} else if (arr[i]+arr[j] > num) {
//		j--;
//	} else {
//		arr2[0] = i;
//		arr2[1] = j;
//		return arr2;
//	}
//	return null;
//}
