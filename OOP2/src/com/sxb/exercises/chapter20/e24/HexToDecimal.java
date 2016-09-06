package com.sxb.exercises.chapter20.e24;

import java.util.Scanner;


/**
 * @author Administrator 十进制转十六进制
 * */
public class HexToDecimal {

	/**
	 * main method
	 */
	public static void main(String args[]) {

		// 初始化用户输入
		Scanner inScanner = new Scanner(System.in);
		System.out.print("Please enter your hex nulmber: ");
		String hexsString = inScanner.nextLine();
		hexsString = hexsString.trim();
		System.out.println(hexsString.length());
		// 打印结果
		if (hexsString.length()==0) {
			System.out.println("输入结果为空 ！！！");
		} else if (hexsString.equals("0"))
			System.out.println("结果为：" + 0);
		else
			System.out.println("结果为：" +hexToDecimal(hexsString , hexsString.length()));
	}
	
	/**
	 * process hex String
	 */
	public static int hexToDecimal(String hexString,int  length){
		
		int value = 0;
		length = length - 1;
		System.out.println(length);
		if (length < 0) {
			return 0;
		} else {
			 if (hexString.charAt(length) == 'F') {
					value = 15;
				} else if (hexString.charAt(length) == 'E') {
					value = 14;
				} else if (hexString.charAt(length) == 'D') {
					value = 13;
				} else if (hexString.charAt(length) == 'C') {
					value = 12;
				} else if (hexString.charAt(length) == 'B') {
					value = 11;
				} else if (hexString.charAt(length) == 'A') {
					value = 10;
				} else  {
					value = hexString.charAt(length) - '0';
				}
			 return 16 * hexToDecimal(hexString, length)+ value;
		}
	}
}
