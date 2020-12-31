package com.qianxun.easy;


import javax.swing.text.StyledEditorKit;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class Test_0026删除排序数组中的重复项 {

    /**
     * 首先注意数组是有序的，那么重复的元素一定会相邻。
     *
     * 要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。
     *
     * 考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：
     *
     * 1.比较 p 和 q 位置的元素是否相等。
     *
     * 如果相等，q 后移 1 位
     * 如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
     * 重复上述过程，直到 q 等于数组长度。
     *
     * 返回 p + 1，即为新数组长度。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                if(q - p > 1){//两个相邻元素 就没有必要复制了
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

}
