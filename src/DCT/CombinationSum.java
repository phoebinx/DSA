package DCT;

import java.util.Arrays;

public class CombinationSum {
	
	public static void main(String args []) {
		int nums[] = {3, 2, 1};
		int target = 4;
		System.out.println(totalSeq(nums,target));
	}
	
	public static int totalSeq(int remCoins[], int remVal) {
		int count = 0;
		if (remVal == 0) {
			return count;
		} else if (remCoins.length == 0) {
			return count;
		} else if (remCoins.length==1) {
			if (remVal%remCoins[0] ==0)
				count = count+remVal/remCoins[0];
		} else {
			int[] newRemCoins = Arrays.copyOfRange(remCoins, 1, remCoins.length);
			int curMaxTimes = (int)Math.floor(remVal/remCoins[0]);
			for (int i =curMaxTimes; i>=0;i--) {
				count = count + totalSeq(newRemCoins, remVal-(i*remCoins[0]));
			}
		}
		
		return count;
	}

}
