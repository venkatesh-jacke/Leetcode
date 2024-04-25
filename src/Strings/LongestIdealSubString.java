package Strings;


//2370. Longest Ideal Subsequence

public class LongestIdealSubString {
    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString(s, k));
    }

    static public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int element = s.charAt(i) - 'a';
            //left limit
            for (int j = element; j >= 0 && j >= element - k; j--) {

                dp[element] = Math.max(dp[element], dp[j]+1);
            }

            //right limit
            for (int j = element + 1; j < 26 && j <= element + k; j++) {
                dp[element] = Math.max(dp[element],  dp[j]+1);
            }
            ans = Math.max(ans, dp[element]);
        }
        return ans;
    }

}

/*
s = "acfgbd"
element = a
abc (chk if result of 'b' 'c' and choose the maximum one ana add 1 (taking the current element 'a')

element = c
abcde (chk if result of 'a''b'd'e' and choose the maximum one ana add 1 (taking the current element 'c')

element = f
defgh (chk if result of 'd''e'g'h' and choose the maximum one ana add 1 (taking the current element 'f')

element = g
efghi (chk if result of 'e''f'h'i' and choose the maximum one ana add 1 (taking the current element 'g')

element = b
abcd (chk if result of 'a''c'd and choose the maximum one ana add 1 (taking the current element 'b')

element = d
bcdef (chk if result of 'b''c'e'f' and choose the maximum one ana add 1 (taking the current element 'd')


Intuition

Just chk the k elements before and k elements after the given character (if it exists in the given string)


*/
