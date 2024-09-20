package BitManipulation;

public class MinBitFlips {
    public static void main(String[] args) {
        int start = 3;
        int goal = 4;
        System.out.println(minBitFlips(start, goal));

    }

    static public int minBitFlips(int start, int goal) {
        int x= start ^goal;
        System.out.println(x);
        int c=0;
        while(x>0){
            c++;
            x= x &(x-1);
        }
        return c;
    }
}
