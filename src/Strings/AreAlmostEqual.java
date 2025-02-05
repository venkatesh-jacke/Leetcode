package Strings;


//1790. Check if One String Swap Can Make Strings Equal

public class AreAlmostEqual {
    public static void main(String[] args) {
        String s1 = "bf";
        String s2 = "dd";
        System.out.println(areAlmostEqual(s1, s2));
    }

    static public boolean areAlmostEqual(String s1, String s2) {
        int firstDiffIndex = 0, secondDiffIndex = 0, diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) return false;
                else if (diff == 1) {
                    firstDiffIndex = i;
                } else {
                    secondDiffIndex = i;
                }
            }
        }
        return (s1.charAt(firstDiffIndex) == s2.charAt(secondDiffIndex) &&
                s1.charAt(secondDiffIndex) == s2.charAt(firstDiffIndex));
    }
}
