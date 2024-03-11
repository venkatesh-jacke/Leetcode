package Arrays;

import java.util.ArrayList;
import java.util.List;


//1389. Create Target Array in the Given Order
public class CreateTargetArray {
    public static void main(String[] args) {
        int nums[]= new int[]{0,1,2,3,4};
        int index[]= new int[]{0,1,2,2,1};
        System.out.println(createTargetArray(nums,index));
    }

    //TC O(N)
    //SC O(n)
    static   public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<index.length;i++){
            list.add(index[i],nums[i]);
        }
        int[] arr= new int[list.size()];
        int j=0;
        for(int i:list){
            arr[j++]=i;
        }
        return arr;
    }
}
