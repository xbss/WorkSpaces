package _3longestCommonSubSequence;

public class LongestCommonSubString {
	public double LCSLength(char[] a, char[] b){
		// 参数验证
		if (a.length <= 0 || b.length <= 0|| a == null || b == null) {
			System.out.println("BUG参数错误：");
			return 0;
		}
		// L[m,n]
		int m = a.length; //6
		int n = b.length; //5
		System.out.println("a:" +m);
		System.out.println("b:" +n);
		
		int[][] L = new int[m+1][n+1];
		System.out.println("L " + L.length);
		String result = "";
		
		// 处理两个字符串
		/*for (int i = 0; i < m; i++) { //字符串A为y轴  n
			//L[i][0] = 0;// 字符串 B 为空 
			for (int j = 0; j < n; j++) {
				L[i][j] = 0;
			}
		}*/
		/*for (int j = 0; j < n; j++) { //字符串B为x轴 m
			L[0][j] = 0;// 字符串 A 为空
		}*/
		for(int i=0;i<m+1;i++)
	        L[i][0]=0;
	    for(int j=0;j<n+1;j++)
	        L[0][j]=0;
		int max = 0;
		for (int i = 1; i <=m; i++) { //A子串中字符逐个增加
			for (int j = 1; j <= n; j++) { //当A子串确定，B子串中字符逐个增加。
				if (a[i-1] == b[j-1]) {
					L[i][j] = L[i-1][j-1] +1; //i-1表示上一行
					System.out.print(" " + b[j-1] + " " + i +" "+  j);
					//System.out.println("L[][] == :" + L[i][j]);
				} else {
					L[i][j] = Math.max(L[i][j-1], L[i-1][j]); //j-1表示前一列
					//System.out.println("L[][] != :" + L[i][j]);
				}
				if(L[i][j] > max){
					max = L[i][j];
					if (a[i-1] == b[j-1]) 
						result += a[i-1];
				}
				System.out.println("数组：");
				for (int[] ds : L) {
					for (int d : ds) {
						System.out.print(" " + d);
					}
					System.out.println();
				}
			}
		}
		
		/*for(int k=2;k<m+2;k++){
		       for(int l=2;l<n+2;l++){
		           if(a[k-2] == b[l-2]){
		        	   System.out.println("a:" + a[k-2] + " b:" + b[l-2]);
		        	   System.out.println("k-1:" + k + " l-1:" + l);
		               L[k][l-1] = L[k-1][l-1] + 1;
		               //console.log("k:"+k+",l:"+l+"   "+table[k-1][l-1]);
		           }else{
		               //console.log("k:"+k,"l:"+l);
		               L[k][l-1] = Math.max(L[k][l-1],L[k-1][l]);
		           }
		        }
		    }*/
		
		
		/*for(int i = 1; i<= m; i++)
	    {
	        for(int j = 1; j <= n; j++)
	        {
	            if(a[i-1] == b[j-1])
	            {
	                L[i][j] = L[i-1][j-1] + 1;
	            }
	            else if(L[i-1][j] >= L[i][j-1])
	            {
	                L[i][j] = L[i-1][j];
	            }
	            else
	            {
	                L[i][j] = L[i][j-1];
	            }
	        }
	    }*/
		System.out.println("max:" + max);
		System.out.println("reuslt:" + result);
		System.out.println("数组：");
		for (int[] ds : L) {
			for (int d : ds) {
				System.out.print(" " + d);
			}
			System.out.println();
		}
		// 返回结果
		return L[m][n];
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


构造最长公共子序列
void LCS(int i，int j，char *x，int **b)
{
      if (i ==0 || j==0) return;
      if (b[i][j]== 1){ LCS(i-1，j-1，x，b); cout<<x[i]; }
      else if (b[i][j]== 2) LCS(i-1，j，x，b);
      else LCS(i，j-1，x，b);
}

*/