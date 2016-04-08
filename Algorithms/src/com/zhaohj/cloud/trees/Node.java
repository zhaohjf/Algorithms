package com.zhaohj.cloud.trees;

public class Node {

	private int value;
	private Node left;
	private Node right;
	private Node parent;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public int getValue() {
		return value;
	}

	public String toString() {
		String leftkey = (left == null ? "" : String.valueOf(left.value));
		String rightkey = (right == null ? "" : String.valueOf(right.value));
		String parentkey = (parent == null ? "" : String.valueOf(parent.value));
		return parentkey + ": (" + leftkey + " , " + value + " , " + rightkey + ")";
	}
}
