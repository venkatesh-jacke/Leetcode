package Arrays;

import java.util.*;

public class DecompressRLElis {
    public static void main(String[] args) {
        int nums[]= new int[]{55,11,70,26,62,64};
        System.out.println(Arrays.toString(decompressRLElist(nums)));
    }

    //TC O(N)
    //SC O(N)
    static  public int[] decompressRLElist(int[] nums) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            while(nums[i]!=0){
                list.add(nums[i+1]);
                nums[i]--;
            }

        }
        int k=0;
        int arr[] = new int[list.size()];
        for(int z:list){
            arr[k++]=z;
        }
        return arr;
    }

    public int[] decompressRLElist2(int[] nums) {
        int arrSize = 0;
        for (int i = 0; i < nums.length; i += 2) {
            arrSize += nums[i];
        }

        int[] result = new int[arrSize];

        int startIdx = 0;
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(result, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }
        return result;
    }
}
