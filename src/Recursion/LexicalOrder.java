package Recursion;

import java.util.ArrayList;
import java.util.List;

//386. Lexicographical Numbers
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(12));
    }

    static public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            generateNumbers(i, n, res);
        return res;
    }


    //Recursive
    static public void generateNumbers(int cur, int limit, List<Integer> res) {
        if (cur > limit)
            return;
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            if (next > limit)
                break;
            generateNumbers(next, limit, res);
        }
    }

    //Iterative
    public List<Integer> lexicalOrderIterative(int n) {
        List<Integer> res = new ArrayList<>();
        int cur=1;
        for(int i=1;i<=n;i++){
            res.add(cur);
            if(cur*10 <= n){
                cur=cur*10;
            }
            else{
                while(cur%10==9 || cur >= n){
                    cur=cur/10;
                }
                cur+=1;
            }
        }
        return res;
    }
}
