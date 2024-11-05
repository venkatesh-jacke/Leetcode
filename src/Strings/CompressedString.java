package Strings;

public class CompressedString {
    public static void main(String[] args) {
        String word = "aaaaaaaaaaaaaabb";
        System.out.println(compressedString(word));
    }

    static public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        int i = 0;
        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;
            while (i < n && count < 9 && word.charAt(i) == currentChar) {
                i++;
                count++;

            }
            sb.append(count).append(currentChar);
        }
        return sb.toString();
    }
}
