package Arrays;


//1894. Find the Student that Will Replace the Chalk

public class ChalkReplacer {
    public static void main(String[] args) {
        int[] chalk = {3,4,1,2};
        int k = 25;
//        int[] chalk = {5,1,5};
//        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
    }

    static public int chalkReplacer(int[] chalk, int k) {
        int i = 0, n = chalk.length;
        int idx=0;
        while (k >= chalk[i % n]) {
            k -= chalk[i % n];
            i++;
            idx=i%n;
        }
        return idx;
    }
}
