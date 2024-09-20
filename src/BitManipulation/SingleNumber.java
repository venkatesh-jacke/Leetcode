package BitManipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    static public int singleNumber(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for(int i:nums){
        //     if(set.contains(i)) set.remove(i);
        //     else set.add(i);
        // }
        // return (int)set.toArray()[0];
        int x = 0;
        for (int i : nums) {
            x = x ^ i;
        }
        return x;
    }
}
