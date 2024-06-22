package Contests.Weekly392;

import java.util.Arrays;

public class MinOperationToMakeMedianK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 4;
        System.out.println(minOperationsToMakeMedianK(arr, k));
    }

    static  public long minOperationsToMakeMedianK(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        long count=0;

        for(int i=0;i<n;i++){
            if(i<n/2){
                count+=(long) Math.max(0,arr[i]-k);
            }
            else if (i==n/2){
                count+=(long) Math.abs(k - arr[i]);
            }
            else{
                count+=(long) Math.max(0,k-arr[i]);
            }
        }
        return count;
    }
}
