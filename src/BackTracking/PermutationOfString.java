package BackTracking;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "abc";
        permutation(s.toCharArray(), 0, s.length()-1);
    }

    static void permutation(char[] ca, int low, int high) {
        if (low == high) {
            System.out.println(String.valueOf(ca));
        } else {
            for (int i = low; i <= high; i++) {
                swap(ca, i,low);
                permutation(ca, low + 1, high);
                swap(ca, i, low);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
