package Heap;

public class QuickSelectMin {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(kthSmallest(arr, 0, arr.length - 1, 1));
    }

    public static int kthSmallest(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pi = partition(arr, low, high);

            if (pi == k - 1) {
                return arr[pi];
            } else if (pi < k - 1) {
                return kthSmallest(arr, pi + 1, high, k);
            } else {
                return kthSmallest(arr, low, pi - 1, k);
            }
        }
        return Integer.MAX_VALUE; // If k is out of bounds
    }

    public static int partition(int[] arr, int low, int high) {
        int pi = high;
        int pivot = arr[pi];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, pi);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
