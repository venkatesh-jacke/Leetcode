package TwoPointer;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    static public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i< words.length;i++) {
            sb.append(reverse(words[i]));
           if(i!= words.length-1) sb.append(" ");
        }
        return sb.toString();

    }

        static public String reverse(String word) {
            int i = 0, j = word.length() - 1;
            char[] ca = word.toCharArray();
            while (i < j) {
                char temp = ca[i];
                ca[i] = ca[j];
                ca[j] = temp;
                i++;
                j--;
            }
            return new String(ca);
        }
}
