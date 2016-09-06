package com.sxb.exercises.chapter25.e08;

import java.util.Scanner;

public class ExpressionLast {

	/**
	 * @author shaoxiaobin
	 * @category 计算后缀表达式
	 * @param expression 后缀表达式
	 */
	public static void main(String[] args) {
		
		// 输入表达式的值
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Enter your expressions:");
		String expression = inputScanner.nextLine();
		try {
			// 对字符串进行处理打印结果
			System.out.println("The result is: " + evaluateExpression(expression));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Your expression is wrong!!!");
			e.printStackTrace();
		}

	}
	
	/** 计算表达式 */
	public static int evaluateExpression(String expression){
		GenericStack<Integer> operand = new GenericStack<Integer>();
		String[] oper = expression.split(" ");
		
		for (String string : oper) {
			char c = string.charAt(0);
			System.out.println(c);
			if (c == ' ') {
				continue;
			} else if (c == '+' || c == '-' || c == '*' || c == '/') {
				processOperator(c, operand);
			} else 
				operand.push(new Integer(c) - 48);
		}
		return (Integer)operand.pop();
	}
	/** 对操作数处理 */
	public static void processOperator(char operator, GenericStack<Integer> operand){
		if (operator == '+') {
			int val1 =  operand.pop();
			int val2 = operand.pop();
			operand.push(val2 + val1);
		} else if (operator == '-') {
			int val1 =operand.pop();
			int val2 =  operand.pop();
			operand.push(val2 - val1);
		} else if (operator == '*') {
			int val1 = operand.pop();
			int val2 = operand.pop();
			operand.push(val2 * val1);
		} else if (operator == '/') {
			int val1 = operand.pop();
			int val2 = operand.pop();
			operand.push(val2 / val1);
		}
	}

}
