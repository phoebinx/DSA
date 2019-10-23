package DCT.DP;
//https://leetcode.com/problems/coin-change/
import java.util.Arrays;
import java.util.Hashtable;

public class MinCoin {
	
	static Hashtable<String,Integer> ht = new Hashtable<>();
	static int coins[] = {5,2,1};
	static int value = 11;

	public static void main(String[] args) {
		System.out.println(getMinCoin(coins, value));
	}
	
	
	public static int getMinCoin(int[] remCoins, int remVal) {
		
		//System.out.println("remCoins="+Arrays.toString(remCoins)+" remVal="+remVal+" currCount="+currCount);
		System.out.println(remCoins.length+" "+remVal);
		if (remVal == 0) { return 0; }
		
		if (remCoins.length == 0) { return 0; }
		
 		if (remCoins.length == 1 ) {
 			if (remVal % remCoins[0] == 0) {
 				return (remVal / remCoins[0]); 
 			}
 			else {
 				return -1;
 			}
 		} 
		
		int coin = remCoins[0];
		int currMaxCount = (int) Math.floor(remVal/coin);
		
		int[] newRemCoins = Arrays.copyOfRange(remCoins, 1, remCoins.length);
		
		int minVal = Integer.MAX_VALUE;
		//System.out.println(currMaxCount);
		for(int i = currMaxCount; i >= 0; i--) {
			//System.out.println("IN HERE 1");
			int result = getMinCoin(newRemCoins, remVal-(i*coin));
			if (result != -1) {
				minVal =  Math.min(minVal, i + result);
			}
		}
		
		if (minVal == Integer.MAX_VALUE) {
			return -1;
		}
		
		return minVal;
	}

}
