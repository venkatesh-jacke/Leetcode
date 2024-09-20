package Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class KthDistinct {
    public static void main(String[] args) {
        String[] arr = {"a","b","a"};
        int k = 3;
        System.out.println(kthDistinct(arr, k));
    }

    static public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) {
                k--;
            }
            if (k == 0) return entry.getKey();
        }
        return "";
    }
}
