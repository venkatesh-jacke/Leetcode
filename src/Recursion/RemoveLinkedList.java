package Recursion;

import LinkedList.ListNode;

public class RemoveLinkedList {
    public static void main(String[] args) {
        LinkedList.ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        LinkedList.ListNode.printList(removeLinkedList(head, 6));
    }

    public static LinkedList.ListNode removeLinkedList(LinkedList.ListNode head, int val) {
        if (head == null) return null;
        head.next = removeLinkedList(head.next, val); //call who will be next

        //In returning phase decide who should u give
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
