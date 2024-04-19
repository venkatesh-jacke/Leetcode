package Arrays;


//2105. Watering Plants II
public class MinimumRefill {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,2,4,4,5
        };
        int cap = 5;
        System.out.println(minimumRefill(arr, 6, 5));

    }

    static public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice = 0, bob = plants.length - 1;
        int canA = capacityA, canB = capacityB;
        int refill = 0;
        while (alice <= bob) {
            if (alice == bob) {
                int maxCan = Math.max(canA, canB);
                if (plants[alice] > maxCan) {
                    refill++;
                }
            } else {
                if (plants[alice] > canA) {
                    refill++;
                    canA = capacityA;

                }
                canA -= plants[alice];
                if (plants[bob] > canB) {
                    refill++;
                    canB = capacityB;

                }
                canB -= plants[bob];
            }
            alice++;
            bob--;
        }
        return refill;
    }
}
