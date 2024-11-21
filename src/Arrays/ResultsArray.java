package Arrays;

import java.util.Arrays;


//3254. Find the Power of K-Size Subarrays I
public class ResultsArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 5};
        int k = 3;
        System.out.println(Arrays.toString(resultsArray(arr, k)));
    }

    static public int[] resultsArray1(int[] arr, int k)  {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = arr[i];
            boolean isConsecutive = true;
            for (int j = i; j < i + (k - 1); j++) {
                if (arr[j + 1] - arr[j] != 1) {
                    isConsecutive = false;
                    break;
                }
                max = arr[j + 1];
            }
            ans[i] = isConsecutive ? max : -1;
        }
        return ans;
    }
    static  public int[] resultsArray(int[] arr, int k) {
        if (k == 1)
            return arr;
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        int cons = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                cons++;
            } else {
                cons = 1;
            }
            if(cons>=k){
                System.out.println(i-k+2);
                ans[i-k+2]=arr[i+1];
            }
        }
        return ans;
    }
}
