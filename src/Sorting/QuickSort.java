package Sorting;

public class QuickSort {
	public static void main(String args[]) {
		int arr [] = {6,2,3,9,1,8};
		sort(arr, 0 , arr.length-1);
		printArr(arr);
	}
	
	public static void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr,start, end); 
			sort(arr, start, pivot-1);
			sort(arr, pivot+1, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end], temp = 0;
		int pIndex = start;
		for (int i = start; i<=end-1; i++) {
			if (arr[i] <= pivot) {
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		temp = arr[end];
		arr[end] = arr[pIndex];
		arr[pIndex] = temp;
		return pIndex;
	}
	
	public static void printArr(int[] arr) {
		for (int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
