package Arrays;


//1700. Number of Students Unable to Eat Lunch
public class CountStudents {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
    }
   static public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0;
        int zeros = 0;
        for (int i : students) {
            if (i == 0) {
                zeros++;
            } else {
                ones++;
            }
        }

        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0)
                zeros--;
            if (sandwiches[i] == 1)
                ones--;
            if (zeros < 0) break;
            if (ones < 0) break;

        }
        return zeros < 0 ? ones : zeros;

    }
}
