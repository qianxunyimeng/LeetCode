package com.qianxun.easy;

import com.qianxun.basebean.TreeNode;

/**
 * 
 * @author 46096
 *
 */
public class Test_0100相同的树 {

	public static void main(String[] args) {
		

	}
	
	/**
	 * 深度优先搜索
                如果两个二叉树都为空，则两个二叉树相同。如果两个二叉树中有且只有一个为空，则两个二叉树一定不相同。

                如果两个二叉树都不为空，那么首先判断它们的根节点的值是否相同，若不相同则两个二叉树一定不同，
                若相同，再分别判断两个二叉树的左子树是否相同以及右子树是否相同。
                这是一个递归的过程，因此可以使用深度优先搜索，递归地判断两个二叉树是否相同
	 * @param p
	 * @param q
	 * @return
	 */
	 public static boolean isSameTree(TreeNode p, TreeNode q) {
	        if (p == null && q == null) {
	            return true;
	        } else if (p == null || q == null) {
	            return false;
	        } else if (p.val != q.val) {
	            return false;
	        } else {
	            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	        }
	    }

}
