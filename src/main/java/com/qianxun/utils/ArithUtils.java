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
}
