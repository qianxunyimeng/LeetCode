package com.qianxun.easy;

public class Test_0002数字反转 {
	
	public static void main(String[] args) {
		int dev = reverse(-123);
		System.out.println(dev);
		int dev2 = reverse(120);
		System.out.println(dev2);
		int dev3 = reverse(123);
		System.out.println(dev3);
	}
	
	public static int reverse(int x){
		
		int rev = 0;//反转后的数字
		
		while(x != 0){
			int pop = x % 10; //将最后一位数字弹出
			x = x / 10;//弹出尾数后的新数
			//MAX_VALUE = 0x7fffffff;  2<sup>31</sup>-1    2的31次方 -1 
		    //MIN_VALUE = 0x80000000;  -2<sup>31</sup>     -2的31次方
			// Integer.MAX_VALUE % 10 = 7    Integer.MIN_VALUE  % 10 = -8
            if (rev > Integer.MAX_VALUE/10 || (rev ==  Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev ==  Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;//注意，这里可能会发生数字越界，溢出，所以得提前判断
		}
		
		return rev;
	}
    
	 public int reverse2(int x) {
	        int rev = 0;
	        while(x != 0){
	            int pop = x % 10;
	            x = x / 10;
	            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
	                rev = 0;
	                break;
	            }else if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)){
	                rev = 0;
	                break;
	            }
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }
}
