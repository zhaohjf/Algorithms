package com.zhaohj.algorithms.array;

public class FenwickTree {
	
	int n; // �����С
	int C[];
	
	public FenwickTree() {
		this(10);
	}
	
	public FenwickTree(int Csize) {
		this.n = Csize;
		C = new int[Csize + 1];
	}

	// C[k]��ʾ��a[k]��ʼ����������lowbit(k)�����ĺ�
	public int lowbit(int k) {
		return k & -k;
	}
	
	/**
	 * k += k&-k;
	 * ������a�����һ��λ��Ϊk��Ԫ�أ�
	 * ��C�������൱����kλ�ã��Լ�k����k��lowbitλ�����ۼ������Ԫ�ص�ֵ
	 * @param k �൱������A�е�Ԫ�ص�λ��
	 * @param num Ԫ�ص�ֵ
	 */
	public void add(int k, int num) {
		while (k <= n) {
			C[k] += num;
			k += k&-k;
		}
	}
	
	/**
	 * ��1~k�������
	 * k -= k&-k; ����Ǽ�ȥlowbit
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
