package LinkedList;


//2130. Maximum Twin Sum of a Linked List
public class PairSum {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pairSum(head));
        System.out.println(pairSum2(head));
    }


    //Time Complexity is O(n)
    //Space Complexity is O(N)
    static public int pairSum(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        int arr[] = new int[size];
        int i = 0;
        while (head != null) {
            arr[i++] = head.val;
            head = head.next;
        }
        int j = 0;
        int k = arr.length - 1;
        int max = 0;
        while (j < k) {
            int sum = arr[j] + arr[k];
            max = Math.max(sum, max);
            j++;
            k--;
        }
        return max;
    }

    static public int pairSum2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode temp = null;

        //Reverse first half of an linkedList
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        int res = 0;
        while (slow != null && prev != null) {
            res = Math.max(res, slow.val + prev.val);
            prev = prev.next;
            slow = slow.next;
        }

        return res;
    }

}
