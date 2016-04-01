package _2distributionProblem;

/**
 * 
 * @author XBSS
 * @title 分配问题 求解 利用分支限界法
 */
public class DB2 {
	public static int COST[][] = {
		{ 9, 2, 7, 8 },
		{ 6, 4, 3, 7 },
		{ 5, 8, 1, 8 }, 
		{ 7, 6, 9, 4 } }; // 消耗 x 任务，y 人员
	public static int TASK[] = new int[4]; // 任务 0 未分配 1 已分配
	public static int WORKER[] = new int[4]; // 工人 0 未有任务 1 已有任务
	public static int TEMP[] = new int[4]; // 存储分配方案 ，即是分配的路径
	public static int MINCOST = 100000; // 最小，每次循环都要做判断，与其比较cost
	public static TreeNode1 currentNode ;
	public static TreeNode1 rootNode = currentNode;

	public DB2() {
		for (int i = 0; i < TASK.length; i++) {
			TASK[i] = -1;
		}
		for (int i = 0; i < WORKER.length; i++) {
			WORKER[i] = -1;
		}
		currentNode = new TreeNode1(-1, -1);
		for (int k = 0; k < TASK.length; k++) {
			TEMP[k] = TASK[k];
		}
		currentNode.caculateCost(TEMP, COST);
		currentNode.isPath = true;
		rootNode = currentNode;
	}
	/**
	 * @title 分支限界法
	 */
	public void BranchAndBround(int currentTask, int cost) {
		for (int i = 0; i < WORKER.length; i++) {
			// 分配工作
			int index = 0;
			for (int j = 0; j < TASK.length; j++) {
				System.out.println("xiaoyu 0:" + TASK[j] );
				if (TASK[j] < 0) {
					
					TreeNode1 treeNode = new TreeNode1(i, j);
					//TASK[j] = i;
					for (int k = 0; k < TASK.length; k++) {
						TEMP[k] = TASK[k];
					}
					TEMP[j] = i;    // 将下一个人员进行分配
					treeNode.caculateCost(TEMP, COST);
					treeNode.index = index;
					index += 1;
					currentNode.child.add(treeNode);
					//TASK[j] = -1;
				}
			}
			
			// 得到最小消耗的任务作为取代当前节点
			int min = 100000;
			int task = 0; // 分配的任务
			index = 0;
			for (TreeNode1 node : currentNode.child) {
				if (node.cost < min) {
					min = node.cost;
					task = node.task;
					index = node.index;
					System.out.println("index:" + index);
				}
			}
			// 替换当前处理任务的节点
			TASK[task] = i;
			WORKER[i] = 1;
			currentNode.child.get(index).isPath = true;
			currentNode = currentNode.child.get(index);
		}
	}

	/**
	 * @title main method
	 * @param args
	 */
	public static void main(String[] args) {
		DB2 db = new DB2();

		/*db.BranchAndBround(0, 0); // 从任务0开始分配

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
		}*/
		
		
		/*TreeNode treeNode = new TreeNode(0, 0, 0);
		treeNode.caculateCost(TASK, COST);
		System.out.println(treeNode.cost);*/
		
		
		/*TreeNode treeNode = db.rootNode ;
		System.out.println(treeNode.cost);*/
		/*if (treeNode != null && treeNode.isPath == true) {
			System.out.println("第 " + (t + 1) + " 人分配任务 " + (db.TEMP[t] + 1));
		}*/
		
		db.BranchAndBround(0, 0);
		for (int j = 0; j < TASK.length; j++) {
			System.out.println(db.TASK[j]+1);
		}
		System.out.println("cost:" + db.currentNode.cost);
		
	}
}
