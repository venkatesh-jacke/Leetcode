package Contests.Weekly392;

public class GetSmallestString {
    public static void main(String[] args) {
        String s = "xaxcd";
        int k = 4;
        System.out.println(getSmallestString(s, k));
    }

    static public String getSmallestString(String s, int k) {
        char[] ca = s.toCharArray();
        int n = ca.length;

        for (int i = 0; i < n; i++) {
            int distance = ca[i] - 'a';
            int minDistance = Math.min(distance, 26 - distance);

            if (k > 0) {
                if (minDistance <= k) {
                    ca[i] = 'a';
                } else {
                    ca[i] = (char) (ca[i] - k);
                }
                k -= minDistance;
            }
        }
        return new String(ca);
    }
}
