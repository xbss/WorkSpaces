package com.sxb.exercises.chapter22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class E22_3 {

	/**
	 * @param args
	 * @throws IOException
	 * @author Administrator 统计java源文件关键字
	 */

	// java关键字
	public static String KEYWORDS[] = 
		{"abstract","assert","boolean","break","byte","case","catch","class","const","continue",
			"default","do","double","else","enum","extends","final","finally","float","for",
			"if","implements","import","instanceof","int","interface","long",
			"native","new","package","private","protected","public","return","short","static",
			"strictfp","super","switch","synchrpnized","this","throw","throws","transient","try","void","volatile","while"};
	// 存储关键字的信息
	public HashMap<String, Integer> result = new HashMap<String, Integer>();
	// 统计单个关键字的出现次数
	public int count;
	
	/* 处理信息 */
	public void ProcessingData(BufferedReader bufferedReader) throws IOException{
		// 将信息录入map
		for (int i = 0; i < KEYWORDS.length; i++) {
			result.put(KEYWORDS[i], 0);
		}
		// 处理读出的字符串
		String line = null;
		String words[];
		while ((line = bufferedReader.readLine())!= null) {
			// 以空格为分割符号 转换字符串
			words = line.trim().split(" ");
			for (int i = 0; i < words.length; i++) {
				if (result.containsKey(words[i])) {
					count++;
					result.put(words[i], new Integer(result.get(words[i]) + 1));
				}
			}
		}
	}
	/* 打印处理后的信息 */
	public void PrintData(){
		System.out.println("文件中关键字总数为：" + count);
		System.out.println("每个关键字的出现次数为：");
		@SuppressWarnings("rawtypes")
		Iterator iterator = result.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println(key +":  " + result.get(key));
			
		}
	}
	/* 主函数 */
	public static void main(String[] args) throws IOException {
		System.out.println("输入文件信息：");
		Scanner inputScanner = new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(inputScanner.nextLine().toString()));
		E22_3 e22_3 = new E22_3();
		e22_3.ProcessingData(bufferedReader);
		e22_3.PrintData();
		bufferedReader.close();
	}

}
