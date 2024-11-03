package Strings;


//796. Rotate String
public class RotateString {
    public static void main(String[] args) {
        String s = "aa";
        String goal = "a";
        System.out.println(rotateString(s, goal));
    }

    static public boolean rotateString(String s, String goal) {
        if(s.length()>goal.length()) return false;
        String temp = s + s;
        return temp.contains(goal);
    }
}
