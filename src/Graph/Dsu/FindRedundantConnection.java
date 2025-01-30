package Graph.Dsu;

import java.util.Arrays;

//684. Redundant Connection

public class FindRedundantConnection {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    static public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Dsu dsu = new Dsu(n);
        for (int[] edge : edges) {
            // If union returns false, we know the nodes are already connected
            // and hence we can return this edge.
            if (!dsu.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return new int[]{};
    }

    static class Dsu {
        int size;
        int[] root;
        int[] rank;

        Dsu(int size) {
            this.size = size;
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = i;
            }
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX]++;
                }
                return true;
            }
            return false;
        }

        int find(int x) {
            if (root[x] == x)
                return x;
            return find(root[x]);
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
