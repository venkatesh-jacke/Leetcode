package BackTracking;

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    static public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, 0, new ArrayList<Integer>(), res, 0, target);
        return res;

    }

    static public void backTrack(int[] arr, int i, List<Integer> cur, List<List<Integer>> res, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (total > target || i == arr.length) {
            return;
        }
        cur.add(arr[i]);
        backTrack(arr, i + 1, cur, res, total + arr[i], target);
        cur.remove(cur.size() - 1);

        while (i + 1 < arr.length && arr[i] == arr[i + 1]) i += 1;
        backTrack(arr, i + 1, cur, res, total, target);

    }
}
