package DCT.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4};
		System.out.println(hasDuplicate(arr));
	}
	
	public static boolean hasDuplicate(int arr[]) {
		HashSet<Integer> h = new HashSet<>();
		if (arr.length == 0) {
			return false;
		}
		for (int i:arr) {
			if (h.contains(i)) {
				return true;
			} else {
				h.add(i);
			}
		}
		
		return false;
	}
}
