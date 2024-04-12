import java.util.Arrays;
import java.util.Scanner;

public class CodeForce {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int values = sc.nextInt();
                arr[i] = values;
            }
            System.out.println(halloumi_boxes(arr, k));
        }

    }

    static String halloumi_boxes(int[] arr, int k) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1] && k==1)
                return "NO";
        }
        return "YES";
    }

}