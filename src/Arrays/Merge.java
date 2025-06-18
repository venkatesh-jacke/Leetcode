package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

//56. Merge Intervals
public class Merge {
    public static void main(String[] args) {

    }
    static  public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        ArrayList<int[]> list= new ArrayList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] cur=intervals[i];
            int[] last=list.get(list.size()-1);
            if(last[1]>= cur[0]){
                last[1]=Math.max(last[1],cur[1]);
            }
            else{
                list.add(cur);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
