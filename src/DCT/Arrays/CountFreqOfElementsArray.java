package DCT.Arrays;

import java.util.Hashtable;
import java.util.Set;
import java.util.Stack;

public class CountFreqOfElementsArray {
	public static void main(String args[]) {
		int[] arr = new int[] {1, 2, 5, 2, 2};
		printFreq(arr, 7);
		Stack<Integer> s = new Stack<>();
		
	}
	
	private static void printFreq(int[] arr, int n) {
		Hashtable <Integer, Integer> ht = new Hashtable<>();
		int val = 0;
		for (int i = 0; i< arr.length; i++) {
			if (ht.containsKey(arr[i])) {
				val = (int)ht.get(arr[i]) + 1;
				ht.put(arr[i], val);
			} else {
				ht.put(arr[i], 1);
			}
		}
		
		Set<Integer> keys = ht.keySet();
		for (int k : keys) {
			System.out.println(String.valueOf(k)+"->"+String.valueOf(ht.get(k)));
		}
	}
}
