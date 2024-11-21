package SlidingWindow;

import java.util.Arrays;

public class Decrypt {
    public static void main(String[] args) {
        int arr[]={5,7,1,4};
        int k=3;
        System.out.println(Arrays.toString(decrypt(arr, k)));
    }
    static public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0)
            return res;

        int start=1,end=k;
        if(k<0){
            start=n-Math.abs(k);
            end=n-1;
        }
        int sum=0;
        for(int i=start;i<=end;i++) sum+=code[i];
        for(int i=0;i<n;i++){
            res[i]=sum;
            sum-=code[start%n];
            sum+=code[(end+1)%n];
            start++;
            end++;

        }
        return res;
    }
}
