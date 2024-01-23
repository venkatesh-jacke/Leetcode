package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//2859. Sum of Values at Indices With K Set Bits
public class SumIndicesWithKSetBits {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>(Arrays.asList(5,10,1,5,2));
        int k=1;
        System.out.println(sumIndicesWithKSetBits(list,k));

    }

    //Time Complexity is O(NlogN)
    //Space Complexity is O(1)
    static public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int indx=0;
        int sum =0;
        for(Integer i:nums){
            int setbits = setBits(indx++);
            if(setbits==k){
                sum+=i;
            }
        }
        return sum;

    }
    static int setBits(int n){
        int count=0;
        while (n>0){
            if((n&1)==1) count++;
            n>>=1;
        }
        return count;
    }
}
