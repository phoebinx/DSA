package DCT;

public class DMRecursiveStaircase {
	
	public static void main(String args[]) {
		int arr[] = {1,3,5};
		System.out.println(Integer.toString(getTotalWays1And2(3)));
		System.out.println(Integer.toString(getTotalWaysX(4,arr)));
	}
 

	public static int getTotalWays1And2(int num) {
		//an array with total outcomes for ith positions
		int num_arr[] = new int [num+1];
		num_arr[0] = 1;
		num_arr[1] = 1;
		for (int i = 2; i<=num; i++) {
			num_arr[i] = num_arr[i-1] + num_arr[i-2];
		}
		return num_arr[num];
	}
	
	public static int getTotalWaysX(int num, int x[]) {
		int num_arr[] = new int[num+1];
		num_arr[0] = 1;
		for(int i = 1; i<=num;i++) {
			for (int j :x) {
				if (i-j >= 0) {
					num_arr[i] = num_arr[i] + num_arr[i-j];
				}
			}
		}
		return num_arr[num];
	}
}


//input is X (no of steps possible to be taken at a time) and total number of steps
//print total number of ways you can reach the top
//its a dynamic prog prob where sum of answer of prevous X items is the ans for current item.
//https://www.youtube.com/watch?v=5o-kdjv7FD0

//when x has 1 and 2, nosteps[i] = nosteps[i-1]+nosteps[i-2 which is fibonacci ]