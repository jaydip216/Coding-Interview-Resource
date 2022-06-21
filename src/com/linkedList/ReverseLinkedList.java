package com.linkedList;

// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		ListNode current = null;
		ListNode temp = head;

		while (head != null) {
			temp = head.next;
			head.next = current;
			current = head;
			head = temp;
		}
		return current;
	}
}
