package com.zhaohj.cloud.trees;

public class BinarySearchTree {
	
	public Node root;
	
	public BinarySearchTree() {
		super();
	}
	
	/**
	 * �ݹ鷽ʽ���룬��ƽ��
	 * @param root
	 * @param value
	 */
	public void insert(Node root, int value) {
		Node p = new Node(value);
		if (this.root == null) {
			this.root = p;
			return;
		}
		if (root.left == null && root.value > value) {
			p.parent = root;
			root.left = p;
			return;
		}
		if (root.right == null && root.value < value) {
			p.parent = root;
			root.right = p;
			return;
		}
		if (root.value > value) {
			insert(root.left, value);
		} else if (root.value < value) {
			insert(root.right, value);
		} else {
			return;
		}
	}
	
	/**
	 * �ǵݹ飬��ƽ��
	 * @param root
	 * @param value
	 */
	public void linerInsert(Node root, int value) {
		Node p = new Node(value);
		if (this.root == null) {
			this.root = p;
			return;
		}
		while (root.left != p && root.right != p) {
			if (value < root.value) {
				if (root.left != null) {
					root = root.left;
				} else {
					root.left = p;
					p.parent = root;
				}
			} else if (value > root.value) {
				if (root.right != null) {
					root = root.right;
				} else {
					root.right = p;
					p.parent = root;
				}
			}
		}
	}
	
	private Node search(Node root, int value) {
		while (root != null) {
			if (root.value == value) {
				return root;
			} else if (root.value > value) {
				root = root.left;
			} else if (root.value < value) {
				root = root.right;
			}
		}
		return null;
	}
	
	public int searchValue(Node root, int value) {
		return search(root, value) == null ? null : search(root, value).value;
	}
	
	public Node searchPredecessor(int value) {
		Node p = search(this.root, value);
		if (p == null) {
			throw new NullPointerException("���ҵĽڵ㲻����");
		}
//		if (p.left == null) {
//			return null;
//		}
		while (p.left != null) {
			p = p.left;
		}
		return p;
	}
	
	/**
	 * p���������������������ա�
	 * �ҵ�p�ĺ��y����Ϊyһ��û�������������Կ���ɾ��y������y�ĸ��׽ڵ��Ϊy���������ĸ��׽ڵ㣬����y��ֵ����p��ֵ��
	 * ���߷��������ҵ�p��ǰ��x��xһ��û�������������Կ���ɾ��x������x�ĸ��׽ڵ��Ϊy���������ĸ��׽ڵ�
	 * @param a
	 */
	
	public void deletNode(Node root, int value) {
		Node target = search(root, value);
		Node parent = target.parent;
		if (target.left == null && target.right == null) {
			if (parent.left == target) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (target.left == null || target.right == null) {
			if (parent.left == target) {
				if (target.left != null) {
					parent.left = target.left;
				} else {
					parent.left = target.right;
				}
			} else {
				if (target.left != null) {
					parent.right = target.left;
				} else {
					parent.right = target.right;
				}
			}
		} else {
			
		}
	}
	
	
	
	public void create(int[] a) {
		for (int i: a) {
			linerInsert(this.root, i);
		}
	}
	
	public void preOrderTreeWalk(Node root) {
		
	}
	
	public void midOrderTreeWalk(Node root) {
		if (root != null) {
			midOrderTreeWalk(root.left);
			System.out.print(root.value + ",");
			midOrderTreeWalk(root.right);
		}
	}
	
	public void postOrderTreeWalk(Node root) {
		
	}
	
	private class Node {
		public int value;
		private Node left;
		private Node right;
		private Node parent;
		
		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {15,6,18,3,7,17,20,2,4,13,9};
		BinarySearchTree bst = new BinarySearchTree();
		bst.create(a);
		bst.midOrderTreeWalk(bst.root);
		System.out.println();
		int [] b = {2,3,4,6,7,9,13,15,17,18,20};
		for (int i : b) {
			System.out.print(bst.searchPredecessor(i) == null ? null + ", " : bst.searchPredecessor(i).value + ",");
		}
		
//		Node findNode = bst.search(bst.root, 20);
//		System.out.println(findNode == null?"�]���ҵ�":findNode.value);
	}
	
}














