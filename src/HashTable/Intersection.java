package HashTable;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        int[][] nums = {
                {3, 1, 2, 4, 5},
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };
        System.out.println(intersection(nums));
    }

    static public List<Integer> intersection(int[][] nums) {
        int[] arr= new int[1001];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                int v = nums[i][j];
                arr[v]++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<1001;i++){
            if(arr[i]==nums.length){
                res.add(i);
            }
        }

        return res;
    }
}
