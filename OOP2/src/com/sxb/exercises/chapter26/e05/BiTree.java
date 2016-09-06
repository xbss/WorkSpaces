package com.sxb.exercises.chapter26.e05;

import java.util.ArrayList;

public class BiTree<E> implements IBiTree<E> {

	BiTreeNode<E> root;
	int size = 0;
	public ArrayList<BiTreeNode<E>> nodes;
	public GenericStack<BiTreeNode<E>> nodeStack;

	/** Create a default BiTree */
	public BiTree() {
	}

	/** Create a BiTree with an spacial E */
	public BiTree(E e) {
		this.root = createNewNode(e);
	}

	/** Create a BiTree from an array of E */
	public BiTree(E[] es) {
		for (E e : es) {
			insertLeftNode(root, e);
		}
	}

	/** Return a instance of BiTreeNode */
	public BiTreeNode<E> createNewNode(E e) {
		try {
			return new BiTreeNode<E>(e);
		} catch (Exception e1) {
			System.out.println("Type of e is wrong!!!");
			System.exit(0);
			return null;
		}
	}

	/* 6.2 递归判断该树为完全二叉树 */
	/** Judge the BiTree is a completely binary tree */
	public boolean judgeBinary() {
		if (root == null) { // 根节点为空也是完全二叉树
			System.out.println("The BiTree is empty");
			return true;
		} else { // 遍历结点
			return judgeBinary(root);
		}
	}

	public boolean judgeBinary(BiTreeNode<E> root) {
		if (Math.abs(biTreeDepth(root.left) - biTreeDepth(root.right)) <= 1) {
			boolean left = judgeBinary(root.left);
			boolean right = judgeBinary(root.right);
			if (left == right && left == true) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

	/** Get the depth of BiTree */
	public int biTreeDepth(BiTreeNode<E> root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		} else {
			return biTreeDepth(root.left) > biTreeDepth(root.right) ? biTreeDepth(root.left)
					: biTreeDepth(root.right);
		}
	}

	/* 6.3 非递归中序遍历 */
	/** Inorder traversal from the root */
	public void inorder1() {
		inorder1(root);
	}

	public void inorder1(BiTreeNode<E> root) {
		nodeStack = new GenericStack<BiTreeNode<E>>();
		if (root != null) {
			BiTreeNode<E> current = root;
			while (!nodeStack.isEmpty() || current != null) {
				while (current != null) {// 把全部左孩子存进Stack
					nodeStack.push(current);
					current = current.left;
				}
				if (!nodeStack.isEmpty()) {// 左孩子出栈，打印结点信息，变为遍历右孩子
					current = nodeStack.pop();
					current.nodeInfo();
					current = current.right;
				}
			}
		} else
			System.out.println("BiTree is empty");
		/*
		 * if (root != null) { nodes.add(root); BiTreeNode<E> current = root;
		 * while (!nodes.isEmpty() && current != null) { if (current.left !=
		 * null) { current = current.left; nodes.add(current); } else if
		 * (current.right != null) { System.out.println(nodes.get(nodes.size() -
		 * 1).element); current = current.right; nodes.add(current); } else {
		 * BiTreeNode<E> temp = nodes.remove(nodes.size() - 1); temp.nodeInfo();
		 * current = nodes.get(nodes.size() - 1); if (current.left.equals(temp))
		 * { current.left = null; } else { current.right = temp; } } } } else
		 * System.out.println("BiTree is empty");
		 */
	}

	/* 7.1 统计叶节点的个数 */
	public int countLeaf() {
		int count = 0;
		countLeaf(root, count);
		return count;
	}

	public void countLeaf(BiTreeNode<E> root, int count) {
		if (root != null) { // 如果根节点为空，返回 0；不为空就统计结点数
			if (root.left == null && root.right == null) // 左右结点都没有为一个叶子结点
				count++;
			else if (root.left != null) // 左结点不为空遍历左结点
				countLeaf(root.left, count);
			else if (root.right != null)
				countLeaf(root.right, count);
		} else
			System.out.println("BiTree is empty");
	}

	/* 7.2 非递归后序遍历 */
	/** Postorder traversal from the root */
	public void postorder1() {
		postorder1(root);
	}

	public void postorder1(BiTreeNode<E> root) {
		nodeStack = new GenericStack<BiTreeNode<E>>();
		if (root != null) {
			BiTreeNode<E> current = root;
			while (!nodeStack.isEmpty() || current != null) {
				while (current != null) { // 把全部左孩子存入栈中
					nodeStack.push(current);
					current = current.left;
				}
				if (!nodeStack.isEmpty()) { // 结点出栈，如果右孩子为空，打印结点信息,
											// 如果右孩子不为空，遍历右孩子。
					current = nodeStack.pop();
					if (current.right != null) {
						current = current.right;
					} else
						current.nodeInfo();
				}
			}
		} else
			System.out.println("BiTree is empty");
		/*
		 * if (root != null) { nodes.add(root); BiTreeNode<E> current = root;
		 * while(!nodes.isEmpty() && current != null){ while(current !=null){ }
		 * 
		 * if (current.left != null) { current = current.left;
		 * nodes.add(current); } else if(current.right != null){ current =
		 * current.right; nodes.add(current); } else { BiTreeNode<E> temp =
		 * nodes.remove(nodes.size() - 1); temp.nodeInfo(); current =
		 * nodes.get(nodes.size() - 1); if (current.left.equals(temp)) {
		 * current.left = null; } else { current.right = temp; } } } } else
		 * System.out.println("BiTree is empty");
		 */
	}

	/** Return true if the element is in the tree */
	public boolean search(E e) {
		return search(root, e);
	}

	public boolean search(BiTreeNode<E> root, E e) {
		if (root == null || e == null) {
			return false;
		} else if (root.equals(e)) {
			return true;
		} else if (root.left != null) {
			return search(root.left, e);
		} else if (root.right != null) {
			return search(root.right, e);
		} else
			return false;
	}

	/**
	 * Insert element o into the tree to be the leftChild Return true if the
	 * element is inserted successfully
	 */
	public boolean insertLeftNode(BiTreeNode<E> parent, E e) {
		if (parent == null && root == null) {
			this.root = createNewNode(e);
			size++;
			return true;
		} else if (parent == null && root != null) {
			return false;
		} else if (e == null) {
			return false;
		} else {
			parent.left = createNewNode(e);
			size++;
			return true;
		}
	}

	/**
	 * Insert element o into the tree to be the rightChild Return true if the
	 * element is inserted successfully
	 */
	public boolean insertRightNode(BiTreeNode<E> parent, E e) {
		if (parent == null && root == null) {
			this.root = createNewNode(e);
			size++;
			return true;
		} else if (parent == null && root != null) {
			return false;
		} else if (e == null) {
			return false;
		} else {
			parent.right = createNewNode(e);
			size++;
			return true;
		}
	}

	/** Reuturn the parent of Node child */
	public BiTreeNode<E> parent(BiTreeNode<E> child) {
		return child.parent;
	}

	/** Reuturn the leftChild of Node parent */
	public BiTreeNode<E> leftChild(BiTreeNode<E> parent) {
		return parent.left;
	}

	/** Reuturn the rightChild of Node parent */
	public BiTreeNode<E> rightChild(BiTreeNode<E> parent) {
		return parent.right;
	}

	/**
	 * Delete the specified element from the tree Return true if the element is
	 * deleted successfully
	 */
	public boolean delete(E e) {
		if (e == null) {
			return false;
		} else {
			return delete(root, e);
		}
	}

	public boolean delete(BiTreeNode<E> root, E e) {
		if (root == null || e == null) {
			return false;
		} else if (root.equals(e)) {
			System.out.println("Delete: " + root.element + " Left: "
					+ root.left + " Right: " + root.right);
			root = null;
			return true;
		} else if (root.left != null) {
			return delete(root.left, e);
		} else if (root.right != null) {
			return delete(root.right, e);
		} else {
			return false;
		}
	}

	/** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	public void inorder(BiTreeNode<E> root) {
		if (root != null) {
			if (root.left != null)
				inorder(root.left);
			System.out.println(root.element);
			if (root.right != null)
				inorder(root.right);
		}
	}

	/** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	public void postorder(BiTreeNode<E> root) {
		if (root != null) {
			if (root.left != null)
				inorder(root.left);
			if (root.right != null)
				inorder(root.right);
			System.out.println(root.element);
		}
	}

	/** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	public void preorder(BiTreeNode<E> root) {
		if (root != null) {
			System.out.println(root.element);
			if (root.left != null)
				inorder(root.left);
			if (root.right != null)
				inorder(root.right);
		}
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Return true if the tree is empty */
	public boolean isEmpty() {
		return size == 0;
	}

}
