package com.qianxun.easy;

public class Test_0088合并两个有序数组 {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3,0,0,0};
		int[] nums2 = new int[]{2,5,6};
		merge(nums1, 3, nums2, 3);
		for (int i : nums1) {
			System.out.println(i);
		}
		
		
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/**
		 * 思路: 一般有数数组可以采用双指针法
		 * 这里采用3指针
		 * 指针p1 指向nums1有效数据的尾部
		 * 指针p2 指向nums2有效数据尾部
		 * 指针p3 指向最终合并后的尾部
		 * 1.当，p1>=0时，nums[p1],nums[p2]对比
         * 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
         * 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
         * 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
         * 循环结束条件：p2<0
		 * 
		 */
		int p1 = m -1;
		int p2 = n -1;
		int p3 = m + n - 1;
		while(p2 >= 0) {
			if(p1 >= 0 && nums1[p1] > nums2[p2]) {
				nums1[p3--] = nums1[p1--];
			}else {
				nums1[p3--] = nums2[p2--];
			}
		}
		
	}

}
