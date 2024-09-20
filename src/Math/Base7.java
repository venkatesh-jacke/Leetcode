package Math;

public class Base7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
    }

    static public String convertToBase7(int num)  {
        if(num==0) return "0";
        int original = num;
        num = Math.abs(num);
        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            int rem = num % 7;
            ans.append(rem);
            num /= 7;
        }
        if (original < 0)
            ans.append('-');
        return ans.reverse().toString();

    }
}
