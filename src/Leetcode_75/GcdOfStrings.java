package Leetcode_75;


//1071. Greatest Common Divisor of Strings
public class GcdOfStrings {
    public static void main(String[] args) {

    }

   static public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int idx = Math.min(len1, len2); idx >= 1; idx--) {
            if (isValidGcd(str1, str2, idx)) {
                return str1.substring(0, idx);
            }
        }
        return "";
    }

    static  public boolean isValidGcd(String str1, String str2, int idx) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % idx != 0 || len2 % idx != 0)
            return false;
        String gcd = str1.substring(0, idx);
        return str1.replace(gcd, "").isEmpty() && str2.replace(gcd, "").isEmpty();
    }
}
