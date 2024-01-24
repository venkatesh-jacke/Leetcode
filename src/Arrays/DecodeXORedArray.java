package Arrays;

import java.util.Arrays;


//1720. Decode XORed Array
public class DecodeXORedArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int first = 1;
        System.out.println(Arrays.toString(decode(arr, first)));
    }



    //XORED means if two bits are different than its 1.
    //Time Complexity is O(n)
    //Space complexity is O(1)
    static public int[] decode(int[] encoded, int first) {
        int res[] = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i+1] = encoded[i] ^ res[i];
        }
        return res;
    }
}
