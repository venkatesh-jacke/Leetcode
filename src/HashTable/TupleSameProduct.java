package HashTable;

import java.util.HashMap;

//1726. Tuple with Same Product

public class TupleSameProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 10};
        System.out.println(tupleSameProduct(nums));
    }

    static public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int tuples = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                tuples += 8 * (map.getOrDefault(product, 0));
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }

        return tuples;
    }
}
