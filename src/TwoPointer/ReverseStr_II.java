package TwoPointer;

//541. Reverse String II

public class ReverseStr_II {
    public static void main(String[] args) {
        String s = "a";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    static public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();

        for (int start = 0; start < s.length(); start += 2*k) {
            reverse(ca, start, Math.min(s.length(), start + k-1));
        }
        return new String(ca);
    }

    static public void reverse(char[] ca, int i, int j) {
        int start = i, end = j;
        while (start < end) {
            char temp = ca[start];
            ca[start] = ca[end];
            ca[end] = temp;
            start++;
            end--;
        }
    }
}
