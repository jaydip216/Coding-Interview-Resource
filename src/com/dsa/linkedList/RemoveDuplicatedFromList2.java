package com.dsa.linkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class RemoveDuplicatedFromList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = null;
		ListNode temp = head;

		if (head == null)
			return head;

		if (head.next == null)
			return head;
		int count = 0;
		while (temp != null && temp.next != null) {
			while (temp != null && temp.next != null && temp.val == temp.next.val) {
				temp.next = temp.next.next;
				count += 1;
			}
			if (count != 0) {
				if (prev == null) {
					head = temp.next;
				} else {
					prev.next = temp.next;
				}
				temp = temp.next;
				count = 0;
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
		return head;
	}
}
