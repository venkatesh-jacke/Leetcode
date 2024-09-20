package Strings;

public class FractionAddition {
    public static void main(String[] args) {
        String exp = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(exp));
    }

    static public String fractionAddition(String exp) {
        int num = 0, denom = 1;
        int i = 0;
        while (i < exp.length()) {
            int curNum = 0, curDenom = 0;
            boolean isNegative = false;
            if (exp.charAt(i) == '-' || exp.charAt(i) == '+') {
                if (exp.charAt(i) == '-')
                    isNegative = true;
                i++;
            }

            while (Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                curNum = curNum * 10 + val;
                i++;
            }
            if (isNegative)
                curNum *= -1;
            i++;
            while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                int val = exp.charAt(i) - '0';
                curDenom = curDenom * 10 + val;
                i++;
            }
            num = num * curDenom + curNum * denom;
            denom = denom * curDenom;
        }
        int gcd = Math.abs(gcd(num, denom));
        num /= gcd;
        denom /= gcd;
        return num + "/" + denom;
    }

    static public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
