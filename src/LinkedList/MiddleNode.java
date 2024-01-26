package LinkedList;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        middleNode(head);
        ListNode.printList(middleNode2(head));
    }

    //Approach 1 BruteForce
    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public ListNode middleNode(ListNode head) {
        ListNode tail = head;
        int size = 0;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        int mid=(size+1)/2;
        int i=0;
        while(i!=mid){
            head=head.next;
            i++;
        }
        System.out.println(head.val);
        return head;
    }


    //Approach 2 slow and fast pointer
    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public ListNode middleNode2(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
