package TwoPointer;

//1004. Max Consecutive Ones III
public class LongestOnes {
    public static void main(String[] args) {
        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr,2));
    }
    static  public int longestOnes(int[] nums, int k){
        int ans = 0, zeroes = 0, n = nums.length, left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) zeroes += 1;
            while (zeroes > k) {  //if also works because we are extend
                if (nums[left] == 0) zeroes -= 1;
                left += 1;
            }
            ans = Math.max(ans, (right-left+1));
        }

        return ans;
    }
}
/*
The problem boils down to finding the longest subarray
that contains at most k zeros (since we can flip them to ones).
*/