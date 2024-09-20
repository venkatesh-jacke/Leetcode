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

    public static ListNode createLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
}
