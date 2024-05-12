package Arrays;

import java.util.LinkedList;
import java.util.Queue;


//2073. Time Needed to Buy Tickets
public class TimeRequiredToBuy {
    public static void main(String[] args) {
        int[] arr = {84,49,5,24,70,77,87,8};
        int k = 3;
        System.out.println(timeRequiredToBuy(arr, k));
        System.out.println(timeRequiredToBuy2(arr, k));
    }

    static public int timeRequiredToBuy2(int[] arr, int k) {
        int time=0;
       while(arr[k]!=0){
           for(int i=0;i<arr.length;i++){
                   if(arr[k]==0) break;
               if(arr[i]!=0){
                   arr[i]--;
                   time++;
               }
           }
       }
        return time;
    }
   static public int timeRequiredToBuy(int[] arr, int k) {
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) {
                time += Math.min(arr[i], arr[k]);
            } else {
                time += Math.min(arr[i], arr[k] - 1);
            }
        }
        return time;
    }
}
