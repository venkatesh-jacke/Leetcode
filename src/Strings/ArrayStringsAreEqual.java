package Strings;

public class ArrayStringsAreEqual {
    public static void main(String[] args) {
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }


    //Time is O(n)
    //Space is O(1)
    static public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (String i : word1) {
            s1.append(i);
        }
        for (String i : word2) {
            s2.append(i);
        }
        //return s1.toString().equals(s2.toString());
        return String.join("", word1).equals(String.join("", word2));

    }
}