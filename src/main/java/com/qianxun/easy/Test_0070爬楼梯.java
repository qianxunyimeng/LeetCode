package com.qianxun.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 * @author 46096
 *
 */
public class Test_0070爬楼梯 {

	public static void main(String[] args) {
		int r = climbStairs(10);
		System.out.println(r);
	}
	/**
	 * 分析 ,结果为r
	 * n = 1 , r = 1
	 * n = 2 , r = 2
	 * n = 3,  r = 3
	 * n = 4   r = 5
	 * n = 5   r = 8
	 * f(n) = f(n-1) + f(n-2)
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		if(n<=2){
            return n;
        }
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}
