package com.sxb.exercises.chapter22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.transform.Templates;
/**
 * @param args
 * @throws IOException
 * @author 小小镔 将java源文件转换为HTML文件
 */
public class E22_10 {
	// java关键字，用于HTML中的加粗和红色字体
	public static String KEYWORDS[] = { "abstract", "assert", "boolean",
			"break", "byte", "case", "catch", "class", "const", "continue",
			"default", "do", "double", "else", "enum", "extends", "final",
			"finally", "float", "for", "if", "implements", "import",
			"instanceof", "int", "interface", "long", "native", "new",
			"package", "private", "protected", "public", "return", "short",
			"static", "strictfp", "super", "switch", "synchrpnized", "this",
			"throw", "throws", "transient", "try", "void", "volatile", "while" };
	// 转义字符串
	public String transportationString = null;
	// 读入文件BufferedReader
	public BufferedReader bufferedReader;
	// 输出文件BufferedWriter
	public BufferedWriter bufferedWriter;

	/* 处理Java源文件 */
	public void ProcessingJavaFile(String fileString) throws IOException{
		fileString = fileString.trim();
		String temp[] = fileString.split("\\\\");
		String filename = temp[temp.length - 1];
		System.out.println("filename: " + filename);
		
		if (new File(fileString).exists()&&new File(fileString).isFile()) {
			try {
				// 读写初始化
				bufferedReader = new BufferedReader(new FileReader(fileString));
				bufferedWriter = new BufferedWriter(new FileWriter(filename
						+ ".html"));
				// 读入行字符串处理
				String line;
				transportationString = "<html><title>" + filename+ "</title><body margin=20><font size=1 face=arial>" +
						"<p align=" + "center" + "><font color=purple size=15>" + filename + "</font></p>";
				while ((line = bufferedReader.readLine()) != null) {
					line = TransportToHtml(line);
					line += "</br>";
					transportationString += line;
				}
				transportationString += "</font></body></html>";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try{
					bufferedReader.close();
				}catch (IOException ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}
		} else 
			System.out.println("文件错误>>>>>>输入文件");
	}
	/* 转换行字符窜为HTML格式 */
	public String TransportToHtml(String javaString) {
		javaString = javaString.replace("&", "&amp;");
		javaString = javaString.replace(" ", "&nbsp;");
		javaString = javaString.replace("<", "&lt;");
		javaString = javaString.replace(">", "&gt;");
		javaString = javaString.replace("\"", "&quot;");
		javaString = javaString.replace("	", "&nbsp;&nbsp;&nbsp;&nbsp;");
		for (int i = 0; i < KEYWORDS.length; i++) {
			javaString = javaString.replace(KEYWORDS[i], "<b><font color=red>" + KEYWORDS[i] + "</b></font>");
		}
		// 加注释
		String t = javaString.replace("//", "<font color=green>//");
		if (!javaString.equals(t)) {
			javaString = t + "</font>";
		}
		t = javaString.replace("/*", "<font color=blue>/*");
		if (!javaString.equals(t)) {
			javaString = t + "</font>";
		}
		t = javaString.replace("/**", "<font color=blue>/*");
		if (!javaString.equals(t)) {
			javaString = t + "</font>";
		}
		return javaString;
	}

	/* 写入文件 */
	public boolean WriteToFile() {
		if (bufferedWriter.toString() != null) {
			try {
				bufferedWriter.write(transportationString);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			} finally {
				try {
					bufferedWriter.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return true;
		} else {
			System.out.println("文件错误>>>>>Writer");
			return false;}
	}
	/* 主函数 */
	public static void main(String[] args) throws IOException {
		System.out.println("输入文件信息：");
		Scanner inputScanner = new Scanner(System.in);
		String string = inputScanner.nextLine();
		E22_10 e22_10 = new E22_10();
		e22_10.ProcessingJavaFile(string);
		if (e22_10.WriteToFile()) {
			System.out.println("恭喜你 ，Java 文件转  HTML 文件成功");
		}
	}

}
