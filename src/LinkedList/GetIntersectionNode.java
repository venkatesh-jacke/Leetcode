package LinkedList;


import jdk.nashorn.internal.ir.WhileNode;

import java.util.List;

//160. Intersection of Two Linked Lists
public class GetIntersectionNode {
    public static void main(String[] args) {
        int intersectVal = 8;
        int skipA = 2;
        int skipB = 3;
        int[] listA_vals = {4, 1, 8, 4, 5};
        int[] listB_vals = {5, 6, 1};

        ListNode headA = new ListNode(listA_vals[0]);
        ListNode curA = headA;
        ListNode intersection = null;
        for (int i = 1; i < listA_vals.length; i++) {
            curA.next = new ListNode(listA_vals[i]);
            curA = curA.next;
            if (i == skipA) {
                intersection = curA;
            }
        }
        ListNode headB = new ListNode(listB_vals[0]);
        ListNode curB = headB;
        for (int i = 1; i < listB_vals.length; i++) {
            curB.next = new ListNode(listB_vals[i]);
            curB = curB.next;
        }
        curB.next = intersection;


        // Call the method to find the intersection node
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }


    //Approach 1 BruteForce
    //Time Complexity is O(m*n) m is length of list1 and n is length of list2
    //Space Complexity is O (1)
    static public ListNode getIntersectionNode_brute(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while (tempA != null) {
            ListNode tempB = headB;
            while (tempB != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }

    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

}
/*
🧠 Why This Works
        Suppose list A has length m + c, and list B has n + c, where c is the shared tail length.

        Pointer 'a' travels m + c, then switches and travels n, totaling m + n + c steps.

        Pointer 'b' travels n + c, then m, also totaling m + n + c steps.

        If there is an intersection, both pointers arrive at that same node at the same time.

        If there isn't, both reach null simultaneously.
 */
