package com.qianxun.utils;


/**
 * 简单算法 工具集
 * @author qianxun
 *
 */
public class ArithUtils {

	
	/**
	 * 两字符串的 最大公共子串
	 * "abcdef" 和"defg"  返回 "def"
	 * @param maxString
	 * @param minString
	 * @return
	 */
    public static String getMaxSubString(String  maxString,String minString){
         //1. 必须保证 第一个字符串的长度是长的。第二个是短的。
         if(minString.length()>maxString.length()){
               // 重新调用这个方法
               return getMaxSubString(minString, maxString);
         }
         //2. 判断一下，是否直接包含，如果是的话，就不用进行阵列转换了。
         if(maxString.contains(minString)){
               return minString;
         }
         //3. 取出长度，转换相对应的矩阵。 通常，长的为y,短的为x.
         int maxLength=maxString.length();
         int minLength=minString.length();
         // 构建二维数组
         int [][] conver=new int[minLength][maxLength];
         int maxValue=0; //最大的值。
         int maxIndex=0;//最大的索引。
         //4. 对这个矩阵进行相应的放值。
         for (int i = 0; i <minLength; i++) {
               for(int j=0;j<maxLength;j++){
                    //5.判断一下，值是否相同。 如果相同，
                    if(minString.charAt(i)==maxString.charAt(j)){
                         //相同了，看是第几行，第几列。 第1行或者第1列的为1
                         if(i==0||j==0){
                              conver[i][j]=1;
                         }else{
                              conver[i][j]=conver[i-1][j-1]+1; //为左上角的值加1.
                              if(maxValue<conver[i][j]){ //  整个数组的最大值。 也可以是<= < 时表示取第一个，<=为最后一个。(如果存在多个的情况下)
                                   maxValue=conver[i][j];  //取出那个最大的值。
                                   maxIndex=i; //取出那个最大的列索引。(短字符串的行索引)
                              }
                         }
                         
                    }else{
                         conver[i][j]=0;  //如果不相同，为0.
                    }
               }
               
         }
         //5. 根据最大的索引和最大的值，来判断截取那个最大的子字符串。
         if(maxValue!=0&&maxIndex!=0){ // 双重判断，如果有值的话。
               /**
                * 以短字符串为例
                * maxIndex: 代表最长公共子串的最末尾字符的索引
                * maxValue: 从最长公共子串的末位往左看，出现连续1的次数(连续公共字符的个数)
                * 所以:maxIndex = 4,maxValue = 3 来说， 最长公共子串末位索引为4，左边连续出现3个公共字符，等价于 索引2,3,4这三个字符为最长公共子串
                * 开始索引为 4-3+1 = 2，结束索引为4，因为substring截取规则是不包含结束索引的，索引要往右退一位
                */
               return  minString.substring(maxIndex-maxValue+1,maxIndex+1);
         }
         return null;
    }
    
    
    /**
     * 获取 字符串数组的最长公共前缀
     * ["leetcode","leetde","leets","leett"] 返回"leet"
     * 思路: 纵向扫描
     * 从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，
     * 如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs){
    	
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
     * 对主串s和模式串t进行KMP模式匹配
     * @param s 主串
     * @param t 模式串
     * @return 若匹配成功，返回t在s中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String s, String t){
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        
        int[] next = getNextArray(t_arr);

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
    
    
    /**
     * 求出一个字符数组的next数组
     * next数组各值的含义其实就是：代表当前字符之前的字符串中，相同前缀后缀的最大长度。
     * 注：前缀和后缀可类别对称性，有后缀必有相同的前缀，虽然它们不是关于某点真正对称的，
     * 只是有了后缀必然有相同的前缀。例如如果next[j] = k，代表j之前为[0，j-1] ）的字符串中有最大长度为k的相同前缀后缀
     * 
     * 假设模式串为：a b c d a a b c a b，那么它对应的next数组为
     * 下标 j	           0	1	2	3	4	5	6	7	8	9
          p[j]	       a	b	c	d	a	a	b	c	a	b
          next[j]	  -1	0	0	0	0	1	1	2	3	1
                   k  -1	0	0	0	0	1	1	2	3	1
     * next函数定义：

		1）当j=0时，next[j]=-1
		2）next[j]=Max{k | 0<k<j-1且"p0…pk-1"=“pj-k…pj-1”}
		3）其他情况，next[j]=0
		注：第二点其实就是求[0，j-1]中前缀和后缀最大公共字符串的长度
		
		前缀：必须含有第一个字符 后缀：必须含有最后一个字符
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
}
