package LinkedList;


import java.util.Arrays;

//234. Palindrome Linked List
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome2(head));
    }

    //Time Complexity is O(n)
    //Space Complexity is O(n) Extra space
    static public boolean isPalindrome(ListNode head) {
        int arr[] = new int[100000];
        boolean flag = true;
        int i = 0;
        while (head != null) {
            arr[i] = head.val;
            head = head.next;
            i++;
        }
        int j = 0;
        int k = i - 1;

        while (j < k) {
            if (arr[j] != arr[k]) {
                flag = false;
            }
            j++;
            k--;
        }
        return flag;

    }

    static public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        //Find the middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse the second part of List

        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode left = head;
        ListNode right = prev;//prev is last node as prev will stop before null

        while(right!=null){  //since right portion will end in null
            if(left.val!=right.val){
                return false;
            }
            left=left.next;
            right=right.next;

        }

        return true;

    }
}
