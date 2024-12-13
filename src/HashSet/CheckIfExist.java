package HashSet;

import java.util.HashSet;

public class CheckIfExist {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        System.out.println(checkIfExist(arr));
    }

    static public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(i * 2) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }
}
