package _02Knasack;

public class Knapsack {
	public double max(double C, double[] S, double[] V){
		// 参数判断
		if (C <= 0|| S.length <= 0 || V.length <= 0) {
			System.out.println("Error");
			return 0;
		}
		// 定义一个 二维数组V[0..n,0..C]用于计算和存放V[i,j]的值
		double[][] L = new double[S.length][(int) C];
		
		// 处理过程
		for (int i = 0; i < S.length; i++) {
			L[i][0] = 0; // 背包容量为0
		}
		for (int i = 0; i < C; i++) {
			L[0][i] = 0; // 背包未装入任何物品
		}
		
		for (int i = 1; i < S.length; i++) {
			for (int j = 0; j < C; j++) {
				if (S[i] > j) { //物品ui体积si超过容量j，不装入。
					L[i][j] = L[i-1][j]; //取Ui-1的计算结果
				} else { //物品ui体积si不超过容量j，可装入。
					L[i][j] = Math.max(L[i-1][j], L[i-1][(int) (j-S[i])] + V[i]);
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
		
		return L[S.length-1][(int) (C-1)];
	}

}
/*算法7.4  Knapsack(Page 139)
输入：背包容量C、物品体积集合S={s1,s2,...,sn}、物品价值集合V={v1,v2,...,vn}。
输出：可装入背包物品的最大总价值。
(定义一个 二维数组V[0..n,0..C]用于计算和存放V[i,j]的值)
1.	for i←0 to n  V[i,0]←0		//背包容量为0
2.	for j←0 to C V[0,j]←0		//背包未装入任何物品
3.	for i←1 to n
4.	      for j←1 to C
5.		if si>j then 	 //物品ui体积si超过容量j，不装入。
6.		      V[i,j]←V[i-1,j]		//取Ui-1的计算结果
7.		else		 //物品ui体积si不超过容量j，可装入。
8.		      V[i,j]←max{V[i-1,j],V[i-1,j-si]+vi}
9.		end if
10.	      end for
11.	end for
12.	return V[n,C]				//返回最大总价值
*/