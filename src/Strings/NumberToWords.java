package Strings;


import java.util.*;

public class NumberToWords {
    public static void main(String[] args) {

    }

    static final List<Map.Entry<Integer, String>> mp = new ArrayList<>(Arrays.asList(
            new AbstractMap.SimpleEntry<>(1000000000, "Billion"),
            new AbstractMap.SimpleEntry<>(1000000, "Million"),
            new AbstractMap.SimpleEntry<>(1000, "Thousand"),
            new AbstractMap.SimpleEntry<>(100, "Hundred"),
            new AbstractMap.SimpleEntry<>(90, "Ninety"),
            new AbstractMap.SimpleEntry<>(80, "Eighty"),
            new AbstractMap.SimpleEntry<>(70, "Seventy"),
            new AbstractMap.SimpleEntry<>(60, "Sixty"),
            new AbstractMap.SimpleEntry<>(50, "Fifty"),
            new AbstractMap.SimpleEntry<>(40, "Forty"),
            new AbstractMap.SimpleEntry<>(30, "Thirty"),
            new AbstractMap.SimpleEntry<>(20, "Twenty"),
            new AbstractMap.SimpleEntry<>(19, "Nineteen"),
            new AbstractMap.SimpleEntry<>(18, "Eighteen"),
            new AbstractMap.SimpleEntry<>(17, "Seventeen"),
            new AbstractMap.SimpleEntry<>(16, "Sixteen"),
            new AbstractMap.SimpleEntry<>(15, "Fifteen"),
            new AbstractMap.SimpleEntry<>(14, "Fourteen"),
            new AbstractMap.SimpleEntry<>(13, "Thirteen"),
            new AbstractMap.SimpleEntry<>(12, "Twelve"),
            new AbstractMap.SimpleEntry<>(11, "Eleven"),
            new AbstractMap.SimpleEntry<>(10, "Ten"),
            new AbstractMap.SimpleEntry<>(9, "Nine"),
            new AbstractMap.SimpleEntry<>(8, "Eight"),
            new AbstractMap.SimpleEntry<>(7, "Seven"),
            new AbstractMap.SimpleEntry<>(6, "Six"),
            new AbstractMap.SimpleEntry<>(5, "Five"),
            new AbstractMap.SimpleEntry<>(4, "Four"),
            new AbstractMap.SimpleEntry<>(3, "Three"),
            new AbstractMap.SimpleEntry<>(2, "Two"),
            new AbstractMap.SimpleEntry<>(1, "One")));

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        for (Map.Entry<Integer, String> entry : mp) {
            if (num >= entry.getKey()) {
                String a = "";
                if (num >= 100) {
                    a = numberToWords(num / entry.getKey()) + " ";
                }

                String b = entry.getValue();

                String c = "";
                if (num % entry.getKey() != 0) {
                    c = " " + numberToWords(num % entry.getKey());
                }
                return a + b + c;
            }
        }
        return "";
    }
}
