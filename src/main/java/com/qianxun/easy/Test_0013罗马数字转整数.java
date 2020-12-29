package com.qianxun.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内
 *
 *输入: "III"
 * 输出: 3
 *
 * 输入: "IV"
 * 输出: 4
 *
 * 输入: "IX"
 * 输出: 9
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4
 * @author 千寻
 * @version 1.0
 * @create 2020-12-29 22:01
 */
public class Test_0013罗马数字转整数 {

    /*按照题目的描述，可以总结如下规则：

    罗马数字由 I,V,X,L,C,D,M 构成；
    当小值在大值的左边，则减小值，如 IV=5-1=4；
    当小值在大值的右边，则加小值，如 VI=5+1=6；
    由上可知，右值永远为正，因此最后一位必然为正。
    一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。*/

    public static void main(String[] args) {
        System.out.println(romanToInt3("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ans = 0;
        for(int i = 0;i < s.length();) {
            //从左向右，优先判断两字符的组合，再判断单字符
            if(i + 1 < s.length() &&  map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int prenum = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            //左边小于右边就减去，大于右边就加上
            if( prenum < num) {
                ans -= prenum;
            }else {
                ans += prenum;
            }
            prenum = num;
        }
        //加上最后一位
        ans += prenum;
        return ans;
    }


    //方法3 性能上优先方法2
    public static int romanToInt3(String s) {
        int sum = 0;
        //暂存 最左边 第一位 罗马数字 对应的整数
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
