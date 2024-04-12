package LinkedList;


//1290. Convert Binary Number in a Linked List to Integer
public class GetDecimalValue {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);

        // Call the getDecimalValue method and print the result
        int result = getDecimalValue(head);
        System.out.println("Decimal value: " + result);
    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res * 2) + head.val;
            head = head.next;
        }
        return res;
    }
}


