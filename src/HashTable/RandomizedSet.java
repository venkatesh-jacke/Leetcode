package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    public static void main(String[] args) {

        MyRandomizedSet randomizedSet = new MyRandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Insert 1
        System.out.println(randomizedSet.remove(2)); // Remove 2 (not present)
        System.out.println(randomizedSet.insert(2)); // Insert 2
        System.out.println(randomizedSet.getRandom()); // Get random element
        System.out.println(randomizedSet.remove(1)); // Remove 1
        System.out.println(randomizedSet.insert(2)); // Insert 2 again
        System.out.println(randomizedSet.getRandom()); // Get random element
    }

    static class MyRandomizedSet {
        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public MyRandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(list.size(), val);
            return true;

        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int ind = map.get(val);
            int lastIndex = list.size() - 1;
            int lastElement = list.get(lastIndex);
            list.set(ind, lastElement);// dont use add it will add new element but set will update the value in current index
            list.remove(lastIndex);
            map.put(lastElement, ind);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
