package LinkedList;

//19. Remove Nth Node From End of List
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode.printList( removeNthFromEnd(head, 2));
    }

    static public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode d = head;
        while (d != null) {
            len++;
            d = d.next;
        }
        d = head;
        int pos = len - n;
        while (pos - 1 > 0) {
            d = d.next;
            pos--;
        }

        if (n == len) return head.next;
        if(d.next==null) return null;
        else  d.next = d.next.next;
        return head;
    }
}
