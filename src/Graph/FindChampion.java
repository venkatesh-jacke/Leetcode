package Graph;


import java.util.HashSet;
import java.util.Set;

//2924. Find Champion II
public class FindChampion {
    public static void main(String[] args) {
    int n=2;
    int[][] edges={{1,0}};
        System.out.println(findChampion(n,edges));
    }
    static  public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            indegree[edge[1]]++; // store the in-degree of all nodes
        }
        int champ = -1;
        int count = 0;
        for (int i=0;i<n;i++) {
            if (indegree[i] == 0) {
                count++;
                champ = i;
            }
        }
        return count > 1 ? -1 : champ;
    }
    static public int findChampion2(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i < n; i++)
            set.add(i); // Add all nodes to the set
        // Remove nodes that are destinations of edges
        for (int[] edge : edges) {
            set.remove(edge[1]);
        }
        // If only one node is left in the set, return it as the champion
        return set.size() == 1 ? set.iterator().next() : -1;

    }
}
