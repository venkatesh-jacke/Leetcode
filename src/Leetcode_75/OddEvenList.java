package Leetcode_75;

import LinkedList.ListNode;

//328. Odd Even Linked List

public class OddEvenList {
    public static void main(String[] args) {
        int[] arr= {2,1,3,5,6,4,7};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.printList(oddEvenList(head));
    }
    static public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even!=null &&even.next!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        //Assign even list at end of odd list
        odd.next=evenHead;
        return head;
    }
}
