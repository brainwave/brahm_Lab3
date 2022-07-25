package com.binarySearchTree;

import java.util.HashSet;
import java.util.Stack;

public class binarySearchTree {
	Node<Integer> root;

	// insertion without recursion (loop approach)
	public void insert(int key) {
		Node<Integer> node = new Node<Integer>(key);

		if (root == null) {
			root = node;
			return;
		}

		Node<Integer> prev = null;
		Node<Integer> temp = root;

		while (temp != null) {
			if (temp.val > key) {
				prev = temp;
				temp = temp.left;
			} else if (temp.val < key) {
				prev = temp;
				temp = temp.right;
			}
		}

		if (prev.val > key)
			prev.left = node;
		else
			prev.right = node;
	}

	public void inorder() {
		Node<Integer> temp = root;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>();
		while (temp != null || !stack.isEmpty()) {
			if (temp != null) {
				stack.add(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.val + " ");
				temp = temp.right;
			}
		}
		System.out.println();
	}

	public static boolean findPairUtil(Node<Integer> root, int sum, HashSet<Integer> set) {

		if (root == null)
			return false;

		if (set.contains(sum - root.val)) {
			System.out.println("Pair is found (" + (sum - root.val) + ", " + root.val + ")");
			return true;
		}

		else
			set.add(root.val);

		return findPairUtil(root.right, sum, set);

	}

	void findPair(int sum) {

		HashSet<Integer> set = new HashSet<Integer>();

		if (!findPairUtil(this.root, sum, set))
			System.out.println("Pairs do not exist\n");
	}

}
