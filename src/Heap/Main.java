package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                pq.add(new int[]{arr[i],arr[j]});
            }
        }

        while(!pq.isEmpty()){
            System.out.println(Arrays.toString(pq.poll()));
        }
    }
}
