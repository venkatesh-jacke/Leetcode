package LinkedList;


//2807. Insert Greatest Common Divisors in Linked List
public class InsertGreatestCommonDivisors {
    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        ListNode.printList(insertGreatestCommonDivisors(head));
    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current=head;
        while(current.next!=null){
            ListNode newNode= new ListNode(gcd(current.val,current.next.val));
            ListNode temp= current.next;
            current.next=newNode;
            newNode.next=temp;
            current=newNode.next;
        }
        return head;
    }

    static public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
