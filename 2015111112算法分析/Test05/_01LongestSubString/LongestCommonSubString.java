package _01LongestSubString;

public class LongestCommonSubString {
	public double LCSLength(char[] a, char[] b){
		// 参数验证
		if (a.length <= 0 || b.length <= 0|| a == null || b == null) {
			System.out.println("BUG参数错误：");
			return 0;
		}
		// L[m,n]
		double[][] L = new double[a.length][b.length];
		
		
		// 处理两个字符串
		for (int i = 0; i < a.length; i++) { //字符串a为y轴
			L[i][0] = 0;// 字符串 b 为空
		}
		for (int j = 0; j < b.length; j++) { //字符串b为x轴
			L[0][j] = 0;// 字符串 a 为空
		}
		
		for (int i = 1; i < a.length; i++) { //A子串中字符逐个增加
			for (int j = 1; j < b.length; j++) { //当A子串确定，B子串中字符逐个增加。
				if (a[i] == b[j]) {
					L[i][j] = L[i-1][j-1] +1;
				} else {
					L[i][j] = Math.max(L[i][j-1], L[i-1][j]);
				}
				System.out.println("数组：");
				for (double[] ds : L) {
					for (double d : ds) {
						System.out.print(" " + d);
					}
					System.out.println();
				}
			}
		}
		
		// 返回结果
		return L[a.length-1][b.length-1];
	}

}
/*for i←0 to n		//字符串A为y轴 
2.	L[i,0]←0		//字符串B为空
3.    end for
4.    for j←0 to m		//字符串B为x轴 
5.	L[0,j]←0		//字符串A为空
6.    end for
7.    for i←1 to n		//A子串中字符逐个增加
8.	for j←1 to m        //当A子串确定，B子串中字符逐个增加。
9.	      if ai=bj then L[i,j]←L[i-1,j-1]+1	    //i-1表示上一行
10.	      else L[i,j]←max{L[i,j-1],L[i-1,j]}  //j-1表示前一列
11.	      end if	
12.	end for
13.   end for
14.   return L[m,n]		//返回最长公共子序列长度
*/