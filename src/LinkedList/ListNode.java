package LinkedList;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode child;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    ListNode(int val, ListNode next, ListNode prev, ListNode child) {
        this.val = val;
        this.next = next;
        this.prev = prev;
        this.child = child;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("Null");
    }
}
