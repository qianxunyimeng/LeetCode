package com.qianxun.easy;

/**
 *
 *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 121 true
 * -121 false  -121 不等于 121-
 * 10 false  10 不等于 01
 *
 * 注意:  负数 和 个位数为  0  的整数都不是回文数字
 *
 * @author 千寻
 * @version 1.0
 * @create 2020-12-29 21:21
 */
public class Test_0009回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));

        System.out.println(isPalindrome2(1221));

        System.out.println(isPalindrome2(1221));
    }


    //方法一  字符串方式处理(面试不建议)
    public static boolean isPalindrome(int x) {
        String reverseNumber = new  StringBuilder(String.valueOf(x)).reverse().toString();
        return reverseNumber.equals(String.valueOf(x));
    }

    //方法2  数值处理
    public static boolean isPalindrome2(int x) {
        int temp = x;
        int rev=0,max=0x7fffffff,min=0;
        if(x < 0) {
            return false;
        }
        if(x % 10 == 0 && x != 0){
            return false;
        }
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //判断是否超出范围 防止rev = rev * 10 + pop溢出
            //此处 和 数字反转 类似
            if (rev > max/10 || (rev == max / 10 && pop > 7))  return false;
            rev = rev * 10 + pop;
        }
        return rev == temp ? true:false;
    }


    //方法3  反转后一般数字  例如 12355231  将5231反转为1235和原数前半部分相等，此方法可以防止反转后数值大于int的最大范围
    public static boolean isPalindrome3(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到  x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber /  10;
    }

}
