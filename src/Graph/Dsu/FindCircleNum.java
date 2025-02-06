package Graph.Dsu;

//547. Number of Provinces
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] edges = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(edges));
    }

    static public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Dsu dsu = new Dsu(n);
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //if they are  connected and belong to different components than we need to union them and make s single component
                if (isConnected[i][j] == 1 && dsu.find(i) != dsu.find(j)) {
                    dsu.union(i, j);
                    count--;
                }
            }
        }
        return count;
    }

    static private class Dsu {
        int[] root;
        int[] rank;
        int size;

        Dsu(int size) {
            this.size = size;
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (root[x] == x) return x;
            return root[x] = find(root[x]);
        }

        void union(int x, int y) {
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
            }
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
