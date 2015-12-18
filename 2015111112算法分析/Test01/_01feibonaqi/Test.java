package _01feibonaqi;

import java.util.Scanner;

public class Test {
	// 斐波那契算法
	public static long feiBoNaQie(int n){
		if (n <= 1 && n >=0) {
			return n;
		} else {
			return feiBoNaQie(n - 1) + feiBoNaQie(n - 2);
		}
	}
	// 将结果存入excel
	public void writeToExcel(String[] args){
		
	}
	// 运行测试
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入N：");
		int n = input.nextInt();
		long startTime = System.currentTimeMillis();
		// start斐波那契算法执行
		long result = feiBoNaQie(n);
		// end斐波那契算法执行
		long endTime = System.currentTimeMillis();
		System.out.println("执行结果为：" + result);
		System.out.println("执行时间为：" + (endTime-startTime) + "MS");
	}

}
