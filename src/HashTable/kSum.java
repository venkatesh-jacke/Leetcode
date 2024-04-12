    package HashTable;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    public class kSum {
        public static void main(String[] args) {
            System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        }

        static public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            kSum(nums, 0, res, new ArrayList<>(), 4, target);
            return res;
        }

        static void kSum(int[] arr, int start, List<List<Integer>> res, List<Integer> quad, int k, int target) {
            int n = arr.length;
            if (start == n || arr[start] * k > target || arr[n - 1] * k < target) {
                return;
            }
            if (k == 2) {
                int left = start, right = n - 1;
                while (left < right) {
                    int sum = arr[left] + arr[right];
                    if (sum == target) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(arr[left]);
                        pair.add(arr[right]);
                        System.out.println("Pair is "+pair);
                        res.add(new ArrayList<>(quad));
                        System.out.println("res is "+res);
                        res.get(res.size() - 1).addAll(pair);
                        System.out.println("res2 is "+res);
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            } else {
                for (int i = start; i < n - k + 1; i++) {
                    if (i > start && arr[i] == arr[i - 1]) continue;
                    quad.add(arr[i]);
                    kSum(arr, i + 1, res, quad, k - 1, target - arr[i]);
                    quad.remove(quad.size() - 1);
                }
            }
        }
    }
