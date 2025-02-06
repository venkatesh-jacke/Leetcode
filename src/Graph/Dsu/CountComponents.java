package Graph.Dsu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//323. Number of Connected Components in an Undirected Graph
public class CountComponents {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }

    static public int countComponents(int n, int[][] edges) {
        int components = n;
        Dsu dsu= new Dsu(n);
        for(int[] edge:edges){
            if(dsu.union(edge[0],edge[1])){
                components--;
            }
        }
        return components;
    }


}
