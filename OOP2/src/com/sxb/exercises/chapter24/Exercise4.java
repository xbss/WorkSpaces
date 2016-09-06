package com.sxb.exercises.chapter24;

import java.util.Arrays;

public class Exercise4 {
	public static void quickSort(int[] list) {
		int index = 0;
		int number1 = list[0];
		int number2 = list[list.length / 2];
		int number3 = list[list.length - 1];

		Integer[] arr = new Integer[] { number1, number2, number3 };
		Arrays.sort(arr);
		for (int i = 0; i < list.length; i++) {
			if (arr[1] == list[i]) {
				index = i;
			}
		}
		quickSort(list, index, list.length - 1);
	}

	private static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	private static int partition(int[] list, int first, int last) {
		int pivot = list[first];
		int low = first + 1;
		int high = last;

		while (high > low) {
			while (low <= high && list[low] <= pivot)
				low++;

			while (low <= high && list[high] > pivot)
				high--;

			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high] >= pivot)
			high--;

		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		} else {
			return first;
		}
	}

	public static void main(String[] args) {
		int[] list = { 7, 8, 9, 5, 6, -1, -2, 3, -14, 12 };
		quickSort(list);
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
}
