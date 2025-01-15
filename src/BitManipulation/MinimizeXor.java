package BitManipulation;


//2429. Minimize XOR

public class MinimizeXor {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 12;
        System.out.println(minimizeXor(num1, num2));

    }

    static public int minimizeXor(int num1, int num2) {
        int targetSetBits = Integer.bitCount(num2);
        int result = 0;

        // Step 1: Traverse from the most significant bit (31st bit) to the least significant bit (0th bit)
        // Set bits in result that are already set in num1 to try and minimize XOR value
        for (int i = 31; i >= 0 && targetSetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Check if the i-th bit in num1 is set
                result = result | (1 << i); // Set the i-th bit in result
                targetSetBits--; // Reduce the number of remaining bits to set
            }
        }

        // Step 2: Traverse from the least significant bit (0th bit) to the most significant bit (31st bit)
        // Set any remaining unset bits in result to achieve the required number of set bits
        for (int i = 0; i < 31 && targetSetBits > 0; i++) {
            if ((result & (1 << i)) == 0) { // Check if the i-th bit in result is not set
                result = result | (1 << i); // Set the i-th bit in result
                targetSetBits--; // Reduce the number of remaining bits to set
            }
        }
        return result;
    }
}
