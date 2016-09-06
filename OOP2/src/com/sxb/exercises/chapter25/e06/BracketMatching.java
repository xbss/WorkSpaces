package com.sxb.exercises.chapter25.e06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BracketMatching {
	
	/**
	 * @author shaoxiaobin 
	 * @category 对java源文件的括号匹配 {} / () / []
	 * */
	
	// 读文件bufferedreader
	BufferedReader bufferedReader;
	
	// 读文件
	public String processingFile(String file){
		file = file.trim();
		String temp[] = file.split("\\\\");
		String filename = temp[temp.length - 1];
		System.out.println("文件名: " + filename);
		// 判断是否为java文件
		if (file.contains(".java")) {
			// 判断是否存在文件
			if (new File(file).exists()&&new File(file).isFile()) {
				try {
					// 读写初始化
					bufferedReader = new BufferedReader(new FileReader(file));
					// 读入行字符串处理
					String line = "";
					String s = "";
					while (( s = bufferedReader.readLine()) != null) {
						line += s;
					}
					return line;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "";
				} finally{
					try{
						bufferedReader.close();
					}catch (IOException ex) {
						// TODO: handle exception
						ex.printStackTrace();
					}
				}
			} else {
				System.out.println("文件错误>>>>>>输入文件");
				return "";
			}
				
		}else {
			return "";
		}
	}
	// 判断括号的情况
	public boolean processingData(String data){
		int length = data.length();
		data =data.trim();
		GenericStack<Character> operandStack = new GenericStack<Character>();
		
		for (int i = 0; i < length; i++) {
			if (data.charAt(i) == '(') {
				operandStack.push('(');
			} else if (data.charAt(i) == '[') {
				operandStack.push('[');
			} else if (data.charAt(i) == '{') {
				operandStack.push('{');
			} else if (data.charAt(i) == ')') {
				operandStack.pop();
			} else if (data.charAt(i) == ']') {
				operandStack.pop();
			} else if (data.charAt(i) == '}') {
				operandStack.pop();
			} 
		}
		
		if (operandStack.isEmpty()) {
			return true;
		} else 
			return false;
	}
	// Main method 
	public static void main(String[] args){
		
		// 初始数据的处理
		System.out.print("输入文件名或者带路径的文件名：");
		Scanner inputScanner = new Scanner(System.in);
		String fileString = inputScanner.nextLine();
		
		// 对文件的处理
		BracketMatching bracketMatching = new BracketMatching();
		String data = bracketMatching.processingFile(fileString);
		if (data.isEmpty()) {
			System.out.println("文件为空或者不是java源文件！！！" + data);
		} else {
			// 处理数据并输出结果
			boolean result = bracketMatching.processingData(data);
			if (result) {
				System.out.println("   Java 源文件中的括号没有错误。");
			} else {
				System.out.println("   Java 源文件中的括号有错----->>>> Line:" + result);
			}
		}
	}
}
