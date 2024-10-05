
class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int p = 7;
        System.out.println(minSubarray(nums, p));
    }

    static  public int minSubarray(int[] nums, int p) {
        int N = nums.length;
        long totalSum = 0;
        int minLen = N;
        for (int i : nums)
            totalSum += i;
        if (totalSum % p == 0)
            return 0;
        for (int start = 0; start < N; start++) {
            long subSum = 0;
            for (int end = start; end < N; end++) {
                subSum += nums[end];
                long remainingSum = (totalSum-subSum) % p;
                if (remainingSum == 0) {
                    minLen = Math.min(minLen, end - start + 1);
                }
            }
        }
        return minLen == N ? 1 : minLen;
    }
}
