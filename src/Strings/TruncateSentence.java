package Strings;


//1816. Truncate Sentence
public class TruncateSentence {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }


    //Tc O(n) Sc O(1)

    static public String truncateSentence(String s, int k) {
        int index = 0;
        int count = 0;
        for (index = 0; index < s.length(); index++) {
            if (s.charAt(index) == ' ')
                count++;
            if (count == k)
                break;
        }
        return s.substring(0, index);
    }
}
