package Leetcode_75;


import LinkedList.ListNode;

//2130. Maximum Twin Sum of a Linked List
public class PairSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pairSum(head));
    }


    static public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode temp = null;

        //Reverse first half of an linkedList
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 1. Move fast two steps
            temp = slow.next; // 2. Save the next node
            slow.next = prev;  // 3. Reverse the current node's link
            prev = slow; // 4. Extend the reversed list
            slow = temp; // 5. Advance slow to continue
        }
        int res = 0;
        while (slow != null && prev != null) {
            res = Math.max(res, slow.val + prev.val);
            prev = prev.next;
            slow = slow.next;
        }

        return res;
    }

}
