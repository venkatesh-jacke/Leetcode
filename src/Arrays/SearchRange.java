package Arrays;


//34. Find First and Last Position of Element in Sorted Array
public class SearchRange {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println();
    }

    static public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        start = 0;
        end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res[1] = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    static public int[] searchRange2(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                res[0] = mid;
                res[1] = mid;
                while (res[0] > 0 && nums[res[0] - 1] == target)
                    res[0] -= 1;
                while (res[1] < n - 1 && nums[res[1] + 1] == target)
                    res[1] += 1;
                return res;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }
}
