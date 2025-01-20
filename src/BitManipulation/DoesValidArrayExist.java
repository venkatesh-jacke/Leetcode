package BitManipulation;


//2683. Neighboring Bitwise XOR

public class DoesValidArrayExist {
    public static void main(String[] args) {
        int[] derived = {1, 1, 0};
        System.out.println(doesValidArrayExist(derived));
    }

    static public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int i : derived) {
            xor ^= i;
        }
        return xor == 0;
    }
}
//The xor-sum of the derived array should be 0 since there is always a duplicate occurrence of each element.