package DCT.Arrays;

public class RotatedArrayMin {
	public static void main(String args[]) {
		int arr [] = {2, 3, 4, 5, 6, 7, 8, 1};
		System.out.println(minElement(arr, 0, arr.length-1));
	}
	
	public static int minElement(int [] arr, int low, int high) {
		if (low>high) {
			return arr[0];
		} if (low == high) {
			return arr[low];
		}
		int mid =(low+high)/2;
		if (mid<high && arr[mid] > arr[mid+1]) {
			return arr[mid+1];
		} 
		if (mid>low && arr[mid-1]>arr[mid]) {
			return arr[mid];
		}
		if (arr[mid] < arr[high]) {
			minElement(arr,0,mid-1);
		}
		return minElement(arr, mid+1, high);
	}
}

//The minimum element is the only element whose previous is greater than it. If there is no previous element element, then there is no rotation (first element is minimum). We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
//If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
//If middle element is smaller than last element, then the minimum element lies in left half
//Else minimum element lies in right half.
