package HashSet;

import java.util.HashSet;
import java.util.Set;

//202. Happy Number
public class IsHappy {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }


    //Time is O(n)
    //Space is O(n) Set is used
    static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = sumOfSquares(n);
        }
        return n==1;
    }

    static public int sumOfSquares(int n){
        int sum=0;
        while(n>0){
            int rem= n%10;
            sum+=rem*rem;
            n/=10;
        }
        return sum;
    }
}

/*
Intuition:-

If its happy number the sum end in 1 the set items will be unique since the summation cycle would end in 1
If its not happy number it will struck in the cycle so the number will lardy present in set if its present break and chk if n==1.
N=19

19 ----> 1^2 + 9^2 = 1 + 81 = 82 [1, 82]
82 ----> 8^2 + 2^2 = 64 + 4 = 68 [1, 82, 68]
68 ----> 6^2 + 8^2 = 36 + 64 = 100 [1, 82, 68, 100]
100 ----> 1^2 + 0^2 + 0^2 = 1 + 0 + 0 = 1 [1, 82, 68, 100]
N==1 True

N=61
61 ----> 6^2 + 1^2 = 36 + 1 = 37 [61, 37]
37 ----> 3^2 + 7^2 = 9 + 49 = 58 [61, 37, 58]
58 ----> 5^2 + 8^2 = 25 + 64 = 89 [61, 37, 58, 89]
89 ----> 8^2 + 9^2 = 64 + 81 = 145 [61, 37, 58, 89, 145]
145 ----> 1^2 + 4^2 + 5^2 = 1 + 16 + 25 = 42 [61, 37, 58, 89, 145, 42]
42 ----> 4^2 + 2^2 = 16 + 4 = 20 [61, 37, 58, 89, 145, 42, 20]
20 ----> 2^2 + 0^2 = 4 + 0 = 4 [61, 37, 58, 89, 145, 42, 20, 4]
4 ----> 4^2 = 16 [61, 37, 58, 89, 145, 42, 20, 4, 16]
16 ----> 1^2 + 6^2 = 1 + 36 = 37 [61, 37, 58, 89, 145, 42, 20, 4, 16]
*/
