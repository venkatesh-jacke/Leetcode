package Strings;

import java.util.*;


//1233. Remove Sub-Folders from the Filesystem
public class RemoveSubfolders {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders(folder));

    }

    static public List<String> removeSubfolders(String[] folder){
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;
            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1)
                    break;
                prefix = prefix.substring(0, pos);
                if (set.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }
            if (!isSubFolder) {
                res.add(f);
            }
        }
        return res;

    }
}
