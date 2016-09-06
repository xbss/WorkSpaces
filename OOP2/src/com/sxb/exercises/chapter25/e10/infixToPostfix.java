package com.sxb.exercises.chapter25.e10;

import java.util.Scanner;

public class infixToPostfix {

	/**
	 * @author shaoxiaobin
	 * @category 中缀转后缀
	 */
	public static void main(String[] args) {
		// 输入表达式的值
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter your expressions:");
		String expression = inputScanner.nextLine();
		try {
			// 对字符串进行处理打印结果
			System.out.println("The result is: "
					+ processExpression(expression));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Your expression is wrong!!!");
		}
	}

	// 处理表达式
	public static String processExpression(String expression) {
		GenericStack<Character> operator = new GenericStack<Character>();
		String result = "";
		expression = expression.trim();
		char[] chars = expression.toCharArray();
		
		// 对字符转换的字符进行处理
		for (char c : chars) {
			if (c == '+' || c == '-') {
				while (!operator.isEmpty()
						&& (operator.peek().equals('+')
								|| operator.peek().equals('-')
								|| operator.peek().equals('*') || operator
								.peek().equals('/'))) {
					result += operator.pop() + " ";
				}
				operator.push(new Character(c));
			} else if (c == '*' || c == '/') {
				while (!operator.isEmpty()
						&& (operator.peek().equals('*') || operator.peek()
								.equals('/'))) {
					result += operator.pop() + " ";
				}
				operator.push(new Character(c));
			} else if (c == '(') {
				operator.push(new Character('('));
			} else if (c == ')') {
				while (!operator.peek().equals('(')) {
					result += operator.pop() + " ";
				}
				operator.pop();
			} else {
				result += c + " ";
			}
		}
		// 把所有的操作符都加入result
		while (!operator.isEmpty()) {
			result += operator.pop() + " ";
		}
		
		return result;
	}
}
