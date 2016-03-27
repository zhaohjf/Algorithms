package com.zhaohj.algorithms.array;

public class FenwickTree {
	
	int n; // 数组大小
	int C[];
	
	public FenwickTree() {
		this(10);
	}
	
	public FenwickTree(int Csize) {
		this.n = Csize;
		C = new int[Csize + 1];
	}

	// C[k]表示从a[k]开始往左连续求lowbit(k)个数的和
	public int lowbit(int k) {
		return k & -k;
	}
	
	/**
	 * k += k&-k;
	 * 在数组a中添加一个位置为k的元素：
	 * 在C数组中相当于在k位置，以及k加上k的lowbit位置上累加上这个元素的值
	 * @param k 相当于数组A中的元素的位置
	 * @param num 元素的值
	 */
	public void add(int k, int num) {
		while (k <= n) {
			C[k] += num;
			k += k&-k;
		}
	}
	
	/**
	 * 求1~k的区间和
	 * k -= k&-k; 求和是减去lowbit
	 * @param k
	 * @return
	 */
	public int sum(int k) {
		int sum = 0;
		while (k != 0) {
			sum += C[k];
			k -= k&-k;
		}
		return sum;
	}
	
	public void print() {
		int len = C.length;
		for (int i = 1; i < len; i++) {
			System.out.print(C[i] + ",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int len = 10;
		FenwickTree ft = new FenwickTree(len);
		for (int i = 1; i <= len; i++) {
			ft.add(i, i);
		}
		ft.print();
		System.out.println(ft.sum(10));
	}
	
}
