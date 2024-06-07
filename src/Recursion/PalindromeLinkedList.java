package Recursion;

import LinkedList.ListNode;

public class PalindromeLinkedList {

    static LinkedList.ListNode cur;

    public static void main(String[] args) {
        LinkedList.ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
        System.out.println(palindromeLinkedList(head));
    }

    private static boolean palindromeLinkedList(ListNode head) {
        cur = head;
        return rec(head);
    }

    static boolean rec(LinkedList.ListNode head) {
        if (head == null) return true;
        boolean subProblem = rec(head.next);
        System.out.println("Comparing "+head.val+" and "+cur.val);
        if (!subProblem || head.val != cur.val) {
            return false;
        }
        cur = cur.next;
        return true;
    }
}
