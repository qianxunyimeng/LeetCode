package com.qianxun.easy;

import java.util.ArrayList;

import com.qianxun.basebean.ListNode;

public class Test_0083删除链表中重复元素 {

	public static void main(String[] args) {
		ListNode L1 = ListNode.makeNode(new int[]{1,1,2,3});
		ListNode node = deleteDuplicates(L1);
		ArrayList<Integer> traverse = node.traverse();
		for (Integer integer : traverse) {
			System.out.println(integer);
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
	    ListNode current = head;
	    while (current != null && current.next != null) {
	        if (current.next.val == current.val) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}

}
