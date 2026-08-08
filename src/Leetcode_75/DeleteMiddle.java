package Leetcode_75;

import LinkedList.ListNode;

//2095. Delete the Middle Node of a Linked List

public class DeleteMiddle {
    public static void main(String[] args) {

    }
    static  public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode slow = head;
        // Start fast two steps ahead.
        // This makes fast reach the end earlier, causing slow to stop
        // one node before the middle (instead of at the middle).
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
