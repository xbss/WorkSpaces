package _03quickSelect;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
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

	// 存入excel函数
	public static void writeExcel(Object[] args) {

	}
	
	// 划分方法
	public static int LomutoPartition(double[] A, int l, int r){
		
		double p = A[l];
		int s = l;
		int i = l+1;
		double temp = 0;
		
		for(; i < r; i++){
			if (A[i] < p) {
				s += 1;
				temp = A[s];
				A[s] = A[i];
				A[i] = temp;
			}
		}
		temp = A[l];
		A[l] = A[s];
		A[s] = temp;
		return s;
	}
	

	// 快速选择
	public static double quickSelect(double[] A, int l, int r, int k) {
		int s = LomutoPartition(A, l, r);
		if (s == l+k-1) {
			return A[s];
		} else if (s > l+k-1) {
			return quickSelect(A, l, s-1, k);
		} else {
			return quickSelect(A, s+1, r, l+k-1-s);
		}
		
	}

	// 执行主函数
	public static void main(String[] args) {

		// 初始化参数
		Scanner input = new Scanner(System.in);
		System.out.println("请输入初始化数组大小N：");
		int n = input.nextInt();
		System.out.println("请输入初始化寻找最小元素K：");
		int k = input.nextInt();

		// 产生数组
		double[] randomGroup = getRandomGroup(n);

		long startTime = System.currentTimeMillis();
		// start快速查找算法执行
		double result = quickSelect(randomGroup, 0, randomGroup.length, k);
		// end快速查找算法执行
		long endTime = System.currentTimeMillis();

		// 输出执行结果
		System.out.println("\n执行结果为：" + result);
		// 输出执行时间
		System.out.println("\n执行时间为：" + (endTime - startTime) + "MS");
	}

}
