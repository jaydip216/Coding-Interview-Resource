package com.linkedList;

// https://leetcode.com/problems/odd-even-linked-list/

public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode oddEvenList(ListNode head) {
		ListNode odd, even, firstEven;

		if (head == null || head.next == null) {
			return head;
		}

		odd = head;
		even = head.next;
		firstEven = head.next;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;
			even = even.next;
			odd = odd.next;
		}

		odd.next = firstEven;

		return head;
	}
}
