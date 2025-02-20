package BackTracking;

//1980. Find Unique Binary String


import java.util.HashSet;

public class FindDifferentBinaryString {
    static HashSet<String> set;
    static String res;

    public static void main(String[] args) {
        String[] nums = {"111", "011", "001" };
        System.out.println(findDifferentBinaryString(nums));
    }

    static public String findDifferentBinaryString(String[] nums) {
        res = null;
        set = new HashSet<>();
        int n = nums.length;

        for (String s : nums) {
            set.add(s);
        }
        backTrack(n, new StringBuilder());
        return res;
    }

    static public void backTrack(int n, StringBuilder cur) {
        // if (res != null)
        //     return;
        if (cur.length() == n) {
            if (!set.contains(cur.toString())) {
                res = cur.toString();
                return;
            }
            return;
        }
        for (char ch : new char[]{'0', '1'}) {
            cur.append(ch);
            backTrack(n, cur);
            // if (res != null)
            //     return;
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}