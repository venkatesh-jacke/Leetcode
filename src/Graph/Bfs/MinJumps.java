package Graph.Bfs;

import java.util.*;

//1345. Jump Game IV

public class MinJumps {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    static public int minJumps(int[] arr) {

        int n = arr.length;

        // value -> all indices having that value
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // BFS queue
        Queue<Integer> q = new LinkedList<>();

        // visited indices
        boolean[] vis = new boolean[n];

        // start from index 0
        q.offer(0);
        vis[0] = true;

        // minimum jumps
        int steps = 0;

        while (!q.isEmpty()) {

            // process one BFS level
            int size = q.size();

            while (size-- > 0) {

                int currIdx = q.poll();

                // reached last index
                if (currIdx == n - 1)
                    return steps;

                // jump to left index
                if (currIdx - 1 >= 0 && !vis[currIdx - 1]) {
                    vis[currIdx - 1] = true;
                    q.offer(currIdx - 1);
                }

                // jump to right index
                if (currIdx + 1 < n && !vis[currIdx + 1]) {
                    vis[currIdx + 1] = true;
                    q.offer(currIdx + 1);
                }

                // jump to all same-value indices
                for (int newIdx : graph.get(arr[currIdx])) {

                    if (!vis[newIdx]) {
                        vis[newIdx] = true;
                        q.offer(newIdx);
                    }
                }

                // avoid revisiting same-value group again
                graph.get(arr[currIdx]).clear();
            }

            // one jump completed
            steps++;
        }

        return -1;
    }
}
