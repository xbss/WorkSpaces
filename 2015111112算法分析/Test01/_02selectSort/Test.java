package _02selectSort;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Test {
	// 产生随机数组
	public static double[] getRandomGroup(int n){
		double[] result = new double[n];
		DecimalFormat decimalFormat = new DecimalFormat("#");
		for (int i = 0; i < n; i++) {
			result[i] = Double.parseDouble(decimalFormat.format(Math.random() * 10000));
		}
		return result;
	}
	// 存入excel函数
	public static void writeExcel(Object[] args){
		
	}
	
	// 选择排序
	public static double[] selectSort(double[] arg){
		int min = 0;
		int j = 0;
		int i = 0;
		int length = arg.length;
		double temp = 0;
		for (; i < length-2; i++) {
			min = i;
			for (j = i+1; j < length-1; j++) {
				if (arg[j] < arg[min]) {
					temp = arg[j];
					arg[j] = arg[min];
					arg[min] = temp;
				}
			}
		}
		return arg;
	}
	
	// 执行主函数
	public static void main(String[] args){
		
		// 初始化参数
		Scanner input = new Scanner(System.in);
		System.out.println("请输入N：");
		int n = input.nextInt();
		
		// 产生数组
		double[] randomGroup = getRandomGroup(n);
		
		long startTime = System.currentTimeMillis();
		// start选择排序算法执行
		double[] result = selectSort(randomGroup);
		// end选择排序算法执行
		long endTime = System.currentTimeMillis();
		
		System.out.println("执行结果为：");
		for (double d : result) {
			System.out.print(" " + d + " ");
		}
		System.out.println("\n执行时间为：" + (endTime-startTime) + "MS");
	}

}
