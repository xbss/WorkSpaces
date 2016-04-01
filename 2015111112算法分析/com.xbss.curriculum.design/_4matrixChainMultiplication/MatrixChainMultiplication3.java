package _4matrixChainMultiplication;

import java.util.ArrayList;

public class MatrixChainMultiplication3 {
	public static String NAME= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public int LEN = 0;
	public int MIN;
	public int M[][];
	public int S[][];
	
	public String result = "";
	public String[] resultStrings;
	
	// data
	public static String firstString = "1,2,5,2,6";
	// 记录轨迹
	public ArrayList<String> L1 = new ArrayList<String>();
	public ArrayList<String> L2 = new ArrayList<String>();
	
	
	public MatrixChainMultiplication3(){
		System.out.println("构建实例");
	}
	
	public void run(){
		MIN = 0;
		String[] firStrings = firstString.split(",");
		String squer=""; 
		
		System.out.println("数组：");
		for (String string : firStrings) {
			System.out.print(" " + string);
		}
		System.out.println();
		LEN = firStrings.length - 1;
		int[] firstStringInt = new int[firStrings.length];
		resultStrings = new String[LEN];
		// 
		for (int i = 0; i < LEN; i++) {
			//squer += name.charAt(i) + ":" + firStrings[i]  + "*" + firStrings[i+1] + " ";
			squer += "A" + i + ":" + firStrings[i]  + "*" + firStrings[i+1] + " ";
			resultStrings[i] = firStrings[i]  + "*" + firStrings[i+1];
		}
		for (int i = 0; i < firStrings.length; i++) {
			firstStringInt[i] = Integer.valueOf(firStrings[i]);
		}
		System.out.println();
		System.out.println("矩阵链Squer: " + squer);
		// 初始化数组
		M = new int[LEN][LEN];
		S = new int[LEN][LEN];
		
		for (int i = 0; i < LEN; i++) {
			for (int j = 0; j < LEN; j++) {
				M[i][j] = 0;
				S[i][j] = 0;
			}
		}
		
		for (int i = 0; i < LEN; i++) {
			L1.add("["+ i + "," + i +"]");
			L2.add("["+ i + "," + i +"]");
		}
		
		// 计算最小需要的计算次数
		MtrixChain(firstStringInt,M,S);
		// 矩阵相乘的顺序为：
		Display(S,NAME,0,LEN-1);
		System.out.println("reuslt:" + result);
		System.out.println("resultStrings:");
		for (int i = 0; i < LEN; i++) {
			System.out.print(resultStrings[i] + " ");
		}
		System.out.println();
		System.out.println("L1");
		for (String i : L1) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println("L2");
		for (String i : L2) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	
	/**
	 * @title 计算值
	 * @param a
	 * @param m
	 * @param s
	 */
	public void MtrixChain(int[]a,int[][] m,int[][] s){
		int t = 0;
		int min = 0;
		int temp = 0;
		int n = a.length;
		/*for (int i = 2; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				t = j + i -1;*/
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < n-i; j++) {
				t = j + i -1;
				m[j][t] = Integer.MAX_VALUE;
				for (int k = j; k < t; k++) {
					/*
					 * 利用的算法
					 * C[i][j] = C[i][k] + C[k+1][j] +r[i]*r[k+1]*r[j+1]
					 * 1 <= i <= j <= n
					 * i <= k <= j-1
					 * C[i][j] = min{C[i][k-1] + C[k][j] + r[i]*r[k]*r[j]}    (i<j)
					 */
					temp = m[j][k] + m[k+1][t] + a[j]*a[k+1]*a[t+1];
					L1.add("["+ j + "," + k +"]");
					L2.add("["+ (k+1) + "," + t +"]");
					if (temp < m[j][t]) {
						min = temp;
						// 保留最小耗费
						m[j][t] = temp;
						// 保留最小耗费的k
						s[j][t] = k;
					}
				}
			}
		}
		
		MIN = min;
	}
	
	/**
	 * @title 显示最终结果
	 * @param s
	 * @param name
	 * @param i
	 * @param j
	 */
	public void Display(int[][] s,String name,int i,int j){
		System.out.println(result);
		if (i == j) {
			//result += name.charAt(i);
			//result += "A" + i;
			result += resultStrings[i];
			
		}else {
			result += "(";
			Display(s, name, i, s[i][j]);
			result += "*";
			Display(s, name, s[i][j] +1, j);
			result += ")";
		}
	}
}
