package Strings;


//6. Zigzag Conversion
public class ZigZag {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int rows = 4;
        System.out.println(convert(s, rows));
        System.out.println(convert2(s, rows));
    }

    //TC O(row*n)
    //SC  O(row +n)
    static public String convert(String s, int row) {
        int n = s.length();
        StringBuffer[] arr = new StringBuffer[row];
        for (int i = 0; i < row; i++) {
            arr[i] = new StringBuffer();
        }
        int i = 0;
        while (i < n) {
            for (int ind = 0; ind < row && i < n; ind++) {
                arr[ind].append(s.charAt(i++));
            }
            for (int ind = row - 2; ind > 0 && i < n; ind--) {
                arr[ind].append(s.charAt(i++));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuffer sb : arr) {
            ans.append(sb);
        }
        return ans.toString();

    }

    static public String convert2(String s, int row) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < row; i++) {
            int jump = (row - 1) * 2;
            for (int j = i; j < n; j += jump) {
                sb.append(s.charAt(j));
                int diagonalJump = j + (row - i - 1) * 2;
                if (i > 0 && i < row - 1 && diagonalJump < n) {
                    sb.append(s.charAt(diagonalJump));
                }
            }
        }
        return sb.toString();
    }

}
