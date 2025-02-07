package Graph.Dsu;

public class Dsu {
    int size;
    int[] root;
    int[] rank;

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

    boolean isConnected(int x, int y) {
        return find(x) == find(y);
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

}
