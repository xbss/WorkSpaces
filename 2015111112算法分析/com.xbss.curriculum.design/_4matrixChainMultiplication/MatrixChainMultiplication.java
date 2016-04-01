package _4matrixChainMultiplication;

/**
 * @title 矩阵链相乘-使用动态规划算法
 * @author XBSS
 *
 */
public class MatrixChainMultiplication {
	public String dataString = "10,100,5,50";
	public int n;
	public String[] dataSplit;
	public int[] dataSplitInt;
	public int m[][]; // 表示子序列相乘的最小次数
	public int p[][];  // 表示子序列被分成i，k 和 k+1 组

	public MatrixChainMultiplication() {
		// 初始化 分割字符串得到相乘矩阵
		this.dataSplit = this.dataString.split(",");
		this.n = dataSplit.length;
		this.dataSplitInt = new int[n];
		for (int i = 0; i < n; i++) {
			this.dataSplitInt[i]  = Integer.valueOf(this.dataSplit[i]);
		}
		//
		m = new int[n][n];
		p = new int [n][n];
	}

	public void MatriChain (int[][] p, int n, int[][] c) {
		int i, j, k, t;
		// 初始化一个矩阵的情况，
		// 因为一个矩阵不做乘法
		// 填充对角线为0
		for (i = 0; i <= n; i++) {
			m[i][i] = 0;
		}
		
		// 
	}
}
