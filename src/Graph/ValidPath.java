package Graph;

import java.util.*;

//1971. Find if Path Exists in Graph
public class ValidPath {
    public static void main(String[] args) {
        int n=3;
        int[][] edges={{0,1},{1,2},{2,0}};
        int source=0;
        int destination=2;
        System.out.println(validPath(n,edges,source,destination));
    }
    static private boolean dfs(boolean[][] graph, int source, int destination, boolean[] visited, int n) {
        if (source == destination)
            return true; //Mark current source node as visited
        visited[source] = true;  //before traversing mark the source as visited

        //Iterate through all the nodes in the graph
        for (int i = 0; i < n; i++) {

            //If there is a edge from current source to i and node i is not visited
            if (graph[source][i] == true && !visited[i]) {
                //Recursively call node i as the source
                if (dfs(graph, i, destination, visited, n))
                    return true; //If a path is found from i to destination, return true
            }
        }
        // No path found from source to destination
        return false;
    }

    static public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] graph = new boolean[n][n]; //by default its false
        for (int[] edge : edges) { //mark the neighbors by its edges
            int u = edge[0];
            int v = edge[1];

            //mark either side also since its a bidirectional graph
            graph[u][v] = true;
            graph[v][u] = true;
        }
        boolean[] visited=new boolean[n];  // visited array
        boolean ans=dfs(graph,source,destination,visited,n);  //dfs helper function
        return ans;
    }
}
