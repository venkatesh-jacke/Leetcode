package Strings;


//2011. Final Value of Variable After Performing Operations
public class FindValueAfterOperations {

    public static void main(String[] args) {
        String str[] = new String[]{"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(str));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int c = 0;
        for (String s : operations) {
            if (s.equals("++X")) {
                c++;
            } else if (s.equals("X++")) {
                ++c;
            } else if (s.equals("--X")) {
                --c;
            } else if (s.equals("X--")) {
                c--;
            }


        }
        return c;
    }
}
