package Stack;

import java.util.Stack;


//682. Baseball Game
public class CalPoints {
    public static void main(String[] args) {
        String operations[] = new String[]{"1","C"};
        System.out.println(calPoints(operations));
        System.out.println(calPoints2(operations));
    }


    //TC O(n)
    //SC O(n) ---> stack is used
    static public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if (s.equals("C")) {
                stack.pop();
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("+")) {
                stack.push(stack.peek() + stack.elementAt(stack.size() - 2));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    //TC O(n)
    //SC O(1)
    static public int calPoints2(String[] operations) {
        int[] arr= new int[operations.length];
        int size=0;
        for (String s : operations) {
            if (s.equals("C")) {
            size--;
            } else if (s.equals("D")) {
                arr[size]=arr[size-1]*2;
                size++;
            } else if (s.equals("+")) {
                arr[size]=arr[size-1]+arr[size-2];
                size++;
            } else {
                arr[size]=Integer.parseInt(s);
                size++;
            }
        }
        int sum=0;
        for(int i=0;i<size;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
