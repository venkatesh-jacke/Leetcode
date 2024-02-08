package Graph;
import java.util.*;


//1791. Find Center of Star Graph
public class FndCenter {
    public static void main(String[] args) {
        int[][] edges = {
                {10, 1}, {10, 2}, {3, 10}, {10, 4}, {5, 10},
                {10, 6}, {10, 7}, {8, 10}, {10, 9}, {10, 11},
                {12, 10}, {10, 13}, {14, 10}
        };
            System.out.println(findCenter(edges));

    }
    static  public int findCenter(int[][] edges) {

        Map<Integer,ArrayList<Integer>> graph= new HashMap<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph.computeIfAbsent(u,value->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,value->new ArrayList<>()).add(u);
        }
        for(Map.Entry<Integer,ArrayList<Integer>> k:graph.entrySet()){
            if(k.getValue().size()==graph.size()-1)
                return k.getKey();

        }
        return -1;
    }

    //Time Complexity is O(!)
    //Space Complexity is O(1)
    static  public int findCenter2(int[][] edges) {

        int x1=edges[0][0];
        int x2=edges[1][0];
        int y1=edges[0][1];
        int y2=edges[1][1];

        if(x1==x2 || x1==y2) return x1;
        else if(y1==x2||y1==y2) return y1;
        return -1;
    }

}
