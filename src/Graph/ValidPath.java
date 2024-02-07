package Graph;

import java.util.*;

//1971. Find if Path Exists in Graph


public class ValidPath {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath_Adjacency_List(n, edges, source, destination));
    }

    //Adjacency Matrix
    //Time Complexity is O(V^2)
    //Space Complexity is O(V^2) O(V)
    static public boolean validPath_Adjacency_Matrix(int n, int[][] edges, int source, int destination) {
        boolean[][] graph = new boolean[n][n]; //by default its false
        for (int[] edge : edges) { //mark the neighbors by its edges
            int u = edge[0];
            int v = edge[1];

            //mark either side also since its a bidirectional graph
            graph[u][v] = true;
            graph[v][u] = true;
        }
        boolean[] visited = new boolean[n];  // visited array
        return dfs_Adj_Matrix(graph, source, destination, visited, n);
    }

    //Adjacency Matrix DFS
    static private boolean dfs_Adj_Matrix(boolean[][] graph, int source, int destination, boolean[] visited, int n) {
        if (source == destination)
            return true; //Mark current source node as visited
        visited[source] = true;  //before traversing mark the source as visited

        //Iterate through all the nodes in the graph
        for (int i = 0; i < n; i++) {

            //If there is a edge from current source to i and node i is not visited
            if (graph[source][i] == true && !visited[i]) {
                //Recursively call node i as the source
                if (dfs_Adj_Matrix(graph, i, destination, visited, n))
                    return true; //If a path is found from i to destination, return true
            }
        }
        // No path found from source to destination
        return false;
    }


    //Adjacency Matrix BFS
    static private boolean bfs_Adj_Matrix(boolean[][] graph, int source, int destination, boolean[] visited, int n) {
        Queue<Integer> q = new LinkedList<>();  //Create a queue
        q.add(source); //First add the source in to queue
        while (!q.isEmpty()) {
            int current = q.remove(); //remove the front element
            if (current == destination)  //if current front is the destination return true
                return true;
            //Iterate through all Node
            for (int i = 0; i < n; i++) {
                if (graph[current][i] == true && !visited[i]) {
                    q.add(i);  //add the node i and mark it as visited
                    visited[i] = true;

                }
            }
        }

        return false;
    }


    //Adjacency List
    //Time Complexity is O(V+2E)
    //Space Complexity is O(V+2E) O(v) O(V)
    static public boolean validPath_Adjacency_List(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, value -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, value -> new ArrayList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        return bfs_Adj_List(graph, source, destination, visited, n);
    }


    //Adjacency lIST DFS
    static private boolean dfs_Adj_List(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited, int n) {
        if (source == destination)
            return true; //Mark current source node as visited
        visited[source] = true;  //before traversing mark the source as visited

        //check the source index node and traverse its neighbors find if destination its a neighbor or not
        for (int neighbor : graph.get(source)) {
            if (!visited[neighbor])
                if (dfs_Adj_List(graph, neighbor, destination, visited, n))
                    return true;
        }
        // No path found from source to destination
        return false;
    }


    //Adjacency lIST BFS
    static private boolean bfs_Adj_List(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited, int n) {

        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int current=q.remove();
            if(current==destination) return true;
            for(int neighbor:graph.get(current)){
                if(!visited[neighbor]){
                    q.add(neighbor);
                    visited[neighbor]=true;
                }
            }
        }
        return false;
    }

}
