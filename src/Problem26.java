import java.util.HashMap;

public class Problem26 {
    // 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 (0.142857) has a 6-digit recurring cycle.
    // Find the value of d [<] 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

    public static void main(String[] args) {
        System.out.println(getReciprocalCycle());
    }

    static int getReciprocalCycle() {
        int maxCycleLength = 0;
        int longestDemon = 0;
        for (int i = 1; i <= 1000; i++) {
            int len = getCycleLength(i);
            if (len > maxCycleLength) {
                maxCycleLength = len;
                longestDemon = i;
            }
        }
        return longestDemon;
    }

    static int getCycleLength(int n) {
        //key is remainder, value is position in decimal
        HashMap<Integer, Integer> reminders = new HashMap<>();
        int state = 1;
        for (int i = 0; ; i++) {
            if (reminders.containsKey(state))
                return i - reminders.get(state);
            else {
                reminders.put(state, i);
                state = state * 10 % n;
            }
        }
    }

    //https://radiusofcircle.blogspot.com/2016/04/problem-26-project-euler-solution-with-python.html


}
