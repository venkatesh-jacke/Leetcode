package Graph.Bfs;


//1267. Count Servers that Communicate

public class CountServers {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(countServers(grid));
    }

    static  public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}

/*
We don’t need to check the entire row and column every time for every server. Instead,
we can track the number of servers in each row and column using two arrays: rowCounts and colCounts.
Once we have the counts of servers in each row and column,
the next task is to identify which servers are communicable. For a server at position (row, col),

we need to check:
If the row has more than one server (i.e., rowCounts[row] > 1), which means there are other servers in the same row.
If the column has more than one server (i.e., colCounts[col] > 1), which means there are other servers in the same column.
If either condition is true, the server can communicate, and we increment the count of communicable servers.
 */
