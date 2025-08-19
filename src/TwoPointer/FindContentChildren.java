package TwoPointer;

import java.util.Arrays;

//455. Assign Cookies
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    static public int findContentChildren(int[] g, int[] s) {
        int i = 0, j = 0, count = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
