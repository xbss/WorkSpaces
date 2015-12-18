package _02MergeSort;

import java.text.DecimalFormat;

public class MergeSort {
	// 产生随机数组
	public static double[] getRandomGroup(int n) {
		double[] result = new double[n];
		DecimalFormat decimalFormat = new DecimalFormat("#");
		for (int i = 0; i < n; i++) {
			result[i] = Double
					.parseDouble(decimalFormat.format(Math.random() * 10000));
		}
		return result;
	}

	public static double[] Sort(double[] data, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			Sort(data, low, mid);
			Sort(data, mid + 1, high);
			MergeSortMethod(data, low, mid, high);
		}
		return data;
	}

	public static void MergeSortMethod(double[] data, int low, int mid, int high) {
		double[] temp = new double[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (data[i] < data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = data[i++];
		}
		while (j <= high) {
			temp[k++] = data[j++];
		}
		System.out.print("\nRUN LOG:");
		for (double d : data) {
			System.out.print("   " + d);
		}
		System.out.println();

		for (int k2 = 0; k2 < temp.length; k2++) {
			data[k2 + low] = temp[k2];
		}
	}

	public static void main(String[] args) {
		int n = (int) (Math.random() * 50);
		double[] data = getRandomGroup(n);
		System.out.println("\n排序前的数组：");
		for (double d : data) {
			System.out.print("   " + d);
		}
		System.out.println("\n排序处理中的数组：");
		Sort(data, 0, data.length - 1);
		System.out.println("\n排序后的数组：");
		for (double d : data) {
			System.out.print("   " + d);
		}
	}
}
