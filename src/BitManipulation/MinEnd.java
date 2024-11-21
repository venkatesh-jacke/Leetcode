package BitManipulation;


//3133. Minimum Array End
public class MinEnd {
    public static void main(String[] args) {
        int n=3;
        int x=4;

    }
    static public long minEnd(int n, int x) {
        long a=x;

        while(--n>0){
            a= (a+1) | x;
        }
        return a;
    }
}
