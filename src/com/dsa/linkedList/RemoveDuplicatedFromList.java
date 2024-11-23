package com.dsa.linkedList;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class RemoveDuplicatedFromList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		if (temp == null)
			return temp;
		if (temp.next == null)
			return temp;
		else {
			while (temp.next != null) {
				if (temp.val == temp.next.val) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
			}
		}

		return head;
	}

}
