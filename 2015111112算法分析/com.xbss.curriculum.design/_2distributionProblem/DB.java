package _2distributionProblem;

import java.util.zip.CRC32;

/**
 * 
 * @author XBSS
 * @title 分配问题 求解 利用分支限界法
 */
public class DB {
	public static int COST[][] = {
		{ 9, 2, 7, 8 },
		{ 6, 4, 3, 7 },
		{ 5, 8, 1, 8 }, 
		{ 7, 6, 9, 4 } }; // 消耗 x 任务，y 人员
	public static int TASK[] = new int[4]; // 任务 0 未分配 1 已分配
	public static int WORKER[] = new int[4]; // 工人 0 未有任务 1 已有任务
	public static int TEMP[] = new int[4]; // 存储分配方案 ，即是分配的路径
	public static int MINCOST = 100000; // 最小，每次循环都要做判断，与其比较cost

	public DB() {
		for (int t : TASK) {
			t = 0;
		}

		for (int w : WORKER) {
			w = 0;
		}
	}

	/**
	 * @title 分支限界法
	 */
	public void BranchAndBround(int currentTask, int cost) {
		if (currentTask >= TASK.length && cost < MINCOST) {
			MINCOST = cost;
			for (int i = 0; i < TASK.length; i++) {
				TEMP[i] = TASK[i];        // 工人 i 完成任务 TASK[i]
			}
		} else {
			for (int i = 0; i < TASK.length; i++) {
				// 分配任务 currentTask
				if (WORKER[i] == 0) {
					WORKER[i] = 1;
					TASK[currentTask] = i; // 任务 currentTask 分配给 工人 i
					System.out.println(" 工人：" + i + " 工作： " + currentTask+" cost:" + cost + " mincost:" +MINCOST );
					BranchAndBround(currentTask + 1, cost + COST[currentTask][i]);
					WORKER[i] = 0;
					TASK[currentTask] = 0;
				}
			}
		}
	}

	/**
	 * @title main method
	 * @param args
	 */
	public static void main(String[] args) {
		DB db = new DB();

		db.BranchAndBround(0, 0); // 从任务0开始分配

		System.out.println("任务消耗为：\n");
		for (int[] d : db.COST) {
			for (int i : d) {
				System.out.printf("%5d", i);
			}
			System.out.println();
		}

		System.out.println("最小分配成本为：" + db.MINCOST);
		for (int t = 0; t < db.TEMP.length; t++) {
			System.out.println("第 " + (t + 1) + " 人分配任务 " + (db.TEMP[t] + 1));
		}
	}
}
