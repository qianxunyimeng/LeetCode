package com.qianxun.easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class Test_0053最大子序和 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        /**
         * 用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
         * 变相求 max(f(i))  0<i<n-1
         *
         * f(i) = max{f(i−1)+nums[i],nums[i]}
         */
        int pre = 0, maxAns = nums[0];

        for (int x : nums) {
            pre = Math.max(pre + x, x);   // 求出 f(i)
            maxAns = Math.max(maxAns, pre); // f(i) 和 f(i-1) 哪个大
        }
        return maxAns;
    }
}
