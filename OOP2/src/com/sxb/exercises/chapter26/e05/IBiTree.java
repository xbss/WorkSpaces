package com.sxb.exercises.chapter26.e05;

public interface IBiTree<E> {
	  /** Return true if the element is in the tree */
	  public boolean search(E e);

	  /** Insert element o into the tree to be the leftChild
	   * Return true if the element is inserted successfully */
	  public boolean insertLeftNode(BiTreeNode<E> parent,E e);

	 /** Insert element o into the tree to be the rightChild
	   * Return true if the element is inserted successfully */
	  public boolean insertRightNode(BiTreeNode<E> parent,E e);
	 
	/** Reuturn the parent of Node child*/
	   BiTreeNode<E> parent(BiTreeNode<E> child);
	 
	/** Reuturn the leftChild of Node parent*/
	   BiTreeNode<E> leftChild(BiTreeNode<E> parent);

	/** Reuturn the rightChild of Node parent*/
	   BiTreeNode<E> rightChild(BiTreeNode<E> parent);
	 
	  /** Delete the specified element from the tree
	   * Return true if the element is deleted successfully */
	  public boolean delete(E e);

	  /** Inorder traversal from the root*/
	  public void inorder();

	  /** Postorder traversal from the root */
	  public void postorder();

	  /** Preorder traversal from the root */
	  public void preorder();

	  /** Get the number of nodes in the tree */
	  public int getSize();

	  /** Return true if the tree is empty */
	  public boolean isEmpty();
	  
	}
