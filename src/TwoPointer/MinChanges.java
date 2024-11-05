package TwoPointer;

//2914. Minimum Number of Changes to Make Binary String Beautiful
public class MinChanges {
    public static void main(String[] args) {
        String s = "1001";
        System.out.println(minChanges(s));
    }

    static public int minChanges(String s) {
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(l) != s.charAt(r)) {
                if (r % 2 == 1) {
                    res++;
                }
                l = r;

            }
        }
        return res;
    }
}