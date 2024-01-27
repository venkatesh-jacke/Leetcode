package LinkedList;


//21. Merge Two Sorted Lists
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

       ListNode.printList(mergeTwoLists(list1, list2));

    }


    //Time Complexity is O(n+m) n is no of list1 node and m is no of list2 nodes
    static public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy= new ListNode(Integer.MIN_VALUE);
        ListNode ptr=dummy;
        while(list1!=null && list2!=null){
            if(list1.val< list2.val){
                ptr.next=list1;
                list1=list1.next;
            }else{
                ptr.next=list2;
                list2= list2.next;
            }
            ptr=ptr.next;
        }
        ptr.next=list1==null?list2:list1;
        return dummy.next;
    }
}
