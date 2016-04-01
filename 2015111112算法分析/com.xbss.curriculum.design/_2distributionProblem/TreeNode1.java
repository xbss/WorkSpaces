package _2distributionProblem;

import java.util.ArrayList;

public class TreeNode1 {
	ArrayList<TreeNode1> child = new ArrayList<>();
	boolean isPath = false; // 用来生成树的最终路径
	int index = 0;
	int worker = 0; // 该点代表的人序号，即是第几个工人
	int task = 0; // 分配的任务
	int cost = 0; 
	public TreeNode1(int worker, int task){
		this.worker = worker;
		this.task = task;
	}
	/**
	 * @title 由当前分配工人计算剩下的工人的最优解 消耗
	 * @param TASK
	 * @param COST
	 * @param parentCost
	 */
	public void caculateCost(int TASK[], int[][] COST){
		int rowMin = 0; // 行最小
		int index = 0; // 行最小 索引
		int n = TASK.length;
		for (int i = 0; i < n; i++) {
			rowMin = 1000000; // 每次都设为最大值
			index = -1; // 每次都设置为 最小值
			
			if (i <= worker) {
				for (int j = 0; j < COST[i].length; j++) {
					if (TASK[j] == i ) {
						this.cost += COST[i][j];
					}
				}
			} else {
				// 在未分配的人员和人员 才会去向下寻找行最小，也就是剩下的人员分配最小 cost
				for (int j = 0; j < n; j++) {
					if(COST[i][j] < rowMin && TASK[j] < 0){
						rowMin = COST[i][j];
						index = j;
					}
				}
				TASK[index] = i;
				System.out.println("行最小：" + rowMin + "cost: " +this.cost);
				this.cost += rowMin;
			}
			
		}
	}
}
