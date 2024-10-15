package TwoPointer;


//2938. Separate Black and White Balls
public class MinimumSteps {
    public static void main(String[] args) {
        String s = "101";
        System.out.println(minimumSteps(s));
    }

    static public long minimumSteps(String s) {
        long minSteps = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '0') {
                minSteps += (r - l);
                l += 1;
            }
        }
        return minSteps;
    }
}
