package BitManipulation;


//2275. Largest Combination With Bitwise AND Greater Than Zero
public class LargestCombination {
    public static void main(String[] args) {
        int[] arr = {16, 17, 71, 62, 12, 24, 14};
        System.out.println(largestCombination(arr));
    }

    static public int largestCombination(int[] arr) {
        int max_count = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }
}
