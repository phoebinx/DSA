package DCT.Arrays;

public class SearchInRotatedSortedArray {
	public static void main(String args[]) {
		int arr[] = {4,5,6,7,0,1,2};
		int low = 0;
		int high = arr.length-1;
		int num = 0;
		System.out.println(pivotedBinarySearch(arr,arr.length, num));
	}
	
	public static int pivotedBinarySearch(int arr[],int length, int num) {
		int pivot = findPivot(arr,0,length-1);
		if (pivot == -1) {
			return binarySearch(0,length-1,arr, num);
		} else if (arr[pivot] == num) {
			return pivot;
		}
		// If we found a pivot, then first compare with pivot 
		// and then search in two subarrays around pivot
		//if num is > first element then element must be left of pivot.
		if (arr[0] <= num) {
			//return binarySearch(0, pivot-1,arr, num);
			return search(0, pivot-1,arr, num);
		} else {
			//return binarySearch(pivot+1,length-1,arr, num);
			return search(pivot+1,length-1,arr, num);
		}
	}
	
	
	public static int findPivot(int arr[], int low, int high) {
		//index of element after which element is less that it, a[i]>a[i+1] so i
		if (low>high) {
			return -1;
		}
		if (low == high) {
			return low;
		}
		int mid = (low+high)/2;
		if (arr[mid]>arr[mid+1]) {
			return mid;
		} else if (arr[mid-1]> arr[mid]) {
			return mid-1;
		}
		if (arr[low]<arr[mid]) {
			return findPivot(arr,low,mid-1);
		}
		else {
			return findPivot(arr,mid+1,high);
		}
	}
	
	
	public static int binarySearch(int low, int high, int arr[],int num) {
		if (high<low) {
			return -1;
		}
		int mid = (low+high)/2;
		if (arr[mid] == num) {
			return mid;
		}
		
		if (num > arr[mid])
			return binarySearch(mid+1, high, arr,num);
		return binarySearch(low, mid-1, arr,num);
	}
	
	public static int search(int low, int high,int arr[],int num) {
		if (low > high) {
			return -1;
		}
		
		
		int mid = (low+high)/2;
		
		if (arr[mid] == num) {
			return mid;
		}
		if (arr[low] < arr[mid]) {
			if (num>= arr[low] && num < arr[mid]) {
				return search(low, mid-1,arr, num);
			}
			return search(mid+1, high,arr, num);
		} else {
			if (num>=arr[mid] && num < arr[high]) {
				return search( mid+1, high, arr, num);
			}
			return search(low, mid-1,arr, num);
		}
	}
}
