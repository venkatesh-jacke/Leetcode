package TwoPointer;

//904. Fruit Into Baskets

import java.util.HashMap;

public class TotalFruit {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        System.out.println(totalFruit(arr));
    }

    static public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalFruit = 0;
        for (int l = 0, r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                if (map.get(fruits[l]) == 0)
                    map.remove(fruits[l]);
                l++;
            }
            totalFruit = Math.max(totalFruit, r - l + 1);
        }
        return totalFruit;
    }
}
