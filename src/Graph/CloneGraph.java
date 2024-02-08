package Graph;

import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private static Node clone(Node node, HashMap<Node, Node> map) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            if (!(map.containsKey(neighbor))) {
                newNode.neighbors.add(clone(neighbor, map));
            } else {
                newNode.neighbors.add(map.get(neighbor));

            }

        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect nodes
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Create an instance of the CloneGraph class
        CloneGraph cloneGraph = new CloneGraph();

        // Clone the graph
        Node clonedGraph = cloneGraph.cloneGraph(node1);


    }
}
