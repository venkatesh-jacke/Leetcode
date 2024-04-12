package Recursion;

import java.util.LinkedList;
import java.util.Queue;

public class CircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner3(5,2));

    }



    //TC O(N*K)
    //SC O(N)
   static public int findTheWinner1(int n, int k) {
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<n;i++) q.add(i+1);
        int last=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<k-1;j++){
                q.add(q.poll());
            }
            last= q.poll();

        }

        return last;
    }


    //Recursion
    static public int findTheWinner2(int n, int k) {
      if(n==1) return 1;
      return (findTheWinner2(n-1,k)+k-1) % n+1;
    }

    //Iterative
    static public int findTheWinner3(int n, int k) {
       int res=0;
       for(int i=1;i<=n;i++){
           res=(res+k) % i;
           System.out.println(res); //index of winner in each iteration
       }
       return res+1;
    }
}
