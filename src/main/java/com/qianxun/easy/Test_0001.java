package com.qianxun.easy;

import java.util.HashMap;

/**
 *
 * 练习1，两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *
 * @author 千寻
 * @version 1.0
 * @create 2020-12-28 21:27
 */
public class Test_0001 {

    public static void main(String[] args) {
         int[] nums = new int[]{1,3,8,21,56,78,77};
         int target = 59;
        int[] result = twoSum(nums, target);
        if(null != result){
            System.out.println("nums["+ result[0] +"] + nums["+ result[1]+"] ="+target);
        }else{
            System.out.println("没有符合条件的数值");
        }
    }

    /**
     * 思路:
     * 遍历整数数组，将之存在Map里，value为数组索引,key为满足 两数和为target的另一个数值，
     * 如果Map不存在这个key,就把key = target - num[i],value = i 存进Map
     * 如果Map存在这个key,说明以前遍历的数组中存在 该条件，两数和为 target
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // value为数组下标,key为能和该下标对应的数值和为目标值的数值
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            // 58,0
            // 56,1
            // 51,2
            // 38,3
            // 3,4
            map.put(target - nums[i], i);
        }
        return null;
    }

    //方法2，使用双重for循环
    public static int[] twoSum2(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}


