package Arrays;


//2601. Prime Subtraction Operation
public class PrimeSubOperation {
    public static void main(String[] args) {
        int[] nums={4,9,6,10};
        System.out.println();
    }

    //Bruteforce
   static public boolean primeSubOperation1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int bound;
            if (i == 0) {
                bound = nums[0];
            } else {
                bound = nums[i] - nums[i - 1];
            }
            if (bound <= 0) {
                return false;
            }
            int largestPrime = 0;
            for (int j = bound - 1; j >= 2; j--) {
                if (isPrime(j)) {
                    largestPrime = j;
                    break;
                }
            }
            nums[i] = nums[i] - largestPrime;
        }
        return true;
    }
    public boolean primeSubOperation2(int[] nums) {
        int limit = 0;
        for (int i : nums) {
            limit = Math.max(limit, i);
        }
        int[] primes = new int[limit + 1];
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes[i] = i;
            } else {
                primes[i] = primes[i - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int bound;
            if (i == 0) {
                bound = nums[0];
            } else {
                bound = nums[i] - nums[i - 1];
            }
            if (bound <= 0)
                return false;
            int largestPrime = primes[bound - 1];
            nums[i] -= largestPrime;
        }
        return true;
    }

    static public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
