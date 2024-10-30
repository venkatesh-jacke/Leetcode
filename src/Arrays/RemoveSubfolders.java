package Arrays;

import java.util.*;

//1233. Remove Sub-Folders from the Filesystem
public class RemoveSubfolders {
    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(removeSubfolders(folder));

    }

    static public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);
        res.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = res.get(res.size() - 1) + '/';
            if (!folder[i].startsWith(lastFolder)) {
                res.add(folder[i]);
            }

        }
        return res;

    }
}
