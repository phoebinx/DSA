package DCT;

public class MergeSortPgm {
	
	public static void main(String args[]) {
		int arr[] = {7,2,1,4,8,5,3,4};
		mergeSort(arr,arr.length);
		for (int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void mergeSort(int arr[], int length) {
		if (length<2) {
			return;
		}
		int mid = length/2;
		int left[] = new int[mid];
		int right[] = new int[length-mid];
		for (int i =0; i<=mid-1; i++) {
			left[i] = arr[i];
		}
		for (int i =mid; i<arr.length; i++) {
			right[i-mid] = arr[i];
		}
//		System.out.println("new");
//		for (int i:left) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
//		for (int i:right) {
//			System.out.print(i+" ");
//		}
		mergeSort(left,mid);
		mergeSort(right,length-mid);
		merge(left,right,arr);
		
	}
	
	public static void merge(int left[], int right[], int arr[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i<left.length && j<right.length) {
			if (left[i]<right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}
		while (i<left.length) {
			arr[k++] = left[i++];
		}
		
		while (j<right.length) {
			arr[k++] = right[j++];
		}
		return;
	}
		
}
