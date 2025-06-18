package TwoPointer;


//125. Valid Palindrome

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    static public boolean isPalindrome(String s) {
        {
            s = s.toLowerCase();
            int i = 0, j = s.length() - 1;
            while (i < j) {
                while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                    i++;
                }
                while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                    j--;
                }
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
    }
}
