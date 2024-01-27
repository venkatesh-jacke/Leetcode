package LinkedList;

//705. Design HashSet
public class DesignHashSet {

    public static void main(String[] args) {

    }
}

class MyHashSet {
    Node arr[];

    // Inner class representing a node in the linked list
    class Node {
        int data;
        Node next;

        // Constructor to initialize a node with data
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize the hash set with an array of nodes
    public MyHashSet() {
        arr = new Node[32]; // Initialize the array with size 32
    }

    // Method to add an element to the hash set
    public void add(int data) {
        int bucket = hash(data); // Calculate the bucket index for the data
        Node bucketPos = arr[bucket]; // Get the node at the bucket index
        if (bucketPos == null) { // If the bucket is empty
            arr[bucket] = new Node(data); // Create a new node and assign it to the bucket
        } else { // If the bucket is not empty
            Node prev = bucketPos; // Initialize a pointer to track the previous node
            while (bucketPos != null) { // Traverse the linked list in the bucket
                if (bucketPos.data == data) { // If the data already exists in the bucket
                    return; // Exit the method
                }
                if (prev.next == null) { // If the next node is null (end of the linked list)
                    break; // Exit the loop
                }
                prev = prev.next; // Move the pointer to the next node
                bucketPos = bucketPos.next; // Move to the next node in the linked list
            }
            prev.next = new Node(data); // Add a new node at the end of the linked list
        }
    }

    // Method to remove an element from the hash set
    public void remove(int data) {
        int bucket = hash(data); // Calculate the bucket index for the data
        Node bucketPos = arr[bucket]; // Get the node at the bucket index
        if (bucketPos == null) { // If the bucket is empty
            return; // Exit the method
        } else if (bucketPos.data == data) { // If the first node in the bucket contains the data
            arr[bucket] = bucketPos.next; // Update the bucket reference to the next node
        } else { // If the data is not in the first node
            Node prev = bucketPos; // Initialize a pointer to track the previous node
            while (bucketPos != null) { // Traverse the linked list in the bucket
                if (bucketPos.data == data) { // If the data is found in the linked list
                    prev.next = bucketPos.next; // Remove the node containing the data
                    return; // Exit the method
                }
                if (bucketPos.next == null) { // If the next node is null (end of the linked list)
                    break; // Exit the loop
                }
                prev = bucketPos; // Move the pointer to the next node
                bucketPos = bucketPos.next; // Move to the next node in the linked list
            }
        }
    }

    // Method to check if the hash set contains an element
    public boolean contains(int data) {
        int bucket = hash(data); // Calculate the bucket index for the data
        Node bucketPos = arr[bucket]; // Get the node at the bucket index
        while (bucketPos != null) { // Traverse the linked list in the bucket
            if (bucketPos.data == data) { // If the data is found in the linked list
                return true; // Return true
            }
            bucketPos = bucketPos.next; // Move to the next node in the linked list
        }
        return false; // Return false if the data is not found
    }

    // Method to calculate the bucket index for a given data
    private int hash(int data) {
        return data % 16; // Return the remainder of data divided by 16
    }
}
//class MyHashSet {
//
//    boolean[] set;
//
//    public MyHashSet() {
//        set = new boolean[1000001];
//
//
//    }
//
//    public void add(int key) {
//        set[key] = true;
//
//    }
//
//    public void remove(int key) {
//        set[key] = false;
//
//    }
//
//    public boolean contains(int key) {
//        return set[key];
//
//    }
//}