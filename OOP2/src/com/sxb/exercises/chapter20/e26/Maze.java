package com.sxb.exercises.chapter20.e26;

public class Maze {

	// 储存棋盘矩阵的信息
	private int[][] matrix = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0 } };

	// 放入标志
	public void add(int r, int c) {
		matrix[r -1][c -1] = 2;
	}

	// 移除标志
	public void remove(int r, int c) {
		matrix[r - 1][c - 1] = 0;
	}
	// 查找路径
	public void searchPath(){
		
	}
	// 控制台打印当前的棋盘状态
	public void printInfo(){
		for (int[] iterable_element : matrix) {
			for (int i : iterable_element) {
				System.out.print("  " + i);
			}
			System.out.println();
		}
	}

	public Maze() {

	}

}
