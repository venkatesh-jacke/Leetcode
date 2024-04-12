package HashTable;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        //System.out.println(Arrays.toString(topKFrequent(arr, k)));
        System.out.println(Arrays.toString(topKFrequent2(arr, k)));
    }


    //BruteForce
    static public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> sortedSet = new HashSet<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) sortedSet.add(i);
        List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int c = 0;
        List<Integer> topKFrequent = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedEntries) {
            if (c >= k) {
                break;
            }
            topKFrequent.add(entry.getKey());
            c++;
        }

        int[] result = new int[topKFrequent.size()];
        for (int i = 0; i < topKFrequent.size(); i++) {
            result[i] = topKFrequent.get(i);
        }
        return result;
    }

    static public int[] topKFrequent2(int[] nums, int k) {
        List<Integer>[] frequencyArray = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (frequencyArray[freq] == null) {
                frequencyArray[freq] = new ArrayList<>();
            }
            frequencyArray[freq].add(key);
        }
        int res[] = new int[k];
        int count = 0;
        for (int i = frequencyArray.length - 1; i > 0 && count < k; i--) {
            if (frequencyArray[i] != null) {
                for (int v : frequencyArray[i]) {
                    res[count++] = v;
                }
            }
        }
        return res;
    }

}
