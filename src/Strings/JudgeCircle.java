package Strings;

//657. Robot Return to Origin

public class JudgeCircle {
    public static void main(String[] args) {
        String moves = "LL";
        System.out.println(judgeCircle(moves));

    }

    static public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') x--;
            else if (c == 'D') x++;
            else if (c == 'L') y--;
            else if (c == 'R') y++;
        }
        return x == 0 && y == 0;
    }
}
