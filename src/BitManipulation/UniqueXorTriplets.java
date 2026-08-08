package BitManipulation;

//Number of Unique XOR Triplets I


public class UniqueXorTriplets {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(uniqueXorTriplets(arr));
    }

    static public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        // If the array has less than 3 elements, we cannot form any triplet.
        // The possible XOR results are just the elements themselves.
        // So the answer is the number of elements.
        if (n < 3)
            return n;

        /*
         * We need to find how many bits are required to represent n.
         *
         * Integer.numberOfLeadingZeros(n) gives the number of zero bits
         * before the first set bit in the 32-bit representation of n.
         *
         * Example:
         * n = 5
         * Binary representation:
         * 00000000 00000000 00000000 00000101
         *
         * Leading zeros = 29
         *
         * bits = 32 - 29 = 3
         *
         * Meaning: we need 3 bits to represent numbers up to 5.
         */
        int bits = 32 - Integer.numberOfLeadingZeros(n);

        /*
         * 1 << bits means:
         * Shift binary 1 to the left by 'bits' positions.
         *
         * It is equivalent to calculating 2^bits.
         *
         * Example:
         * bits = 3
         *
         * 1 in binary:       0001
         * 1 << 3:            1000
         *
         * Decimal value = 8
         *
         * This gives the total possible XOR values that can be represented
         * using 'bits' number of bits.
         */
        return 1 << bits;
    }
}
