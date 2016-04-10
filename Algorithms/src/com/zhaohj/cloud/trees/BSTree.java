package com.zhaohj.cloud.trees;

public class BSTree {

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

		public String toString() {
			String leftkey = (left == null ? "" : String.valueOf(left.key));
			String rightkey = (right == null ? "" : String.valueOf(right.key));
			String parentkey = (parent == null ? "" : String.valueOf(parent.key));
			return parentkey + ": (" + leftkey + " , " + key + " , " + rightkey + ")";
		}
	}
	
	public BSTree() {
		this.root = null;
	}
	/**
	 * 插入值
	 * @param key
	 */
	public void Tree_Insert(int key) {
		
		TreeNode z = new TreeNode(key); // 待插入节点
		// 遍历指针
		TreeNode y = null; // 父
		TreeNode x =  this.root; // 子
		
		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.parent = y;
		if (y == null)
			this.root = z;
		else if (z.key < y.key)
			y.left = z;
		else 
			y.right = z;
	}
	
	/**
	 * 用一棵以v为根的子树来替换一棵以u为根的子树
	 * @param u
	 * @param v
	 */
	public void transplant(TreeNode u, TreeNode v) {
		if (u.parent == null) {
			this.root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != null) {
			v.parent = u.parent;
		}
	}
	
	/**
	 * 删除节点x， 取删除节点右子树的最小值替换被删除值
	 * @param z
	 */
	public void treeDelete(TreeNode z) {
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			TreeNode y = treeMinimum(z.right); // 查找右子树最小值
			// 如果被删除节点右子树的最小值就是该被删除节点的右孩子
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			// 那么，直接替换被删除节点和其右孩子即可
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}
	}
	
	/**
	 * 删除节点x， 取删除节点左子树的最大值替换被删除值
	 * @param z
	 */
	public void treeDelete2(TreeNode z) {
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			TreeNode y = treeMaximum(z.left);
			if (y.parent != z) {
				transplant(y, y.left);
				y.left = z.left;
				y.left.parent = y;
			}
			transplant(z, y);
			y.right = z.right;
			y.right.parent = y;
		}
	}
	
	/**
	 * PreOrder
	 * @param root
	 */
	public void preOrderTreeWalk(TreeNode root) {
		if (root != null) {
			System.out.print(root.key + ", ");
			preOrderTreeWalk(root.left);
			preOrderTreeWalk(root.right);
		}
	}
	
	/**
	 * midOrder
	 * @param root
	 */
	public void midOrderTreeWalk(TreeNode root) {
		if (root != null) {
			midOrderTreeWalk(root.left);
			System.out.print(root.key + ", ");
			midOrderTreeWalk(root.right);
		}
	}
	
	/**
	 * postOrder
	 * @param root
	 */
	public void postOrderTreeWalk(TreeNode root) {
		if (root != null) {
			postOrderTreeWalk(root.left);
			postOrderTreeWalk(root.right);
			System.out.print(root.key + ", ");
		}
	}
	
	/**
	 * 查找以x为根子树中的最小值
	 * @param x
	 * @return
	 */
	public TreeNode treeMinimum(TreeNode x) {
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	/**
	 * 查找以x为根子树中的最大值
	 * @param x
	 * @return
	 */
	public TreeNode treeMaximum(TreeNode x) {
		while(x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	/**
	 * 节点后继
	 * @param x
	 * @return
	 */
	public TreeNode treeSuccessor(TreeNode x) {
		if (x.right != null) {
			return treeMinimum(x.right);
		}
		TreeNode y = x.parent;
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 节点前驱
	 * @param x
	 * @return
	 */
	public TreeNode treePredecessor(TreeNode x) {
		if (x.left != null) {
			return treeMaximum(x.left);
		}
		TreeNode y = x.parent;
		while (y != null && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	/**
	 * 非递归查找
	 * @param x
	 * @param key
	 * @return
	 */
	public TreeNode iterativeTreeSearch(TreeNode x, int key) {
		
		while (x != null && x.key != key) {
			if (key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		
		return x;
	}
	
	/**
	 * 递归查找
	 * @param x
	 * @param key
	 * @return
	 */
	public TreeNode treeSearch(TreeNode x, int key) {
		if (x == null || x.key == key)
			return x;
		if (key < x.key)
			return treeSearch(x.left, key);
		else return treeSearch(x.right, key);
	}
	
	public static void main(String[] args) {
		int[] a = {15,6,18,3,8,7,17,20,2,4,13,9};
		BSTree bst = new BSTree();
		for (int i : a) {
			bst.Tree_Insert(i);
		}
		System.out.println("前序遍历：");
		bst.preOrderTreeWalk(bst.root);
		System.out.println();
		System.out.println("中序遍历：");
		bst.midOrderTreeWalk(bst.root);
		System.out.println();
		System.out.println("后序遍历：");
		bst.postOrderTreeWalk(bst.root);
		System.out.println();
		bst.treeDelete2(bst.treeSearch(bst.root, 8));
		System.out.println();
		bst.midOrderTreeWalk(bst.root);
		//System.out.println(bst.treePredecessor(bst.treeSearch(bst.root, 9)).key);
		//TreeNode root = bst.root;
	}

}














