package Math;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 9973;
        System.out.println(maximumSwap(num));
    }

    static public int maximumSwap(int num) {

        char nums[] = Integer.toString(num).toCharArray();
        int n = nums.length;
        int maxIndex = nums.length - 1, swap1 = -1, swap2 = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] >= nums[maxIndex]) {
                maxIndex = i;
            } else if (nums[i] < nums[maxIndex]) {
                swap1 = maxIndex; // stores biggest number Index
                swap2 = i;// stores smallest number Index
            }
        }

        if (swap1 != -1) {
            char temp = nums[swap1];
            nums[swap1] = nums[swap2];
            nums[swap2] = temp;
        }
        return Integer.parseInt(new String(nums));
    }
}
