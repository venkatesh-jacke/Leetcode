package HashTable;

import java.util.HashMap;

public class EqualPairs {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        System.out.println(equalPairs(grid));
    }
    static  public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        HashMap<String, Integer> rows = new HashMap<>();
        HashMap<String, Integer> cols = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder r = new StringBuilder();
            StringBuilder c = new StringBuilder();
            for (int j = 0; j < n; j++) {
                r.append(grid[i][j]);
                c.append(grid[j][i]);
            }
            rows.put(r.toString(), rows.getOrDefault(r.toString(), 0) + 1);
            cols.put(c.toString(), cols.getOrDefault(c.toString(), 0) + 1);

        }
        System.out.println(rows);
        System.out.println(cols);
        for (String s : rows.keySet()) {
            if (cols.containsKey(s)) {
                count += rows.get(s) * cols.get(s);
            }
        }
        return count;
    }
}
