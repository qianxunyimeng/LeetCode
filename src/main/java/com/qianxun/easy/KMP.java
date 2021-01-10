package com.qianxun.easy;

// https://blog.csdn.net/qq_43152052/article/details/100059716
public class KMP {
	/**
	 * next数组各值的含义其实就是：代表当前字符之前的字符串中，相同前缀后缀的最大长度。注：前缀和后缀可类别对称性，有后缀必有相同的前缀，虽然它们不是关于某点真正对称的，只是有了后缀必然有相同的前缀。例如如果next[j] = k，代表j之前为[0，j-1] ）的字符串中有最大长度为k的相同前缀后缀
     * 求出一个字符数组的next数组
     * @param t 字符数组
     * @return next数组
     */
    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k=next[j-1];
            while (k!=-1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                }
                else {
                    k = next[k];
                }
                next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
            }
        }
        return next;
    }

    /**
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        int[] next = getNextArray(t_arr);
        for (int i : next) {
			System.out.println(i);
		}
        System.out.println("=====");
        int i = 0, j = 0;
        while (i<s_arr.length && j<t_arr.length){
            if(j == -1 || s_arr[i]==t_arr[j]){
                i++;
                j++;
            }
            else
                j = next[j];
        }
        if(j == t_arr.length)
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }
}
