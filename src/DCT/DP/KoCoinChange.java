package DCT.DP;
//https://leetcode.com/problems/coin-change/
import java.util.Arrays;

public class KoCoinChange {
	
	public static int minCombo(int remCoins[], int remVal) {
		if (remCoins.length == 0 ) {
			return 0;
		} else if (remVal == 0) {
			return 0;
		} else if (remCoins.length==1) {
			if (remVal%remCoins[0] == 0) {
				return remVal/remCoins[0];
			} else {
				return -1;
			}
		} else {
			int min_val = Integer.MAX_VALUE;
			int new_arr[] = Arrays.copyOfRange(remCoins,  1, remCoins.length);
			int result;
			int max_times = remVal/remCoins[0];
			for (int i = max_times; i>=0; i-- ) {
				result = minCombo(new_arr, remVal-(i*remCoins[0]));
				if (result != -1)
					min_val = Math.min(min_val, result+i);
			}
			if (min_val == Integer.MAX_VALUE) {
				return -1;
			}
			
			return min_val;
			
		}
		
		
	}

}
