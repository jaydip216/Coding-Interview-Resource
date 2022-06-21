package com.linkedList;

// https://leetcode.com/problems/rotate-list/

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode temp=head;
        if(head==null || head.next==null)
            return head;
        while(temp.next!=null){
            len+=1;
            temp=temp.next;
        }        
        temp.next=head;
        temp=head;
        ListNode prev=head;
        int steps=len-k%len;
        while(steps>0){
            prev=temp;
            temp=temp.next;
            steps--;
        }
        prev.next=null;
        head=temp;
        return temp;
    }
}
