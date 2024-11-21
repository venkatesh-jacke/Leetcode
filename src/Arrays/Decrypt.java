package Arrays;

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

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum of next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular array
                }
            } else {
                // Sum of previous |k| elements
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Circular array
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
