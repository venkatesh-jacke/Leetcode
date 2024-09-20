package BitManipulation;

public class AddBinary {
    public static void main(String[] args) {

    }
    static public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int i = n1 - 1, j = n2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0)
                carry += a.charAt(i--) - '0';
            if (j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}
