package Graph;


import java.util.*;

//1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class FindTheCity {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    static public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(src, v -> new ArrayList<>()).add(new int[]{dest, weight});
            graph.computeIfAbsent(dest, v -> new ArrayList<>()).add(new int[]{src, weight});
        }
        int res = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = dijkstra(i, graph, distanceThreshold);
            if (count <= minCount) {
                res = i;
                minCount = count;
            }
        }
        return res;
    }

    private static int dijkstra(int src, Map<Integer, List<int[]>> graph, int distanceThreshold) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // {dis,node}
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new int[]{0, src});


        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (int[] neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currentDist + weight;

                if (newDist <= distanceThreshold && !visited.contains(nextNode)) {
                    minHeap.offer(new int[]{newDist, nextNode});
                }
            }
        }
        return visited.size() - 1; // exclude the source node itself
    }


}
