package Trees.Bfs;

//3568. Minimum Moves to Clean the Classroom

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinMoves {
    static class State {
        int r;
        int c;
        int energy;
        int mask;

        State(int r, int c, int energy, int mask) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.mask = mask;
        }
    }

    public static void main(String[] args) {
        String[] classroom = {"LS", "RL"};
        int energy = 4;
        System.out.println(minMoves(classroom, energy));
    }

    static public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int startR = -1;
        int startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }
                if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        //System.out.println(Arrays.deepToString(litterId));
        int allCollected = (1 << litterCount) - 1;
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(startR, startC, energy, 0));
        visited[startR][startC][energy][0] = true;
        int moves = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                if (current.mask == allCollected) {
                    return moves;
                }
                for (int[] dir : directions) {
                    int nr = current.r + dir[0];
                    int nc = current.c + dir[1];
                    // Outside the grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    // Cannot walk through obstacle.
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }
                    // Every movement costs 1 energy.
                    int newEnergy = current.energy - 1;
                    if (current.energy == 0) {
                        continue;
                    }
                    // R gives us full energy.
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }
                    int newMask = current.mask;
                    // If this cell contains litter, collect it.
                    if (litterId[nr][nc] != -1) {
                        newMask = newMask | (1 << litterId[nr][nc]);
                    }
                    // Have we already visited this exact state?
                    if (visited[nr][nc][newEnergy][newMask]) {
                        continue;
                    }
                    visited[nr][nc][newEnergy][newMask] = true;
                    queue.offer(new State(nr, nc, newEnergy, newMask));
                }
            }
            moves++;
        }
        return -1;

    }
}
