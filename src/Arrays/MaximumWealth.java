package Arrays;


//1672. Richest Customer Wealth
public class MaximumWealth {
    public static void main(String[] args) {
        int arr[][]=new int[][]{{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(arr));
    }

    //Time Complexity is O(N*M) n is no of rows and m is no of col
    //Space Complexity is O(1)
    static int maximumWealth(int[][] arr){
        int res=0;
        for(int i=0;i< arr.length;i++){
            int value=-0;
            for(int j=0;j<arr[i].length;j++){
                value+=arr[i][j];
            }
            res=Math.max(res,value);
        }


        return res;

    }
}
