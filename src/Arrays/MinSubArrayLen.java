package Arrays;


//209. Minimum Size Subarray Sum
public class MinSubArrayLen {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,1,2,4,3};
        int k = 7;
        System.out.println(minSubArrayLen(k,arr));
    }

    //Time Complexity O(n)
    //Space Complexity O(1)
    static  public int minSubArrayLen(int k, int[] arr) {
        int n=arr.length;
        int cur_sum=0;
        int start=0;
        int end=0;
        int min_len=n+1;
        while(end<n){
            while(cur_sum < k && end < n){
                cur_sum+=arr[end++];  //add elements until cur_sum greater than k
            }
            while(cur_sum >= k && start < n){
                if(end-start < min_len) min_len = end-start;
                cur_sum -= arr[start++];  //reduce the cur_sum from start pointer until cur_sum is lesser than equal to k
            }
        }
        return min_len!=n+1?min_len:0;  //if no subArray len return 0;
    }
}
