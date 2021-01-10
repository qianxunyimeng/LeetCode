package com.qianxun.easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

输入: [1,3,5,6], 5
输出: 2

输入: [1,3,5,6], 2
输出: 1



假设题意是叫你在排序数组中寻找是否存在一个目标值，那么训练有素的读者肯定立马就能想到利用二分法在O(logn) 的时间内找到是否存在目标值。但这题还多了个额外的条件，即如果不存在数组中的时候需要返回按顺序插入的位置，那我们还能用二分法么？答案是可以的，我们只需要稍作修改即可。

考虑这个插入的位置 pos，它成立的条件为：

nums[pos−1] < target ≤ nums[pos]

其中nums 代表排序数组。由于如果存在这个目标值，我们返回的索引也是 pos，因此我们可以将两个条件合并得出最后的目标：
「在一个有序数组中找第一个大于等于 target 的下标」。


 * @author qianxun
 *
 */
public class Test_0035搜索插入位置 {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		int index = searchInsert(nums,0);
		System.out.println(index);
	}
	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;
		int ans = n;
		
		while(low <= high){
			//int mid = (high - low + 1) / 2 + low;
			int mid = ((high - low) >> 1) + low;
			if(target <= nums[mid]){
				ans = mid;
				high = mid - 1;
			}else{
				low = mid + 1;
			}
		}
		return ans;
    }

}
