package Strings;


//1119.Remove Vowels from a String
public class RemoveVowels {
    public static void main(String[] args) {
        String str="welcome to geeksforgeeks";
        System.out.println(removeVowels(str));
    }

    //TC O(n)---> length of string
    //Sc O(n)--->length of stringBuilder
    static String removeVowels(String str) {
        StringBuilder s= new StringBuilder("");
        for(char c : str.toCharArray()){
            if(!(c =='a') && !(c =='e') && !(c =='i') && !(c =='o') && !(c =='u')){
                s.append(c);
            }
        }

        return s.toString();
    }
}
