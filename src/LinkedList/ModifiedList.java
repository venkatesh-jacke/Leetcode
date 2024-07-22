package LinkedList;

import java.util.HashSet;


//3217. Delete Nodes From Linked List Present in Array
public class ModifiedList {
    public static void main(String[] args) {
        int[] arr = {1};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);

        ListNode.printList(modifiedList(arr, head));
    }

    static public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;


        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;  //remove
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;

    }
}
