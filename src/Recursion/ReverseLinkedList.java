package Recursion;

import LinkedList.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList.ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
        ;
        LinkedList.ListNode.printList(reverseList(head));
    }

    static public LinkedList.ListNode reverseList(LinkedList.ListNode head) {
        if (head == null || head.next == null) return head;
        LinkedList.ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
