package Strings;

public class CountSeniors {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(countSeniors(details));
    }

    static public int countSeniors(String[] details) {
        int ans = 0;
        for (String s : details) {
            int age = Integer.parseInt(s.substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }
}
