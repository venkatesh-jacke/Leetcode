package Strings;

import java.util.ArrayList;
import java.util.List;

public class CountMatches {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();

        // Add items as ArrayLists
        ArrayList<String> item1 = new ArrayList<>();
        item1.add("phone");
        item1.add("blue");
        item1.add("pixel");
        items.add(item1);

        ArrayList<String> item2 = new ArrayList<>();
        item2.add("computer");
        item2.add("silver");
        item2.add("lenovo");
        items.add(item2);

        ArrayList<String> item3 = new ArrayList<>();
        item3.add("phone");
        item3.add("gold");
        item3.add("iphone");
        items.add(item3);

        String ruleKey = "color";
        String ruleValue = "silver";
        int result = countMatches(items, ruleKey, ruleValue);
        System.out.println(result);

    }

    //Time O(n)
    //Space is O(1)
   static public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int c = 0;
        for (int i = 0; i < items.size(); i++) {
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)){
                c++;
            }
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)){
                c++;
            }
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)){
                c++;
            }
        }
        return c;
    }
}
