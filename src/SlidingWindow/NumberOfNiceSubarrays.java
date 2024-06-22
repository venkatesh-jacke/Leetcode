package SlidingWindow;

//1248. Count Number of Nice Subarrays
public class NumberOfNiceSubarrays {
    public static void main(String[] args) {

    }

    static int numberOfSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    static int atMost(int[] arr, int k) {
        int windowSum = 0, n = arr.length, left = 0, subArrays = 0;

        for (int right = 0; right < n; right++) {
            windowSum += arr[right]%2;
            while (windowSum > k) {
                windowSum -= arr[left]%2;
                left++;
            }
            subArrays += right - left + 1;
        }
        return subArrays;
    }
}

/*
No of SubArrays equal to k => No of SubArrays <= k - No of SubArrays <k
*/
