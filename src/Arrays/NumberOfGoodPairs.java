package Arrays;


import java.util.Arrays;

//1512. Number of Good Pairs
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs_2(arr));
    }


    //Bruteforce
    //Time Complexity O(n^2)
    //Space complexity O(1)
    static int numIdenticalPairs(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]) c++;
            }
        }
        return c;

    }


    //Optimal
    //Time Complexity O(n) no of elements
    //Space complexity O(n) n is size of constraint of array
    static int numIdenticalPairs_2(int[] nums) {
        int n=nums.length;
        int arr[]= new int[101]; //make a counter for each digit
        int c=0;
        for(int i:nums){
            c+=arr[i]; //add the frequency of the element to the result to form a good pairs
            arr[i]++;  //increment the frequency of an element after finding the match

        }
        return c;
    }
}
