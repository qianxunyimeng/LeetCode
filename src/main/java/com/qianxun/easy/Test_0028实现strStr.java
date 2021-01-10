package com.qianxun.easy;

/**
 * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 * @author qianxun
 *
 */
public class Test_0028实现strStr {
	public static void main(String[] args) {
		
	}
	
	/**
	 * 滑动窗口，逐一比较
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
	    int L = needle.length(), n = haystack.length();

	    for (int start = 0; start < n - L + 1; ++start) {
	      if (haystack.substring(start, start + L).equals(needle)) {
	        return start;
	      }
	    }
	    return -1;
	  }
	
	public static int KMP(String s1,String s2){
        if(s1.length()<s2.length()||s2.length()==0||null==s2) return -1;
        //求模式串的next数组
        int[] next=new int[s2.length()];
        next[0]=-1;
        for(int i=1,k=-1;i<s2.length();i++){
            if(k==-1||s2.charAt(i-1)==s2.charAt(k)){
                k++;
                next[i]=k;
            }
            else {
                next[i]=0;
                k=0;
            }
        }
        //进行匹配
        for(int i=0,j=0;i<s1.length();){
            if(s1.charAt(i)!=s2.charAt(j)){
                if(next[j]==-1) i++;
                else j=next[j];
            }
            else{
                if(j==s2.length()-1) return i-s2.length()+1;
                i++;j++;
            }
        }
        return -1;
    }
    

}
