package com.qianxun.easy;

/**
 * 
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 输入：digits = [1,2,3] 
 * 输出：[1,2,4] 
 * 解释：输入数组表示数字 123。
 * 
 * 
 * 输入：digits = [4,3,2,1] 
 * 输出：[4,3,2,2] 
 * 解释：输入数组表示数字 4321。
 * 
 * 输入：digits = [0] 
 * 输出：[1]
 * 
 * 提示：
 * 
 * 1 <= digits.length <= 100 
 * 0 <= digits[i] <= 9
 * 
 * @author 46096
 *
 */
public class Test_0066加1 {
	public static void main(String[] args) {

		int[] digits = new int[] {8,9};
		int[] plusOne = plusOne(digits);
		for (int i : plusOne) {
			System.out.println(i);
		}
	}
	
	/**
	 * 根据题意加一，没错就是加一这很重要，因为它是只加一的所以有可能的情况就只有两种：

              除 9 之外的数字加一；
              数字 9。
              加一得十进一位个位数为 0 加法运算如不出现进位就运算结束了且进位只会是一。

             所以只需要判断有没有进位并模拟出它的进位方式，如十位数加 1 个位数置为 0，如此循环直到判断没有再进位就退出循环返回结果。

             然后还有一些特殊情况就是当出现 99、999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。
	 * @param digits
	 * @return
	 */
	public static int[] plusOne(int[] digits) {
         int len = digits.length - 1;
         for(int i = len; i >= 0; i--) {
        	//这里，每一位 都要加一: 非最后一位 +1，加的是后一位的进位，
        	 //例如89 + 1，第一次循环 个位 + 1 ==> 9 + 1 = 10发生进位，进入第二次循环
        	 // 十位加一 ==> 8 + 1= 9，这里的1就是上一次循环发生的进位情况
        	 digits[i]++;
        	 digits[i] = digits[i]%10;
        	 if(digits[i] != 0) {//最后一位 +1 取模 != 0 说明没有发生进位，直接返回即可
        		 return digits;
        	 }
         }
         
         //如果走到这一步，说明最高位 也发生了进位情况
         digits = new int[digits.length+1];
         digits[0] = 1;
         return digits;
    }
}
