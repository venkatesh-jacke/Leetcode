package LinkedList;


//https://leetcode.com/problems/design-linked-list/
class MyLinkedList {

    int length;
    Node head;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public int get(int index) {
        if (index >= length)
            return -1;
        int counter = 0;
        Node temp = head;
        while (counter < index) {
            counter++;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
        } else {
            Node temp = head;
            Node newNode = new Node(val);
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
            length++;

        }
    }

    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        if (index == 0)
            addAtHead(val);
        else {
            int counter = 1;
            Node temp = head;
            while (counter < index) {
                temp = temp.next;
                counter++;
            }
            Node newNode = new Node(val);
            Node next = temp.next;
            temp.next = newNode;
            newNode.next = next;
            length++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= length)
            return;
        if (index == 0) {
            head = head.next;
            length--;
        } else {
            int counter = 1;
            Node temp = head;
            while (counter < index) {
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
            length--;
        }
    }

    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

    }
}
