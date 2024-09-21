package BitManipulation;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(6));
    }
    public static long reverseBits(long n) {
        // Write your code here
        long res=0;
        for(int i=0;i<32;i++){
            res = (res<<1) | (n&1);
            n>>=1;
        }
        return res;
    }
}
/*
Since the given number N = 6 is represented as 00000000000000000000000000000110 in its binary representation.
So after reversing the bits, it will become 01100000000000000000000000000000, which is equal to 1610612736.
*/
