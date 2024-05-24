package Recursion;

import java.util.ArrayList;
import java.util.List;


//131. Palindrome Partitioning

public class PalindromePartition {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    static public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        palindromePartition(s, 0, new ArrayList<>(), res);
        return res;

    }

    static public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    static public void palindromePartition(String s, int start, List<String> temp, List<List<String>> res) {
        System.out.println("funStart("+start+","+temp+","+"res"+")");
        if (start == s.length()) {
            System.out.println("Adding in res "+temp);
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            System.out.println("End is "+end);
            if (isPalindrome(s, start, end)) {
                System.out.println("Adding "+s.substring(start, end + 1));
                temp.add(s.substring(start, end + 1));
                palindromePartition(s, end + 1, temp, res);
                System.out.println("From end "+end+" removing "+temp.get(temp.size() - 1)+" temp is "+temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}