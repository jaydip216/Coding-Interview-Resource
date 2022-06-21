package com.linkedList;

// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode();
		ListNode temp = res;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int a = l1 == null ? 0 : l1.val;
			int b = l2 == null ? 0 : l2.val;
			int c = a + b + carry;
			if (c >= 10) {
				carry = 1;
				c = c % 10;
			} else
				carry = 0;
			temp.next = new ListNode(c);
			temp = temp.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		if (carry > 0) {
			temp.next = new ListNode(carry);
		}
		return res.next;
	}
}
