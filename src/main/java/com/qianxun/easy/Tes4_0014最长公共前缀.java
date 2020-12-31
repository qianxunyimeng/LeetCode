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
		String[] str = new String[]{"leetcode","leetde","leets","leett",};
		long startTime=System.currentTimeMillis();   //获取开始时间
		//String prex = longestCommonPrefixv1(str);
		String prex = longestCommonPrefixv2(str);
		System.out.println(prex);

		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}
	
	/**
	 * 第一种思路: 横向扫描
	 * 两两比较，得出两者的最长公共前缀字符串，再拿这个字符串和第三个字符串比较，以此类推
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefixv1(String[] strs) {
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
    //两两比较，得出公共前缀
    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
    
    /**
     * 思路2: 纵向扫描
     * 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
     * 如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefixv2(String[] strs){
    	
    	if (strs == null || strs.length == 0) {
            return "";
        }
    	int length = strs[0].length();//以第一个字符串为基准，最多循环比较length次数
        int count = strs.length;
        for (int i = 0; i < length; i++) {//比较第i列上的字符
        	char c = strs[0].charAt(i);//第一个字符串的第i列
            for (int j = 1; j < count; j++) {//从第2行开始，依次和第一行的第i列比较
                if (i == strs[j].length() || strs[j].charAt(i) != c) {//在第i列上出现 不相同的字符  或 者在第i列上出现空缺位(字符串长度比第一个短)
                    return strs[0].substring(0, i);
                }
            }
		}
    	return strs[0];
    }
    
    
    
    /**
     * 思路3: 二分查找法
     * 显然，最长公共前缀的长度不会超过字符串数组中的最短字符串的长度。
     * 用  minLength 表示字符串数组中的最短字符串的长度，
     * 则可以在 [0,minLength] 的范围内通过二分查找得到最长公共前缀的长度。
     * 每次取查找范围的中间值  mid，判断每个字符串的长度为 mid 的前缀是否相同，
     * 如果相同则最长公共前缀的长度一定大于或等于 mid，
     * 如果不相同则最长公共前缀的长度一定小于 mid，
     * 通过上述方式将查找范围缩小一半，直到得到最长公共前缀的长度
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefixv3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {//找出 最短的字符串(最短长度)
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    // 判断每一个 字符串的前 length 个字符是否相同
    public static boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }    
}
