package Sorting;

import java.util.Scanner;

public class ArrayBubbleSort {
	public int arr[];
	public int length;

	private void getElements() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter number of elements in array:");
		length = reader.nextInt();
		arr = new int[length];
		System.out.println("Enter array items:");
		try {
			for (int i = 0; i < length; i++) {
				arr[i] = reader.nextInt();
			}
		} catch (Exception e) {
		}
	}

	private void displayArray() {
		for (int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private void sortArray() {
		boolean switched;
		for (int outer = length - 1; outer >= 1; outer--) {
			switched = false;
			for (int inner = 0; inner < outer; inner++) {
				if (arr[inner] > arr[inner + 1]) {
					swap(inner);
					switched = true;
				}
			}
			if (switched == false) {
				break;
			}
		}
	}

	private void swap(int inner) {
		int temp = arr[inner];
		arr[inner] = arr[inner + 1];
		arr[inner + 1] = temp;
	}

	public static void main(String args[]) {
		ArrayBubbleSort obj = new ArrayBubbleSort();
		obj.getElements();
		System.out.println("Array entered: ");
		obj.displayArray();
		long startTime = System.nanoTime();
		obj.sortArray();
		long endTime = System.nanoTime();
		System.out.println("Sorted Array: ");
		obj.displayArray();
		System.out.println("Time for execution: " + (endTime - startTime) + " nano sec");
	}
}
