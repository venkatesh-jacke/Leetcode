package Strings;

import java.util.Arrays;

//1422. Maximum Score After Splitting a String
public class MaxScore {
    public static void main(String[] args) {
        String s = "00111";
        System.out.println(maxScore_prefix(s));
    }

    static public int maxScore_brute(String s) {
        int maxScore = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int cur = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == '0') {
                    cur++;
                }
            }
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    cur++;
                }
            }
            maxScore = Math.max(maxScore, cur);
        }
        return maxScore;
    }

    static public int maxScore(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }


    public int maxScore_singlePass(String s) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
            maxScore = Math.max(maxScore, zeros - ones);
        }
        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return maxScore + ones;
    }
    static public int maxScore_prefix(String s) {
        int n = s.length();
        int maxScore = 0;
        int[] prefixZeros = new int[n];
        int[] prefixOnes = new int[n];
        int zeroCount = 0, oneCount = 0;

        for (int i = 0; i < n; i++) {
            zeroCount += (s.charAt(i) == '0' ? 1 : 0);
            prefixZeros[i] = zeroCount;

            oneCount += (s.charAt(n - 1 - i) == '1' ? 1 : 0);
            prefixOnes[n - i - 1] = oneCount;
        }
        for (int i = 0; i < n - 1; i++) {
            maxScore = Math.max(maxScore, prefixZeros[i] + prefixOnes[i + 1]);
        }
        return maxScore;

    }
}
