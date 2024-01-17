package Arrays;

public class NumberOfEmployeesWhoMetTarget {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4};
        int target = 2;
        System.out.println(numberOfEmployeesWhoMetTarget(arr,target));
    }


    //Time Complexity is O(n) no of elements

    //Space Complexity is O(1)
    static int numberOfEmployeesWhoMetTarget(int[] arr,int target) {
        int c=0;
        for(int i:arr){
            if(i>=target) c++;
        }

        return c;

    }
}
