package DCT;

import java.util.Hashtable;

public class JumpGame {
	
	public static void main(String args[]) {
		int arr [] = {3,2,1,0,4};
		System.out.println(jump(arr, 0));
	}
	
	static Hashtable<Integer,Boolean> ht = new Hashtable<>();
	
	public static boolean jump(int arr[], int index) {
		if (index == arr.length-1) {
			return true;
		} else if (index > arr.length-1) {
			System.out.println("bye");
			return false;
		} else if (ht.containsKey(index)) {
			return ht.get(index);
		}
		boolean possibility=false;
		for (int i = arr[index];i>0;i--) {
			if (possibility == true) {
				break;
			}
			possibility = possibility || jump(arr,index+1);
		}
		ht.put(index, possibility);
		return possibility;
	}

}
