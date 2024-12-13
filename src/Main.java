import java.util.Arrays;
import java.util.HashMap;

class Main {

    public static void main(String[] args) {
        System.out.println(getMinDiff(3,new int[]{1,5,8,10}));

    }

    static  public int getMinDiff(int k, int[] arr){
        // code here ssss
        int n=arr.length;
        Arrays.sort(arr);
        int ans= arr[n-1]-arr[0];
        int smallest=arr[0]+k;
        int largest=arr[n-1]-k;

        for(int i=0;i<n-1;i++){
            int min = Math.min(smallest,arr[i+1]-k);
            int max=Math.max(largest,arr[i]+k);
            System.out.println("min "+min+" max "+max);
            ans=Math.min(ans,max-min);
        }
        return ans;

    }


}
