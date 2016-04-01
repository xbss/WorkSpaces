package _1travelingSalesmanProblem;

/**
 * 
 * @author XBSS
 *
 */
public class TSPGreedy {
	// 规模
	public static int MAX_RANGE = 100;               // 矩阵的大小范围 100 X 100
	public static int MAX_V = 2;                           // 矩阵点 横纵坐标
	public static int MAX_H = 7;                           // 矩阵点的个数
	
	public static int[][] GRAPH;                             // 图
	 
	public static int MINDISTENCE[];                    // MINDISTENCE 最短距离
	
	public static boolean VISITED[];                     // VISITED 处理过的点，已访问过的点

	// 构造方法
	public TSPGreedy(){
		initData();
		getRandomIntArrayFor_2();
	}
	// 初始化数据
	public static void initData() {
		// 初始化操作图数据
		GRAPH = new int[MAX_H][MAX_V];
		for (int[] is : GRAPH) {
			for (int i : is) {
				is[i] = -1;
			}
		}
		// 初始化disk最短距离
		MINDISTENCE = new int[MAX_H];
		for (int is : MINDISTENCE) {
			is = -1;
		}
		// VISITED
		VISITED = new boolean[MAX_H];
		for (boolean i : VISITED) {
			i = false;
		}
	}

	// 产生随机二维数组用于表示图
	public static int[][] getRandomIntArrayFor_2() {
		// 数组初始化
		for (int i = 0; i < GRAPH.length; i++) {
			int randomNumX = (int) (Math.random() * MAX_RANGE);
			int randomNumY = (int) (Math.random() * MAX_RANGE);
			for (int j = 0; j < GRAPH.length; j++) {
				// 判断产生的 100 X 100 的点阵中没有重复， 保证生成的点无重复
				if (GRAPH[j][0] == randomNumX && GRAPH[j][1] == randomNumY) {
					randomNumX = (int) (Math.random() * MAX_RANGE);
					randomNumY = (int) (Math.random() * MAX_RANGE);
					// 如果重新产生了随机数需要重新判断一遍
					j = 0;
				}
			}
			// 验证完毕 计入点 x，y
			GRAPH[i][0] = randomNumX;
			GRAPH[i][1] = randomNumY;
		}

		return GRAPH;
	}

	// 求两点之间的距离（权值：三角形法则）
	public static int getDist(int x1, int y1, int x2, int y2) {
		int MINDISTENCE = 0;
		int xMINDISTENCE = Math.abs(x1 - x2);
		int yMINDISTENCE = Math.abs(y1 - y2);
		MINDISTENCE = (int) Math.sqrt(xMINDISTENCE * xMINDISTENCE + yMINDISTENCE * yMINDISTENCE);
		return MINDISTENCE;
	}

	// 贪心算法 求最小路径，每次都取距离当前节点最短的路径
	public static int Greedy() {
		int current = 0;     // 当前处理的点
		int flag = MAX_H -1; // 标记未处理的点的个数
		int index = 0;       // 距离当前处理的点最近的点
		int sum = 0;         // 统计权值
		
		while(flag > 0){
			// 如果是访问过的就不在访问
			if (VISITED[current]) {
				continue;
			}
			// 重新计算index 与没有被用过的点的最小距离，
			for (int j = 0; j < MINDISTENCE.length; j++) {
				MINDISTENCE[j]= 1000000;
			}
			// 找到最小距离 如果比原来小就执行替换
			int mincost = MINDISTENCE[0];
			for (int j = 0; j < GRAPH.length;  j++) {
				if (!VISITED[j] && current != j) {
					MINDISTENCE[j] = getDist(GRAPH[current][0], GRAPH[current][1],
							GRAPH[j][0], GRAPH[j][1]);
					if (!VISITED[j] && MINDISTENCE[j] < mincost) {
						mincost = MINDISTENCE[j];
						index = j;
					}
				}
			}
			flag -= 1;  //减少一个处理的点
			// 循环完成找到最近的点
			VISITED[current] = true; // 当前处理的点设置为已访问
			System.out.println("第" + current + "点连接第" + index + "个点，距离为：" + MINDISTENCE[index]);
			current = index;
			System.out.print("\nVISIT:" );
			for (boolean b : VISITED) {
				System.out.print(" " + b);
			}
			System.out.print("\nDIS:" );
			for (int d : MINDISTENCE) {
				System.out.print(" " + d);
			}
			System.out.println();
			sum += MINDISTENCE[index];
		}
		return sum;
	}

	public static void main(String[] args) {

		TSPGreedy TSP = new TSPGreedy();
		for (int[] is : TSP.GRAPH) {
			System.out.println("矩阵：" + is[0] + " " + is[1]);
		}
		System.out.println("最小权值：" + TSP.Greedy());
	}
}
