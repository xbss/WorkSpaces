package com.sxb.exercises.chapter20.e22;

import java.util.Scanner;

/**
 * @author Administrator 十进制转十六进制
 * */
public class DecimalToHex {

	/**
	 * main method
	 */
	public static void main(String args[]) {

		// 初始化用户输入
		Scanner inScanner = new Scanner(System.in);
		System.out.print("Please enter your decimal nulmber: ");
		int value = inScanner.nextInt();
		// 打印结果
		if (value == 0)
			System.out.println("结果为：" + 0);
		else
			System.out.println(decimalToHex(value));
	}

	/**
	 * process the decimal value and print the result
	 */
	public static String decimalToHex(int value) {
		String hexNumber;
		if (value != 0) {
			if (value % 16 == 15) {
				hexNumber = "F";
			} else if (value % 16 == 14) {
				hexNumber = "E";
			} else if (value % 16 == 13) {
				hexNumber = "D";
			} else if (value % 16 == 12) {
				hexNumber = "C";
			} else if (value % 16 == 11) {
				hexNumber = "B";
			} else if (value % 16 == 10) {
				hexNumber = "A";
			} else {
				hexNumber =  (value % 16) +"";
			}
			
			return decimalToHex(value / 16) + hexNumber;
		} else 
			return "";
	}
}
