package LinkedList;


//2181. Merge Nodes in Between Zeros
public class MergeNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        ListNode.printList(mergeNodes2(head));
    }


    //Time Complexity is O(N)
    //Space Complexity is O(N)

    static public ListNode mergeNodes1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        ListNode current = head.next;
        int sum = 0;
        while (current != null) {
            if (current.val == 0) {
                dummy.next = new ListNode(sum);
                dummy = dummy.next;
                sum = 0;
            } else {
                sum += current.val;
            }
            current = current.next;
        }
        return ptr.next;

    }


    //Time Complexity is O(N)
    //Space Complexity is O(1)
        static public ListNode mergeNodes2(ListNode head) {
            ListNode current = head;
            ListNode temp = current.next;
            while (temp != null) {
                int sum = 0;
                while (temp.val != 0) {
                    sum = sum + temp.val;
                    temp = temp.next;
                }
                if(temp.val==0&&temp.next==null){  //To check and terminate the last zero node
                    current.val=sum;
                    current.next=null;
                    break;
                }
                current.val=sum;
                current.next = temp;
                current = temp;
                temp = temp.next;
            }
            return head;
        }

}
