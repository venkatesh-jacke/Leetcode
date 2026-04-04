package Strings;

//2075. Decode the Slanted Ciphertext

public class DecodeCiphertext {
    public static void main(String[] args) {
        String encodedText = "iveo    eed   l te   olc";
        int rows = 4;
        System.out.println(decodeCiphertext(encodedText, rows));
    }

    static public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        StringBuilder res = new StringBuilder();
        //Start each diagonal from column 0, 1, 2, ... (cols-1)
        for (int col = 0; col < cols; col++) {
            int r = 0, c = col;
            while (r < rows && c < cols) {
                res.append(encodedText.charAt(r * cols + c));
                r++; // go one row down
                c++; // go one column right (diagonal!)
            }
        }
        // Remove trailing spaces (padding added during encoding)
        int end = res.length();
        while (end > 0 && res.charAt(end - 1) == ' ') {
            end--;
        }
        return res.substring(0, end);
    }
}

/*Think of the flat string like seats in a cinema.
Each row has exactly cols seats.

r × cols = skip past r full rows completely (like walking past r entire rows of seats).
        + c = now move c seats to the right inside the current row.

        index = r × cols + c

That's it. No magic — just counting seats.

If you know the index and want the row/col back:

r = index / cols  (integer division — how many full rows fit?)
c = index % cols  (remainder — how far into that row?)

Example: index 9, cols 4 → r = 9/4 = 2, c = 9%4 = 1 → cell (2,1).


*/
