package DynmaicProgramming;


//2370. Longest Ideal Subsequence

import java.util.Arrays;
import java.util.HashMap;

public class LongestIdealSubString {
    static int[][] memo;

    public static void main(String[] args) {
        String s = "acfgbd";
        int k = 2;
        System.out.println(longestIdealString_Rec(s, k));
    }


    //DP
    static public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int element = s.charAt(i) - 'a';
            //left limit
            for (int j = element; j >= 0 && j >= element - k; j--) {

                dp[element] = Math.max(dp[element], dp[j] + 1);
            }

            //right limit
            for (int j = element + 1; j < 26 && j <= element + k; j++) {
                dp[element] = Math.max(dp[element], dp[j] + 1);
            }
            ans = Math.max(ans, dp[element]);
        }
        return ans;
    }


    //Recursion
    static public int longestIdealString_Rec(String s, int k) {
        memo = new int[s.length()][124];
        for(int[] i:memo)
            Arrays.fill(i,-1);
        return helperMemo(s, k, 0, '{');
    }

    static public int helperRec(String s, int k, int i, char prev) {
        if (i == s.length())
            return 0;
        int take = 0;
        if (prev == '{' || Math.abs(prev - s.charAt(i)) <= k) {
            take = 1 + helperRec(s, k, i + 1, s.charAt(i));
        }
        int notTake = helperRec(s, k, i + 1, prev);
        return Math.max(take, notTake);
    }


    //Memoization
    static public int helperMemo(String s, int k, int i, char prev) {
        if (i == s.length())
            return 0;
        if (memo[i][prev] != -1)
            return memo[i][prev];
        int take = 0;
        if (prev == '{' || Math.abs(prev - s.charAt(i)) <= k) {
            take = 1 + helperMemo(s, k, i + 1, s.charAt(i));
        }
        int notTake = helperMemo(s, k, i + 1, prev);
        return memo[i][prev] = Math.max(take, notTake);
    }


}


/*
s = "acfgbd"

a b c d e f g h i j k l m n o p q r s t u v w x y z
1 3 2 4 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0


element = a  0
abc (chk if result of 'b' 'c' and choose the maximum one and add 1 (taking the current element 'a')

element = c 2
abcde (chk if result of 'a''b'd'e' and choose the maximum one and add 1 (taking the current element 'c')

element = f
defgh (chk if result of 'd''e'g'h' and choose the maximum one and add 1 (taking the current element 'f')

element = g
efghi (chk if result of 'e''f'h'i' and choose the maximum one and add 1 (taking the current element 'g')

element = b
abcd (chk if result of 'a''c'd and choose the maximum one ana add 1 (taking the current element 'b')

element = d
bcdef (chk if result of 'b''c'e'f' and choose the maximum one and add 1 (taking the current element 'd')


Intuition

Just chk the k elements before and k elements after the given character (if it exists in the given string)


*/
