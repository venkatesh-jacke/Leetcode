package Strings;


//2381. Shifting Letters II
public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(shiftingLetters(s, shifts));
    }

    static public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (int[] shift : shifts) {
            if (shift[2] == 0) {
                diff[shift[0]]--;
                diff[shift[1] + 1]++;
            } else {
                diff[shift[0]]++;
                diff[shift[1] + 1]--;
            }
        }

        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1];
        }

        char[] res = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int count = (diff[i] % 26 + 26) % 26;
            res[i] = (char) ((res[i] - 'a' + count) % 26 + 'a');
        }
        return new String(res);
    }
}
