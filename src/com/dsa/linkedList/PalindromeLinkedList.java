package com.dsa.linkedList;

// https://leetcode.com/problems/palindrome-linked-list/

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode revHead = null;
		while (slow != null) {
			fast = slow.next;
			slow.next = revHead;
			revHead = slow;
			slow = fast;
		}
		while (revHead != null) {
			if (revHead.val != head.val)
				return false;
			revHead = revHead.next;
			head = head.next;
		}
		return true;
	}

}
