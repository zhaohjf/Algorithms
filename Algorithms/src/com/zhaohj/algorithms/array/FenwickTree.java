package com.zhaohj.algorithms.array;

public class FenwickTree {

	public static int lowbit(int k) {
		return k & -k;
	}
	
	
}
