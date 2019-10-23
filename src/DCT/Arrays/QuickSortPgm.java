package DCT.Arrays;

public class QuickSortPgm {
	public static void main(String args[]) {
		int arr[] = {7,2,1,4,8,5,3,4};
		QuickSort(arr,0,arr.length-1);
		for (int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void QuickSort(int arr[], int start, int end) {
		if (start<end) {
			int pIndex = partition(arr,start, end);
			QuickSort(arr,0, pIndex-1);
			QuickSort(arr,pIndex+1,end);
		}
	}
	
	public static int partition(int arr[], int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		int temp;
		for (int i=start; i<end; i++) {
			if (arr[i]<=pivot) {
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		temp = arr[pIndex];
		arr[pIndex] = arr[end];
		arr[end] = temp;
		return pIndex;
	}
}
