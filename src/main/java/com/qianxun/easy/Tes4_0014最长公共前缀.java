package com.qianxun.easy;


/**
 * 查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

输入: ["flower","flow","flight"]
输出: "fl"

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
 * @author qianxun
 *
 */
public class Tes4_0014最长公共前缀 {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 方法 01 ，两两比较，得出两者的最长公共前缀字符串，再拿这个字符串和第三个字符串比较，以此类推
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefixv1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
