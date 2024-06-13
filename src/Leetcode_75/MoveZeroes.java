package Leetcode_75;

import java.util.Arrays;


//283. Move Zeroes
public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        moveZeroes2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static public void moveZeroes1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        swap(i, j, arr);
                        break;
                    }
                }
            }

        }
    }

    static public void moveZeroes2(int[] arr) {
        for (int lastNonZero = 0, cur = 0; cur < arr.length; cur++) {
            if (arr[cur] != 0) {
                swap(lastNonZero++, cur, arr);
            }
        }
    }

    static public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
