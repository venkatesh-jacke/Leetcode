package Strings;

public class SingleRowKeyboard {

    public static void main(String[] args) {
        String keyboard = "pqrstuvwxyzabcdefghijklmno";
        String word = "hello";
        System.out.println(calculateTime(keyboard, word));
    }


    //TC  O(n*m) n-->indexOf m--->length ofd word
    //Sc O(1)
        static int calculateTime(String keyboard, String word) {
            int currentInd = 0;
            int total = 0;
            for(char c:word.toCharArray()){
                int charIndex=keyboard.indexOf(c);
                total+=Math.abs(charIndex-currentInd);
                currentInd=charIndex;
            }

            return total;
        }
}
