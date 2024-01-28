package LinkedList;


//141. Linked List Cycle
public class HasCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next = head;
        System.out.println(hasCycle(head));
    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;

    }
}
