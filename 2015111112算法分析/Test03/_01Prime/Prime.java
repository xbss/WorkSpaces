package _01Prime;

public class Prime {
	// 规模
	public static int maxNumber = 100;
	public static int maxV = 2;
	public static int maxH = 7;
	// 图
	public static int[][] graph;
	// dist 最短距离
	public static int dist[];
	// visit 处理过的点，已访问过的点
	public static boolean visit[];

	// 初始化数据
	public static void initData() {
		// 初始化操作图数据
		graph = new int[maxH][maxV];
		for (int[] is : graph) {
			for (int i : is) {
				is[i] = -1;
			}
		}
		// 初始化disk最短距离
		dist = new int[maxH];
		for (int is : dist) {
			is = -1;
		}
		// visit
		visit = new boolean[maxH];
		for (boolean i : visit) {
			i = false;
		}
	}

	// 产生随机二维数组用于表示图
	public static int[][] getRandomIntArrayFor_2() {
		initData();
		// 数组初始化
		for (int i = 0; i < graph.length; i++) {
			int randomNumX = (int) (Math.random() * maxNumber);
			int randomNumY = (int) (Math.random() * maxNumber);
			for (int j = 0; j < graph.length; j++) {
				// 判断产生的 100 * 100 的点阵中没有重复
				if (graph[j][0] == randomNumX && graph[j][1] == randomNumY) {
					randomNumX = (int) (Math.random() * maxNumber);
					randomNumY = (int) (Math.random() * maxNumber);
					// 如果重新产生了随机数需要重新判断一遍
					j = 0;
				}
			}
			graph[i][0] = randomNumX;
			graph[i][1] = randomNumY;
		}

		return graph;
	}

	// 求两点之间的距离（权值：三角形法则）
	public static int getDist(int x1, int y1, int x2, int y2) {
		int dist = 0;
		int xdist = Math.abs(x1 - x2);
		int ydist = Math.abs(y1 - y2);
		dist = (int) Math.sqrt(xdist * xdist + ydist * ydist);
		return dist;
	}

	// prime 算法 求最小距离
	public static int prime() {
		int cur = 0;
		int index = 0;
		int sum = 0; // 统计权值
		// memset(visit, false, sizeof(visit));
		visit[cur] = true;
		// 计算第一个点与没有用过的点的距离
		for (int i = 0; i < visit.length; i++) {
			if (visit[i] == false) {
				dist[i] = getDist(graph[cur][0], graph[cur][1], graph[i][0],
						graph[i][1]);
			}
		}
		for (int i = 1; i < graph.length; i++) {
			int mincost = 100000000;
			for (int j = 0; j < graph.length; j++) {
				if (!visit[j] && dist[j] < mincost) {
					mincost = dist[j];
					index = j;
				}
			}
			// 循环完成找到最近的点
			visit[index] = true;
			System.out.println("第" + i + "点连接第" + index + "个点");
			sum += mincost;
			// 重新计算index 与没有被用过的点的最小距离，如果比原来小就执行替换
			for (int j = 0; j < graph.length; j++) {
				if (!visit[j]
						&& dist[j] > getDist(graph[index][0], graph[index][1],
								graph[j][0], graph[j][1])) {
					dist[j] = getDist(graph[index][0], graph[index][1],
							graph[j][0], graph[j][1]);
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {

		Prime prime = new Prime();
		for (int[] is : prime.getRandomIntArrayFor_2()) {
			System.out.println("矩阵："+is[0] + " " + is[1]);
		}
		System.out.println("最小权值："+prime.prime());
	}
}
