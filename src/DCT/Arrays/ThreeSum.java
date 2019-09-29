package DCT.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	public static void main(String args[]) {
		int arr[] = {-1, 0, 1, 2, -1, -4};
		int target = 0;
		printSets(arr,target);
	}
	

	public static void printSets(int arr[], int target) {
		HashSet<ArrayList<Integer>> targetSet = new HashSet<ArrayList<Integer>>();
		for (int i = 0; i< arr.length-2;i ++) {
			int num = target-arr[i];
			HashSet<Integer> h = new HashSet<>();
			for (int j= i+1; j<arr.length;j++) {
				if (h.contains(arr[j])) {
					ArrayList<Integer> arr2 = new ArrayList<Integer>();
					arr2.add(arr[i]);
					arr2.add(arr[j]);
					arr2.add(num-arr[j]);
					Collections.sort(arr2);
					targetSet.add(arr2);
				} else {
					h.add(num-arr[j]);
				}
				
			}
		}
		for (ArrayList arrList : targetSet) {
			int count = 0;
			while (arrList.size() > count) {
				 System.out.print(arrList.get(count));
			     count++;
			}
			System.out.println();
		}
	}
}