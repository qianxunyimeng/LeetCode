package com.qianxun.easy;

public class 最长公共子串 {
	// https://blog.csdn.net/xiehaoyun2012/article/details/12066515
	public static void main(String[] args) {
		String maxSubString = getMaxSubString("abcdef","defg");
		System.out.println(maxSubString);// def
	}
	
	// 如，传递的参数为 "abcdef" 和"defg"
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

}
