package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    // Node class representing each frequency node
    public static class Node {
        int freq;
        Node prev;
        Node next;
        Set<String> keys = new HashSet<>();

        Node(int freq) {
            this.freq = freq;
        }
    }

    private Node head;
    private Node tail;
    private Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOne() {
        head = new Node(0); // Dummy head
        tail = new Node(0); // Dummy tail
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node currentNode = map.get(key);
            int newFreq = currentNode.freq + 1;
            Node nextNode = currentNode.next;

            // Remove key from current node
            currentNode.keys.remove(key);

            // Check if next node has the new frequency
            if (nextNode == tail || nextNode.freq != newFreq) {
                // Create a new node for the new frequency
                Node newNode = new Node(newFreq);
                newNode.keys.add(key);
                // Insert newNode between currentNode and nextNode
                newNode.prev = currentNode;
                newNode.next = nextNode;
                currentNode.next = newNode;
                nextNode.prev = newNode;
                map.put(key, newNode);
            } else {
                // Next node already has the new frequency
                nextNode.keys.add(key);
                map.put(key, nextNode);
            }

            // If current node has no keys left, remove it
            if (currentNode.keys.isEmpty()) {
                removeNode(currentNode);
            }
        } else {
            // Key is new, needs to be added with frequency 1
            Node firstNode = head.next;
            if (firstNode == tail || firstNode.freq != 1) {
                // Create a new node for frequency 1
                Node newNode = new Node(1);
                newNode.keys.add(key);
                // Insert newNode right after head
                newNode.prev = head;
                newNode.next = firstNode;
                head.next = newNode;
                firstNode.prev = newNode;
                map.put(key, newNode);
            } else {
                // The first node already has frequency 1
                firstNode.keys.add(key);
                map.put(key, firstNode);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key))
            return;

        Node currentNode = map.get(key);
        int currentFreq = currentNode.freq;
        currentNode.keys.remove(key);

        if (currentFreq == 1) {
            // Remove the key completely
            map.remove(key);
        } else {
            int newFreq = currentFreq - 1;
            Node prevNode = currentNode.prev;

            // Check if previous node has the new frequency
            if (prevNode == head || prevNode.freq != newFreq) {
                // Create a new node for the new frequency
                Node newNode = new Node(newFreq);
                newNode.keys.add(key);
                // Insert newNode between prevNode and currentNode
                newNode.prev = prevNode;
                newNode.next = currentNode;
                prevNode.next = newNode;
                currentNode.prev = newNode;
                map.put(key, newNode);
            } else {
                // Previous node already has the new frequency
                prevNode.keys.add(key);
                map.put(key, prevNode);
            }
        }

        // If current node has no keys left, remove it
        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail.prev == head)
            return "";
        // Return any key from the last node
        return tail.prev.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head.next == tail)
            return "";
        // Return any key from the first node
        return head.next.keys.iterator().next();
    }

    /** Removes a node from the doubly linked list */
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // For testing purposes
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("apple");
        allOne.inc("banana");
        allOne.inc("apple");
        allOne.inc("banana");
        allOne.inc("banana");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Should print "banana"
        System.out.println("Min Key: " + allOne.getMinKey()); // Should print "apple"
        allOne.dec("banana");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Should print "banana"
        System.out.println("Min Key: " + allOne.getMinKey()); // Should print "apple"
        allOne.dec("banana");
        allOne.dec("banana");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Should print "apple"
        System.out.println("Min Key: " + allOne.getMinKey()); // Should print "apple"
    }
}
