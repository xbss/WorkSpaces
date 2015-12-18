package _01Dijkstra;

public class Dijkstra {
	// 对于没有连接的 点设置最大距离
	private static int MAX_WEIGHT = 10000; 
	// 各个点数据
	private static int[][] weight = {// 0代表点，其他数字代表边及边的权值
		{ 0, 6, 5, 7, MAX_WEIGHT },
		{ 2, 0, 4, 8, MAX_WEIGHT },
		{ MAX_WEIGHT, 5, 0, 6, 8 },
		{ 8, 2, 5, 0, 6 }, 
		{ MAX_WEIGHT, MAX_WEIGHT, 4, 8, 0 } 
		};
	// 针对数据 ：起始位置
	public static int START_POINT = 1;

	/**
	 * @title dijkstra 算法
	 * @param weight
	 * @param START_POINT
	 * @return
	 */
	public static void dijkstra() {
		int n = weight.length; // 顶点个数
		int[] dist = new int[n]; // 保存START_POINT到其他各点的最短路径
		String[] path = new String[n]; // 保存START_POINT到其他各点最短路径的字符串表示
		for (int i = 0; i < n; i++)
			path[i] = new String(START_POINT + "->" + i);
		int[] visited = new int[n]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出

		// 初始化，第一个顶点已经求出
		dist[START_POINT] = 0;
		visited[START_POINT] = 1;

		for (int count = 1; count < n; count++) { // 要加入n-1个顶点
			int k = -1; // 选出一个距离初始顶点START_POINT最近的未标记顶点
			int dmin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[START_POINT][i] < dmin) {
					dmin = weight[START_POINT][i];
					k = i;
				}
			}

			dist[k] = dmin;
			visited[k] = 1;

			for (int i = 0; i < n; i++) {
				if (visited[i] == 0
						&& weight[START_POINT][k] + weight[k][i] < weight[START_POINT][i]) {
					weight[START_POINT][i] = weight[START_POINT][k] + weight[k][i];
					path[i] = path[k] + "--" + i;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			//System.out.println("当前起点："+ START_POINT + " 到" + i + "的最短路径为：" + path[i]);
			//System.out.println("当前起点：" + START_POINT  + " 到" + i + "的最短距离为：" + dist[i]);
			System.out.printf("当前起点：" + START_POINT  + " 到" + i + "最短距离为：%4d" + "  最短路径为：%s\n" , dist[i], path[i] );
		}
		//
		/*for (int i = 0; i < dist.length; i++)
			System.out.println("当前起点：" + START_POINT  + " 到" + i + "的最短距离为：" + dist[i]);*/
	}
	
	/**
	 * @title 执行主函数
	 * @param args
	 */
	public static void main(String[] args) {
		dijkstra();
		
	}
}
