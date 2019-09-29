package DCT.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayIntersection {
	public static void main(String args[]) {
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {2,6,3,0,4,7,11};
		ArrayList<Integer> arr3 = getIntersection(arr1,arr2);
		for (Integer i:arr3) 
			System.out.print(i+" ");
 	}
	
	public static ArrayList<Integer> getIntersection(int arr1[], int arr2[]) {
		HashSet<Integer> hs = new HashSet<>();
		ArrayList<Integer> arr3 = new ArrayList<>();
		for (int i:arr1) {
			hs.add(i);
		}
		for(int i:arr2) {
			if (hs.contains(i)) 
				arr3.add(i);
		}
		return arr3;
	}
}
