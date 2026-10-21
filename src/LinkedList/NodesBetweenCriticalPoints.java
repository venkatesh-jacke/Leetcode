package LinkedList;


import java.util.Arrays;

//2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
public class NodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{5, 3, 1, 2, 5, 1, 2});
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));

    }

    static public int[] nodesBetweenCriticalPoints(ListNode head) {
        int res[] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        ListNode cur = head.next;
        int prevVal = head.val, firstCriticalPoint = -1, prevCriticalPoint = -1, id = 0;
        while (cur.next != null) {
            id++;
            int curVal = cur.val, nextVal = cur.next.val;
            if ((prevVal < curVal && curVal > nextVal) || (prevVal > curVal && curVal < nextVal)) {
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = id;
                    prevCriticalPoint = id;
                } else {
                    res[0] = Math.min(res[0], id - prevCriticalPoint);
                    res[1] = Math.max(res[1], id - firstCriticalPoint);
                }
                prevCriticalPoint = id;
            }
            prevVal = curVal;
            cur = cur.next;

        }
        return (res[0] == Integer.MAX_VALUE) ? new int[]{-1, -1} : res;
    }
}
