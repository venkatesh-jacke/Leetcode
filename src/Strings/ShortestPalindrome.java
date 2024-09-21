package Strings;


//214. Shortest Palindrome
public class ShortestPalindrome {
    public static void main(String[] args) {
        String str = "aacecaaa";
        String str2 = "abcd";
        System.out.println(shortestPalindrome(str2));

    }

    static public String shortestPalindrome(String s) {
        int len = s.length();
        String revStr = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < len; i++) {
            String prefix = s.substring(0, len - i);
            String suffix = revStr.substring(i);
            System.out.println("prefix=" + prefix + " " + "suffix=" + suffix);

            if (prefix.equals(suffix)) {
                return new StringBuilder(revStr.substring(0, i)).append(s).toString();
            }
        }
        return "";
    }

}
