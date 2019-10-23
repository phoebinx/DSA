package DCT.Arrays;

public class SortLeftRightNum {
	public static void main(String args[]) {
		int arr [] = {1,5,15,21,7,9,11};
		//int arr [] = {1};
		
		//int arr [] = {30,9,5,6,4,3,7,8,9,3,2,6,8,4};
		//sort(arr,10);
		int result = efficientSort(arr,10);
		System.out.println(result);
		for (int i:arr) {
			System.out.print(i+" ");
		}
		
//		if (result <= arr.length-1) {
//			efficientSortDiv(arr, result);
//		}
		
	}
	
	
	public static int efficientSortDiv(int [] arr, int num) {
		if (arr.length<1) {
			return -1;
		} else if (arr.length == 1 && arr[0] <= num) {
			return 1;
		}
		int pStart = 0;
		int pEnd = arr.length-1;
		int temp=0;
		while(pStart<pEnd) {
			if(arr[pStart] > num) {
				if (arr[pEnd] < num) {
					//System.out.println(arr[pStart]+"swap"+arr[pEnd]);
					temp = arr[pStart];
					arr[pStart] = arr[pEnd];
					arr[pEnd] = temp;
					pStart++;
					pEnd--;
				} else {
					pEnd--;
				}
			} else {
				pStart++;
			}
		}
		return (pStart==pEnd)?pEnd:pEnd+1;
	}
	 
	
	
	
	public static int efficientSort(int [] arr, int num) {
		if (arr.length<1) {
			return -1;
		} else if (arr.length == 1 && arr[0] <= num) {
			return 1;
		}
		int pStart = 0;
		int pEnd = arr.length-1;
		int temp=0;
		while(pStart<pEnd) {
			if(arr[pStart] > num) {
				if (arr[pEnd] < num) {
					//System.out.println(arr[pStart]+"swap"+arr[pEnd]);
					temp = arr[pStart];
					arr[pStart] = arr[pEnd];
					arr[pEnd] = temp;
					pStart++;
					pEnd--;
				} else {
					pEnd--;
				}
			} else {
				pStart++;
			}
		}
		return (pStart==pEnd)?pEnd:pEnd+1;
	}
	
	
	public static void sort(int [] arr, int num) {
		if (arr.length<1) {
			return;
		}
		int pIndex = 0;
		int temp=0;
		for (int i =0; i<arr.length;i++) {
			if (arr[i] <= num) {
				temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex++;
			}
		}
		System.out.println(pIndex);
	}
}
