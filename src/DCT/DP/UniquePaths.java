package DCT.DP;
// https://leetcode.com/problems/unique-paths/
import java.util.Hashtable;

public class UniquePaths {
	
	public static void main(String args[]) {
		int arr3 [][] = {{1,1,1},{1,1,1}, {1,1,1}};
		int arr[][] = new int[100][100];
		for (int i = 0; i<3;i++) {
			for(int j =0;j<7;j++) {
				arr[i][j] = 1;
			}
		}
		System.out.println(count(arr,0,0));
	}
	
	static Hashtable<String,Integer> ht =  new Hashtable<>();
	

	public static int count(int [][] arr, int row, int col) {
		String str = String.valueOf(row)+String.valueOf(col);
		if (row == arr.length-1 || col == arr[0].length-1) {
			return 1;
		} else if (ht.containsKey(str)) {
			return ht.get(str);
		}
		int count =  count(arr,row+1, col)+count(arr, row, col+1);
		ht.put(str,count);
		return count;
	}

}
