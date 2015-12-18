package _02Knasack;
/**
 * 
 * @author XBSS
 * @title 使用动态规划解决背包问题
 *
 */
public class Test01 {
	public static void main(String[] args){
		Knapsack knapsack = new Knapsack();
		double C = 9;
		double[] S = {2,3,4,5};
		double[] V = {3,4,5,8};
		System.out.println("最大总价值为：" + knapsack.max(C, S, V));
	}

}
