package Strings;

//3499. Maximize Active Section with Trade I

//Which 1-block should I remove so that I create the biggest zero block?
public class MaxActiveSectionsAfterTrade {
    public static void main(String[] args) {
        String s = "100";
        System.out.println(maxActiveSectionsAfterTrade(s));
    }

    static public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0; // Count of existing active sections ('1')
        int prevZeroGroup = Integer.MIN_VALUE;
        int maxMergedZeros = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            int j = i;
            // Find the current consecutive block
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            int len = j - i;
            if (s.charAt(i) == '1') {
                // Count all existing 1's
                ones += len;
            } else {
                // Merge this zero block with the previous zero block (by removing the 1-block between them)
                maxMergedZeros = Math.max(maxMergedZeros, prevZeroGroup + len);
                //Store current zero block for the next iteration
                prevZeroGroup = len;
            }
            i = j;
        }
        return maxMergedZeros + ones;
    }
}
