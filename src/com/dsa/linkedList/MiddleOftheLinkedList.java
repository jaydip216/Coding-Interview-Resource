package com.dsa.linkedList;

// https://leetcode.com/problems/middle-of-the-linked-list/

public class MiddleOftheLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode middleNode(ListNode head) {
		ListNode middle = head;
		ListNode last = head;

		while (last != null && last.next != null) {
			middle = middle.next;
			last = last.next.next;
		}
		return middle;
	}
}
