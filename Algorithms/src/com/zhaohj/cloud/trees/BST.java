package com.zhaohj.cloud.trees;

import java.util.Stack;

public class BST {

	private TreeNode root;
	
	private class TreeNode {
		private int key;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;
		
		public TreeNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}
	
	public BST() {
		this.root = null;
	} 
	
	public void tree_insert(int key) {
		
		TreeNode z = new TreeNode(key); // ready for insert
		//Traversing pointer
		TreeNode y = null; // the parent of 'z' Node
		TreeNode x = this.root;
		
		// searching z's parent Node
		while (x != null) {
			y = x;
			if (z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		// insert z Node
		z.parent = y;
		if (y == null) {
			this.root = z;
		} else if (z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
	}
	
	public void linerPostOrderTreeWalk() {
		TreeNode pre = null;
		TreeNode curr = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			curr = stack.peek();
			if ((curr.left == null && curr.right == null) || 
					(pre != null && (pre == curr.left || pre == curr.right))) {
				System.out.print(curr.key + ", ");
				stack.pop();
				pre = curr;
			} else {
				if (curr.right != null) {
					stack.push(curr.right);
				}
				if (curr.left != null) {
					stack.push(curr.left);
				}
			}
		}
		
	}
	
	
	public void postOrderTreeWalk(TreeNode root) {
		if (root != null) {
			postOrderTreeWalk(root.left);
			postOrderTreeWalk(root.right);
			System.out.print(root.key + ", ");
		}
	}
	
	public void linerPreOrderTreeWalk() {
		TreeNode p = this.root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				System.out.print(p.key + ", ");
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.peek();
				stack.pop();
				p = p.right;
			}
		}
	}
	
	
	public void preOrderTreeWalk(TreeNode root) {
		if (root != null) {
			System.out.print(root.key + ", ");
			preOrderTreeWalk(root.left);
			preOrderTreeWalk(root.right);
		}
	}
	
	
	public void linerMidOrderTreeWalk() {
		
		TreeNode p = this.root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (p == null) {
			throw new NullPointerException("the BST tree is empty");
		}
		
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.peek();
				System.out.print(p.key + ", ");
				stack.pop();
				p = p.right;
			}
		}
		
	}
	
	
	public void midOrderTreeWalk(TreeNode root) {
		
		if (root != null) {
			midOrderTreeWalk(root.left);
			System.out.print(root.key + ", ");
			midOrderTreeWalk(root.right);
		}
		
	}
	
	public static void main(String[] args) {
		int[] A = {15,6,18,3,8,7,17,20,2,4,13,9};
		BST bst = new BST();
		for (int a : A) {
			bst.tree_insert(a);
		}
		bst.postOrderTreeWalk(bst.root);
		System.out.println();
		bst.linerPostOrderTreeWalk();
	}
}

















