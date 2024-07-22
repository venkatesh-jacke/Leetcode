package Graph;

import java.util.*;


//2392. Build a Matrix With Conditions

public class BuildMatrix {
    static public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] matrix = new int[k][k];
        List<Integer> rowOrder = topologicalSort(rowConditions, k);
        List<Integer> colOrder = topologicalSort(colConditions, k);

        // If either topological sort returns an empty list, it's impossible to build the matrix
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }

        // Create maps to store the position of each element in the order
        HashMap<Integer, Integer> rowVal = new HashMap<>();
        HashMap<Integer, Integer> colVal = new HashMap<>();
        for (int i = 0; i < rowOrder.size(); i++) {
            rowVal.put(rowOrder.get(i), i);
        }
        for (int i = 0; i < colOrder.size(); i++) {
            colVal.put(colOrder.get(i), i);
        }

        // Fill the matrix based on the positions from row and column orders
        for (int i = 1; i <= k; i++) {
            int r = rowVal.get(i);
            int c = colVal.get(i);
            matrix[r][c] = i;
        }
        return matrix;
    }

    static private boolean dfs(Map<Integer, List<Integer>> graph, int src, Set<Integer> visited, Set<Integer> path, List<Integer> order) {
        if (path.contains(src)) return false; // cycle detected
        if (visited.contains(src)) return true; // already processed this node

        path.add(src);
        visited.add(src);

        for (int neighbor : graph.getOrDefault(src, new ArrayList<>())) {
            if (!dfs(graph, neighbor, visited, path, order)) {
                return false;
            }
        }

        path.remove(src);
        order.add(src);
        return true;
    }

    static private List<Integer> topologicalSort(int[][] edges, int k) {
        List<Integer> order = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build the graph from edges
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> path = new HashSet<>();

        // Perform DFS from each node
        for (int src = 1; src <= k; src++) {
            if (!visited.contains(src) && !dfs(graph, src, visited, path, order)) {
                return new ArrayList<>(); // return empty list if cycle is detected
            }
        }

        Collections.reverse(order); // reverse to get the correct topological order
        return order;
    }

    public static void main(String[] args) {


        int k = 3;
        int[][] rowConditions = {{1, 2}, {3, 2}};
        int[][] colConditions = {{2, 1}, {3, 2}};

        int[][] matrix = buildMatrix(k, rowConditions, colConditions);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
