package com.qianxun.easy;

import sun.security.util.Length;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串

输入：s = "Hello World"
输出：5


输入：s = " "
输出：0

 * @author 46096
 *
 */
public class Test_0058最后一个单词的长度 {

	public static void main(String[] args) {
		
		//int lengthOfLastWord = lengthOfLastWord("hello world   ");
		int lengthOfLastWord = lengthOfLastWord("a");
		System.out.println(lengthOfLastWord);

	}
	
	
	 public static int lengthOfLastWord(String s) {

		 int end = s.length() - 1;

		 //从末尾往前(从右向左遍历),找到第一个有效字符(非空)
		 while(end >= 0 && s.charAt(end) == ' ') {
			 end--;
		 }		 
		 if(end < 0 ) {
			return 0; 
		 }
		 
		 //从end向左遍历，找到第一个 空格start 
		 int start = end;
		 while(start >= 0 && s.charAt(start) != ' ') {
			 start--;
		 }
		 return end - start;
		 
	 }

}
