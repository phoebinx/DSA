package DCT;
//n is position of element

public class Knapsack {
	static int w[] = {};
	static int v[] = {};
	static int tot_wt = 50;
	static int [][] arr=new int[w.length][tot_wt];
	
	public static int kS(int n, int rem_wt) {
	if (arr[n][rem_wt] != 0 ) {
		return arr[n][rem_wt];
	} else if (rem_wt == 0 || n==-1) {
		return 0;
	} else if (rem_wt < w[n]) {
		kS(n-1, rem_wt);
	} else {
		int temp_val_1 = v[n]+kS(n-1, rem_wt-w[n]);
		int temp_val_2 = kS(n-1, rem_wt);
		arr[n][rem_wt] = Math.max(temp_val_1, temp_val_2);
		return arr[n][rem_wt];
	}
	return 0;
	
}
}
