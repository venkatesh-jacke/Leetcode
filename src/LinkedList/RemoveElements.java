package LinkedList;


//203. Remove Linked List Elements
public class RemoveElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        ListNode.printList(removeElements3(head, 3));
    }


    //Time Complexity is O(n)
    //Space Complexity is O(n)
    static     public ListNode removeElements3(ListNode head, int val){
        ListNode dummy= new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy.next;
        while(cur!=null){
            if(cur.val!=val){
                cur=cur.next;
            }
            else{
                cur=cur.next.next;
            }
        }
        return dummy.next;
    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public ListNode removeElements2(ListNode head, int val) {
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        // Initialize current pointer to the dummy node
        ListNode current = dummy;

        // Iterate through the list until the end is reached
        while (current.next != null) {
            // Check if the next node's value matches the target value
            if (current.next.val == val) {
                // Skip the next node by pointing current to the node after it
                current.next = current.next.next;
            } else {
                // Move to the next node only if the current node is not removed
                current = current.next;
            }
        }

        // Return the head of the modified list
        return dummy.next;
    }
}
