package Heap;


import java.util.PriorityQueue;

//1405. Longest Happy String
public class LongestDiverseString {
   static class Pair {
        char ch;
        int cnt;

        Pair(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        System.out.println(longestDiverseString(a, b, c));

    }
   static  public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> (y.cnt - x.cnt));
       StringBuilder sb = new StringBuilder();
       if (a > 0) {
           pq.add(new Pair('a', a));
       }
       if (b > 0) {
           pq.add(new Pair('b', b));
       }
       if (c > 0) {
           pq.add(new Pair('c', c));
       }
       while (!pq.isEmpty()) {
           Pair cur = pq.poll();
           int cnt = cur.cnt;
           char ch = cur.ch;
           //Check for 2 consecutive chars
           if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch) {
               if (pq.isEmpty())
                   break;
               Pair next = pq.poll();  //take next highest char from heap
               sb.append(next.ch);
               if (next.cnt - 1 > 0) {
                   pq.add(new Pair(next.ch, next.cnt - 1));
               }
           } else {
               cnt--;
               sb.append(cur.ch);  //add current char from heap

           }
           //Since we take the char from heap everytime so put it inside if it has valid count
           if (cnt > 0) {
               pq.add(new Pair(ch, cnt));
           }
       }
       return sb.toString();
   }
}
