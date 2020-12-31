package com.qianxun.easy;

import java.util.ArrayList;

import com.qianxun.basebean.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author qianxun
 *
 */
public class Test_0021合并链表 {
	public static void main(String[] args) {
		ListNode L1 = ListNode.makeNode(new int[]{1,2,4});
		ListNode L2 = ListNode.makeNode(new int[]{1,3,4});
		ListNode mergeTwoLists = mergeTwoLists(L1,L2);
		//ArrayList<Integer> traverse = ListNode.traverse(mergeTwoLists);
		ArrayList<Integer> traverse = mergeTwoLists.traverse();
		for (Integer integer : traverse) {
			System.out.println(integer);
		}
		
	}
	
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        // 类似归并排序中的合并过程
	        ListNode dummyHead = new ListNode(0);//模拟头节点head
	        ListNode cur = dummyHead;// cur 当前指针指向位置
	        while (l1 != null && l2 != null) {
	            if (l1.val < l2.val) {
	                cur.next = l1;
	                cur = cur.next;
	                l1 = l1.next;
	            } else {
	                cur.next = l2;
	                cur = cur.next;
	                l2 = l2.next;
	            }
	        }
	        // 任一为空，直接连接另一条链表
	        if (l1 == null) {
	            cur.next = l2;
	        } else {
	            cur.next = l1;
	        }
	        return dummyHead.next;
	    }
	 
	 
	 public static ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
	        if (l1 == null) {
	            return l2;
	        } else if (l2 == null) {
	            return l1;
	        } else if (l1.val < l2.val) {
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        } else {
	            l2.next = mergeTwoLists(l1, l2.next);
	            return l2;
	        }

	    }

}
