package LinkedList;

//2. Add Two Numbers
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1= new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next= new ListNode(6);
        l2.next.next= new ListNode(4);
        ListNode.printList(addTwoNumbers(l1,l2));
    }
    static  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(-1);
        ListNode ptr=dummy;
        ListNode t1=l1;
        ListNode t2=l2;
        int carry=0;
        while(t1!=null || t2!=null){
            int x=(t1!=null)?t1.val:0;
            int y=(t2!=null)?t2.val:0;
            int sum= x+y+carry;
            carry=sum/10;
            ptr.next=new ListNode(sum%10);
            ptr=ptr.next;
            if(t1!=null)t1=t1.next;
            if(t2!=null)t2=t2.next;
        }
        if(carry>0) ptr.next= new ListNode(carry);
        return dummy.next;
    }
}
