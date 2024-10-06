package TwoPointer;


//1813. Sentence Similarity III
public class AreSentencesSimilar {
    public static void main(String[] args) {
        String s1="My name is Haley";
        String s2="My Haley";

        System.out.println(areSentencesSimilar(s1,s2));
    }
    static  public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        String[] c1 = s1.split(" ");
        String[] c2 = s2.split(" ");
        int l1 = 0, l2 = 0;
        int r1 = c1.length - 1, r2 = c2.length - 1;

        while (l1 < c1.length && l2 < c2.length && c1[l1].equals(c2[l2])) {
            l1++;
            l2++;
        }

        while (r1 >= 0 && r2 >= 0 && c1[r1].equals(c2[r2])) {
            r1--;
            r2--;
        }
        return l1 > r1;
    }
}
