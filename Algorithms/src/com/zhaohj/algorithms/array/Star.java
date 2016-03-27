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
		 // 首先这里利用了树状数组的数据结构，树状数组适用于解决数组求和问题。
		 // 所以我们要明白这道题是要以数组求各的方式来解决的
		 // 由于树状数组只能从1开始，所以数组x应当为{2,6,8,4,5}
		 /**
		  * 1,求sum值，即求在当前位置x[i]前有几颗星星，每有一颗level就加1，数组a中的a[level]就会加1，代表这个level有几颗星星
		  * 2,求完sum值后，再把当前这个星星保存在树状数组中，即在x[i]的位置上加1。
		  * 3,每个x[i]的值  = 在树状数组C中的插入位置，插入的值为1；见modify方法。
		  */
		 // 之所以可以这么做的原因是y轴已经排好序了，y轴相同时按x轴排序。后面新加入到
		 // 树状数组中的星星不会对前面的星星造成影响；比如依次添加了1，5，7这三颗星星
		 // 再添加3号星星，因为3号星星的y轴高于1，5，7这三颗星星，所以只要是x轴上所有
		 // 位置位置在3前的星星就是3号星星的level。
		 for(int i=1;i<=n;i++) {
			 a[sum(++x[i-1])]++;//防止0的出现,因为树状数组是从1开始的
		     modify(x[i-1]);
		 }
		 
		 for(int i=0;i<n;i++){
			 System.out.print(a[i] + ", ");
		 }
	}
	
}
