package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;


class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class MyCircularDeque {

    private Node head, tail;
    private int size, capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /** Adds an item at the front of Deque. Returns true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Returns true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        Node newNode = new Node(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Returns true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;

        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev.next = null; // Help GC
            head.prev = null;
        }

        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Returns true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null; // Help GC
            tail.next = null;
        }

        size--;
        return true;
    }

    /** Get the front item from the deque. If the deque is empty, return -1. */
    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }

    /** Get the last item from the deque. If the deque is empty, return -1. */
    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}
