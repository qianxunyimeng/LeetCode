package com.qianxun.easy;

public class Test_0069X的平方根 {

	public static void main(String[] args) {
		System.out.println("9 的平方根 = " + mySqrt(9) );
		//System.out.println("12的平方根 = " + mySqrt(12) );
	}
	
	
	/**
	 * 使用 二分 查找法，
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		int low = 1;
		int high = x - 1;
		int ans = -1;
		
		while(low <= high) {
			int mid = low + ((high - low) >> 1);
		    if( mid * mid <= x) {
		    	ans = mid;
		    	low = mid + 1;
		    }else {
		    	high = mid - 1;
		    }
		}
		return ans;
    }

}
