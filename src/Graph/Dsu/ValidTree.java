package Graph.Dsu;

import java.util.ArrayList;
import java.util.List;

//261. Graph Valid Tree
public class ValidTree {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        System.out.println(validTree(n, edges));
    }

    static public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // N nodes must have only N-1 edges
        Dsu dsu = new Dsu(n);
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                continue;
            }
            return false; //cycle
        }
        return true;
    }


}
