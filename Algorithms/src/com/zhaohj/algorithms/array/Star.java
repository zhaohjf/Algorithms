package com.zhaohj.algorithms.array;

/**
Stars 
Time Limit: 1000MS      Memory Limit: 65536K 
Total Submissions: 17306        Accepted: 7519 
Description 
Astronomers often examine star maps where stars are represented by points on a plane and each star has Cartesian coordinates. Let the level of a star be an amount of the stars that are not higher and not to the right of the given star. Astronomers want to know the distribution of the levels of the stars.  
For example, look at the map shown on the figure above. Level of the star number 5 is equal to 3 (it's formed by three stars with a numbers 1, 2 and 4). And the levels of the stars numbered by 2 and 4 are 1. At this map there are only one star of the level 0, two stars of the level 1, one star of the level 2, and one star of the level 3.  
You are to write a program that will count the amounts of the stars of each level on a given map. 
Input 
The first line of the input file contains a number of stars N (1<=N<=15000). The following N lines describe coordinates of stars (two integers X and Y per line separated by a space, 0<=X,Y<=32000). There can be only one star at one point of the plane. Stars are listed in ascending order of Y coordinate. Stars with equal Y coordinates are listed in ascending order of X coordinate.  
Output 
The output should contain N lines, one number per line. The first line contains amount of stars of the level 0, the second does amount of stars of the level 1 and so on, the last line contains amount of stars of the level N-1. 
Sample Input 
5 
1 1 
5 1 
7 1 
3 3 
5 5 
Sample Output 
1 
2 
1 
1 
0 
*/
public class Star {
	
	static int c[] = new int[32001];  
	static int a[] = new int[15010]; 

	public static int lowbit(int x){  
	    return x&(-x);  
	}
	
	public static void modify(int i){  
	    while(i<=32001){
	        c[i]++;  
	        i+=lowbit(i);  
	    }
	}
	
	public static int sum(int i){  
	    int s=0;  
	    while(i>0){  
	        s+=c[i];  
	        i-=lowbit(i);  
	    }  
	    return s;  
	}
	
	public static void main(String[] args) {
		 int[] x = new int[]{1,5,7,3,5};
		 int n = 5;
		 // ����������������״��������ݽṹ����״���������ڽ������������⡣
		 // ��������Ҫ�����������Ҫ����������ķ�ʽ�������
		 // ������״����ֻ�ܴ�1��ʼ����������xӦ��Ϊ{2,6,8,4,5}
		 /**
		  * 1,��sumֵ�������ڵ�ǰλ��x[i]ǰ�м������ǣ�ÿ��һ��level�ͼ�1������a�е�a[level]�ͻ��1���������level�м�������
		  * 2,����sumֵ���ٰѵ�ǰ������Ǳ�������״�����У�����x[i]��λ���ϼ�1��
		  * 3,ÿ��x[i]��ֵ  = ����״����C�еĲ���λ�ã������ֵΪ1����modify������
		  */
		 // ֮���Կ�����ô����ԭ����y���Ѿ��ź����ˣ�y����ͬʱ��x�����򡣺����¼��뵽
		 // ��״�����е����ǲ����ǰ����������Ӱ�죻�������������1��5��7����������
		 // �����3�����ǣ���Ϊ3�����ǵ�y�����1��5��7���������ǣ�����ֻҪ��x��������
		 // λ��λ����3ǰ�����Ǿ���3�����ǵ�level��
		 for(int i=1;i<=n;i++) {
			 a[sum(++x[i-1])]++;//��ֹ0�ĳ���,��Ϊ��״�����Ǵ�1��ʼ��
		     modify(x[i-1]);
		 }
		 
		 for(int i=0;i<n;i++){
			 System.out.print(a[i] + ", ");
		 }
	}
	
}
