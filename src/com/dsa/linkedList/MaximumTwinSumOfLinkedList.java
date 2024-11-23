package com.dsa.linkedList;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

public class MaximumTwinSumOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int pairSum(ListNode head) {
		ListNode prev = null, slow = head, fast = head;
		while (fast != null) {
			fast = fast.next.next;
			ListNode temp = slow.next;
			slow.next = prev;
			prev = slow;
			slow = temp;
		}
		int max = 0;
		while (prev != null) {
			int localMax = prev.val + slow.val;
			if (localMax > max)
				max = localMax;

			prev = prev.next;
			slow = slow.next;
		}
		return max;
	}
}
