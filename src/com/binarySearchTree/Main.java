package com.binarySearchTree;

public class Main {
	public static void main(String[] args) {
		binarySearchTree tree = new binarySearchTree();
		int[] inputNodes = { 40, 20, 60, 10, 30, 50, 70 };

		for (int i : inputNodes)
			tree.insert(i);

		/*
		 * Show the inorder traversal of binary tree to ensure we have created a binary
		 * search tree
		 */
		tree.inorder();

		int sum = 130;

		tree.findPair(sum);
	}
}
