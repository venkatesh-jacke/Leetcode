package TwoPointer;


//2348. Number of Zero-Filled Subarrays
public class ZeroFilledSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(zeroFilledSubarray(arr));
    }

    static public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            while (i < n && nums[i] == 0) {
                count += 1;
                res += count;
                i++;
            }

        }
        return res;
    }

    static public long zeroFilledSubarray2(int[] nums) {
        int n = nums.length;
        long res = 0, count = 0;
        for (int i : nums) {
            if (i == 0) {
                count += 1;
            } else {
                count = 0;
            }
            res += count;
        }
        return res;
    }

    static public long zeroFilledSubarray3(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] != 0) {
                j = i + 1;
            }
            res += i - j + 1;
        }
        return res;
    }
}
