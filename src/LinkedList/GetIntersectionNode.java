package LinkedList;


import jdk.nashorn.internal.ir.WhileNode;

//160. Intersection of Two Linked Lists
public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(3);



        ListNode headB = new ListNode(2);
        ListNode node3 = new ListNode(3);
        headB.next = headA;


        // Call the method to find the intersection node
        ListNode intersectionNode = getIntersectionNode2(headA, headB);
        System.out.println(intersectionNode.val);

    }


    //Approach 1 BruteForce
    //Time Complexity is O(m*n) m is length of list1 and n is length of list2
    //Space Complexity is O (1)
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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

    static public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        while (d1 != null || d2 != null) {
            if (d1 == d2) {
                return d1;
            }
            if (d1 == null) {
                d1 = headB;
            }
            if (d2 == null) {
                d2 = headA;
            }
            d1 = d1.next;
            d2 = d2.next;
        }
        return null;
    }

}
