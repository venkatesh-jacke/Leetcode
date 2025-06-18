package TwoPointer;

//3403. Find the Lexicographically Largest String From the Box I

public class AnswerString {
    public static void main(String[] args) {
        String word = "aann";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
    }

    static public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String cur = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(cur) <= 0) {
                res = cur;
            }
        }
        return res;
    }
}
/*
n - numFriends + 1
TotalLen - noOfFrdiends + 1  (+1 because one of them will be having more length so no need to include in the default split)
*/
