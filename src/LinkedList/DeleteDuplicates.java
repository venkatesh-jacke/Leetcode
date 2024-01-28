package LinkedList;

// Remove Duplicates from Sorted List
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode.printList(deleteDuplicates(head));


    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public ListNode deleteDuplicates(ListNode head) {
        // Initialize a pointer to traverse the list
        ListNode current = head;

        // Iterate through the list until the current node is not null
        while (current != null) {
            // Store the next node in a separate pointer
            ListNode nextNode = current.next;

            // Check if the next node exists and has the same value as the current node
            while (nextNode != null && nextNode.val == current.val) {
                // If the next node is a duplicate, skip it by pointing the current node to the node after it
                nextNode = nextNode.next;
            }

            // Update the next pointer of the current node to the next non-duplicate node
            current.next = nextNode;

            // Move to the next node in the list
            current = nextNode;
        }

        // Return the head of the modified list (duplicates removed)
        return head;
    }


}