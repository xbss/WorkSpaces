package com.sxb.exercises.chapter26.e05;

public class BiTreeNode<E> {
	E element;
	BiTreeNode<E> parent;
	BiTreeNode<E> left;
	BiTreeNode<E> right;
	public BiTreeNode(E e) {
		element = e;
	}
	
	// 打印结点元素
	public void nodeInfo(){
		System.out.println("NODE INFO----->>>" + this.element);
	}
}
