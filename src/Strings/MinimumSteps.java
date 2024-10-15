package Strings;


//2938. Separate Black and White Balls
public class MinimumSteps {
    public static void main(String[] args) {
        String s = "101";
        System.out.println(minimumSteps(s));
    }

    static public long minimumSteps(String s) {
        int black=0;
        long minSteps=0;
        for(char c:s.toCharArray()){
            if(c=='1'){
                black++;
            }
            else{
                minSteps+=black;
            }
        }
        return minSteps;
    }
}
