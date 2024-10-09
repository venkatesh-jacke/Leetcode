package Strings;

public class RemoveStars {
    public static void main(String[] args) {
        String str = "leet**cod*e";
        System.out.println(removeStars(str));
    }

    static public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
