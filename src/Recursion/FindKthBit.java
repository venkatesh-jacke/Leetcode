package Recursion;


//1545. Find Kth Bit in Nth Binary String
public class FindKthBit {
    public static void main(String[] args) {
        int n = 4, k = 11;
        System.out.println(findKthBit(n,k));

    }

    static public char findKthBit(int n, int k) {
        int len = (1 << n) - 1;
        return rec(len, k);
    }

    static public char rec(int len, int k) {
        if (len == 1) return '0';
        int mid = len / 2;
        if (k <= mid) {
            return rec(mid, k);
        } else if (k > mid + 1) {
            char res = rec(mid, (1 + len) - k);
            return res == '0' ? '1' : '0'; //invert the res
        } else {
            return '1';
        }
    }
}
