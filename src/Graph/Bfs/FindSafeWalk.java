package Graph.Bfs;

//3286. Find a Safe Walk Through a Grid

//BFS solution tracked remaining health.
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindSafeWalk {

    static final int[][] dir = {
            {-1, 0}, // Up
            {0, 1},  // Right
            {1, 0},  // Down
            {0, -1}  // Left
    };

    static class Node {
        int x;
        int y;
        int health;

        public Node(int x, int y, int health) {
            this.x = x;
            this.y = y;
            this.health = health;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 0, 1),
                Arrays.asList(1, 1, 1)
        );
        int health = 1;
        System.out.println(findSafeWalk(grid, health));
    }

    static public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] vis = new int[m][n];
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            Arrays.fill(vis[i], -1);
        }
        queue.offer(new Node(0, 0, grid.get(0).get(0) == 0 ? health : health - 1));
        vis[0][0] = grid.get(0).get(0) == 0 ? health : health - 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.x == m - 1 && cur.y == n - 1 && cur.health >= 1) return true;
            for (int i = 0; i < dir.length; i++) {
                int newX = cur.x+dir[i][0];
                int newY = cur.y+dir[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newHealth = cur.health - grid.get(newX).get(newY);
                    if (newHealth > 0 && newHealth > vis[newX][newY]) {
                        vis[newX][newY] = newHealth;
                        queue.offer(new Node(newX, newY, newHealth));
                    }
                }
            }
        }
        return false;
    }
}
