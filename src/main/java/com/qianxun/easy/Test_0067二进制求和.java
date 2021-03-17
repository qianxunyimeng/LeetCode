package com.qianxun.easy;

public class Test_0067二进制求和 {

	public static void main(String[] args) {
		String binary = addBinary("11","1");
		System.out.println(binary);
	}
	
	
	
	/**
	 * 
	 * 这里用到了 int 和 char 互转的内容
	 * 
	 * Int => char
	 * int  n = 1;
     * char ch = （char）(n + '0');
	 * 
	 * char => int
	 * char ch = '9';
     * int n = int(ch) - int('0');  也可以 写成 int n  = ch - '0';
                此处ch也是‘0’至‘9’的数字字符
	 * 
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
        	// 倒序遍历，从低位开始，逐位相加
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            //上面两行  就是 让 进位 和 每一位 数字相加
            
            //(char) (carry % 2 + '0') 得出的是 余位
            ans.append((char) (carry % 2 + '0'));
            // carry /= 2 carry 就是 每一次相加得出的进位 逢2进1
            carry /= 2;
        }

        if (carry > 0) {
        	// 出现 最高位 进位的情况
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
