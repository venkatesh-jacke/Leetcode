package HashTable;

public class CanArrange {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    static public boolean canArrange(int[] arr, int k) {
        int[] count = new int[k];
        for (int i : arr) {
            int rem = i % k;
            if (rem < 0)
                rem += k;
            count[rem]++;
            //count[(i%k+k)%k]++;
        }
        if (count[0] % 2 != 0)
            return false;
        for (int i = 1; i <= (k / 2); i++) {
            if (count[i] != count[k - i])
                return false;
        }
        return true;
    }
}
