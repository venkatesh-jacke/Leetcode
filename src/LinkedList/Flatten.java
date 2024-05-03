package LinkedList;


//430. Flatten a Multilevel Doubly Linked List
public class Flatten {
    public static void main(String[] args) {
        // Create the ListNodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        ListNode node12 = new ListNode(12);

        // Connect the ListNodes to form the multilevel doubly linked list
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node4.child = node11;
        node11.next = node12;
        node12.prev = node11;

        flatten(node1);
        ListNode.printList(node1);
    }
    static public ListNode flatten(ListNode head) {
        // if (head != null)
        //     rec(head);
        // return head;


        ListNode cur=head;
        while(cur!=null){
            ListNode child=cur.child;
            if(child==null){
                cur=cur.next;
                continue;
            }
            ListNode tail=child; //tofind the tail
            while(tail.next!=null) tail=tail.next;
            tail.next=cur.next;
            if(cur.next!=null) cur.next.prev=tail;
            cur.next=cur.child;
            cur.child.prev=cur;
            cur.child=null;

        }
        return head;

    }

    static  public ListNode rec(ListNode head) {
        ListNode cur = head, tail = head;
        while (cur != null) {
            ListNode child = cur.child;
            ListNode next = cur.next;
            if (cur.child != null) {
                ListNode last = rec(child);
                last.next = next;
                if (next != null)
                    next.prev = last;
                cur.next = child;
                child.prev = cur;
                cur.child = null;
            } else {
                cur = next;
            }
            if (cur != null)
                tail = cur;
        }
        return tail;
    }
}
