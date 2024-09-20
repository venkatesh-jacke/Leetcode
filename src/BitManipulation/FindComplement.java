package BitManipulation;

public class FindComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    static public int findComplement(int n) {
        if (n == 0) return 1;
        int bitLen = Integer.toBinaryString(n).length();
        System.out.println(1 << bitLen);
        int mask = (1 << bitLen) - 1;
        System.out.println("mask "+mask);
        return n ^ mask;
    }
}
