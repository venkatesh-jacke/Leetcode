package HashTable;

import java.util.HashMap;

public class IsoMorphic {
    static public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            char replace = t.charAt(i);
            if(!map.containsKey(cur)){
                if(!map.containsValue(replace))
                    map.put(cur,replace);
                else
                    return  false;
            }
            else{
                char mapped=map.get(cur);
                if(mapped!=replace) return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "badc";
        String t = "kikp";
        System.out.println(isIsomorphic(s, t));

    }


}
