package com.zhaohj.algorithms.array;


/**
 * Problem Description
N�������ų�һ�ţ����������α��Ϊ1,2,3....N.ÿ�θ���2������a b(a <= b),lele��Ϊ�������ġ�С�ɸ�"�Ƶ綯��������a��ʼ������b���θ�ÿ������Ϳһ����ɫ������N���Ժ�lele�Ѿ������˵�I�������Ѿ�Ϳ��������ɫ�ˣ����ܰ������ÿ������Ϳ��������ɫ��
 
 

Input
ÿ������ʵ����һ��Ϊһ������N,(N <= 100000).��������N�У�ÿ�а���2������a b(1 <= a <= b <= N)��
��N = 0�����������
 
 

Output
ÿ������ʵ�����һ�У�����N����������I���������I�������ܹ���Ϳɫ�Ĵ�����
 
 

Sample Input
3 1 1 2 2 3 3 3 1 1 1 2 1 3 0
 
 

Sample Output
1 1 1 3 2 1
 * 
 * @author Winnie
 *
 */
public class ColorBall {

	static int n;
	static int[] c = new int[100001];
	
	public int lowbit(int k) {
		return k & -k;
	}
	
	public static void main(String[] args) {
		FenwickTree ft = new FenwickTree(100001);
		int a = 3;
		int b = 8;
		for (; b>=3; b--) {
			ft.add(3, 1);
			ft.add(b + 1, -1);
			for (int i = 1; i < 100; i++) {
				//System.out.print(ft.sum(i) + ", ");
				System.out.print(ft.C[i] + ", ");
			}
			System.out.println();
		}
		
		for (int i = 1; i < 100; i++) {
			System.out.print(ft.sum(i) + ", ");
			//System.out.print(ft.C[i] + ",");
		}
	}
}
