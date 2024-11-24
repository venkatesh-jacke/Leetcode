package Arrays.Matrix;


import java.util.Arrays;

public class RotateTheBox {

    static char STONE = '#';
    static char WALL = '*';
    static char EMPTY = '.';

    public static void main(String[] args) {
        char[][] grid = {
                {'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}
        };
        System.out.println(Arrays.deepToString(rotateTheBox(grid)));
    }

    static public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        // Create the transpose of the input grid in `ans`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = box[j][i];
            }
        }

        // reverse the transpose for 90 degree
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                char temp = ans[i][j];
                ans[i][j] = ans[i][m - 1 - j];
                ans[i][m - 1 - j] = temp;
            }
        }
        //iterate all the column to row
        for (int j = 0; j < m; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (ans[i][j] == EMPTY) {
                    int nextRowStone = -1;
                    for (int k = i; k >= 0; k--) {
                        if (ans[k][j] == WALL)
                            break; // Stop if a wall is encountered
                        if (ans[k][j] == STONE) {
                            nextRowStone = k; //record the stone position in row
                            break;
                        }
                    }
                    // Swap the positions of the stone and empty cell, if a stone was found
                    if (nextRowStone != -1) {
                        ans[nextRowStone][j] = EMPTY;
                        ans[i][j] = STONE;
                    }
                }
            }
        }
        return ans;
    }

    static public char[][] rotateTheBox2(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        //Move all stones to right
        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            // Traverse the current row from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == WALL) {
                    empty = j - 1;
                } else if (box[i][j] == STONE) {
                    box[i][j] = EMPTY;
                    box[i][empty] = STONE;
                    empty--;
                }
            }
        }

        //rotate 90 degree clockWise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - 1 - i] = box[i][j];
            }
        }
        return ans;
    }

    static   public char[][] rotateTheBox3(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] ans = new char[n][m];

        for (char[] c : ans) {
            Arrays.fill(c, '.');  // Set all cells to EMPTY
        }
        for (int i = 0; i < m; i++) {
            int empty = n - 1;
            // Traverse the current row from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == STONE) {
                    ans[empty][m - 1 - i] = STONE;
                    empty--;
                }
                if (box[i][j] == WALL) {
                    ans[j][m - 1 - i] = WALL;
                    empty = j - 1;
                }
            }
        }
        return ans;
    }
}
