package DCT.Arrays;

public class ContainerWithMostWater {
	public static void main (String args[]) {
		int arr[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr, arr.length-1));
	}
	
	public static int maxArea(int arr[], int len) {
		int l = 0;
		int r= len;
		int area =0;
		while (l<r) {
			area = Math.max(area, (Math.min(arr[l], arr[r])*(r-l)));
			if (arr[l] < arr[r]) 
				l++;
			else
				r--;
		}
		
		return area;
		
	}
}
