package _01QuickSort;

import java.text.DecimalFormat;

public class QuickSort {
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

	private static void QuickSortMethod(double[] data, int l, int r) {
		int s;
		if (l < r) {
			s = Partition(data, l, r);
			QuickSortMethod(data, l, s - 1);
			QuickSortMethod(data, s + 1, r);
		}
	}

	private static int Partition(double[] data, int l, int r) {
		double p = data[l];
		int i = l;
		int j = r + 1;
		double temp;
		while (true) {
			do {
				i++;
			} while (i <= r && data[i] < p);
			do {
				j--;
			} while (data[j] > p);
			if (i > j) {
				break;
			}
			// 执行交换
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
		}
		// 执行交换
		temp = data[l];
		data[l] = data[j];
		data[j] = temp;
		System.out.print("\nRUN LOG:");
		for (double d : data) {
			System.out.print("   " + d);
		}
		System.out.println();
		return j;
	}

	public static void main(String[] args) {
		int n = (int) (Math.random() * 50);
		double[] data = getRandomGroup(n);
		System.out.println("\n排序前的数组：");
		for (double d : data) {
			System.out.print("   " + d);
		}
		System.out.println("\n排序处理中的数组：");
		QuickSortMethod(data, 0, data.length - 1);

		System.out.println("\n排序后的数组：");
		for (double d : data) {
			System.out.print("   " + d);
		}
	}
}
