package Arrays;


// 2011 Final Value of Variable After Performing Operations
public class FinalValueAfterOperation {
    public static void main(String[] args) {
        String operations[] = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

    static int finalValueAfterOperations(String[] operations) {
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
// Time Complexity O(n) no of strings in an array
//Space Complexity O(1) no extra space

//Note:  Remember to use equals method to compare the contents of two object because == will chk the two object referring to the same memory location