package DCT.Arrays;

public class BestTimeBuySellStock {
	public static void main (String args[]) {
		//int arr [] = {7,6,4,3,1};
		int arr[] = {7,1,5,3,6,4};
		System.out.println(stockProfit(arr));
	}
	
	public static int stockProfit(int arr[]) {
		if (arr.length==0) {
			return 0;
		}
		int i = 0; int j = arr.length-1;
		int min=Integer.MAX_VALUE,max=0;
		while(i<=j) {
			if(arr[i] <min) {
				min = arr[i];
			}
			if (arr[j] > max) {
				max = arr[j];
			}
			i++;
			j--;
		}
		System.out.println(max+":max, min:"+min);
		return max-min>0? max-min:0;
	}

}
