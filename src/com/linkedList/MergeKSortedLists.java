package com.linkedList;

// https://leetcode.com/problems/merge-k-sorted-lists/

public class MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode temp = new ListNode(0);
		ListNode newHead = temp;
		for (ListNode list : lists) {
			temp.next = list;
			while (list != null) {
				list = list.next;
				temp = temp.next;
			}
		}
		return mergeSort(newHead.next);
	}

	// merge sort
	ListNode sortedMerge(ListNode a, ListNode b) {
		ListNode result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.val <= b.val) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return result;
	}

	ListNode mergeSort(ListNode h) {

		if (h == null || h.next == null) {
			return h;
		}

		ListNode middle = getMiddle(h);
		ListNode nextofmiddle = middle.next;

		middle.next = null;

		ListNode left = mergeSort(h);

		ListNode right = mergeSort(nextofmiddle);

		ListNode sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	public static ListNode getMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode slow = head, fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
