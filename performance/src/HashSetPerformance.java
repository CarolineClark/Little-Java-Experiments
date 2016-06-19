/*
 * The aim with this experiment is to see how a bad hashCode function can hurt the performance
 * of the .add and .contains functions of HashSet.
 *
 * Needs min Java 7 to run
 * Output example:
    Time to create worse set: 166
    Time to create better set: 5
    Time to create worse set: 333
    Time to create better set: 2
 */


import java.util.HashSet;
import java.util.Set;

public class HashSetPerformance {
    private final static int NUMBER_OF_KEYS = 10000;

    private static void logTimeDifference(long time1, long time2, String setName) {
        long timeDifference = time2 - time1;
        String logMessage = "Time to create " + setName + ": " + timeDifference;
        System.out.println(logMessage);
    }

    public static void main(String[] args) {

        long now1;
        long now2;
        // Set up the two cases

        // Set up the worst case and time the difference in adding elements.
        now1 = System.currentTimeMillis();
        Set<WorstCaseKey> worstCaseSet = new HashSet<>();

        for (int i=0; i<NUMBER_OF_KEYS; i++) {
            WorstCaseKey key = new WorstCaseKey(i);
            worstCaseSet.add(key);
        }
        now2 = System.currentTimeMillis();
        logTimeDifference(now1, now2, "worse set");

        // Set up the better case
        now1 = System.currentTimeMillis();
        Set<BetterKey> betterSet = new HashSet<>();

        for (int i=0; i<NUMBER_OF_KEYS; i++) {
            BetterKey key = new BetterKey(i);
            betterSet.add(key);
        }
        now2 = System.currentTimeMillis();
        logTimeDifference(now1, now2, "better set");

        // Iterate through them and see if there is a performance difference on the contains function.

        // Worse set
        now1 = System.currentTimeMillis();

        for (int i=0; i<NUMBER_OF_KEYS; i++) {
            WorstCaseKey key = new WorstCaseKey(i);
            worstCaseSet.contains(key);
        }
        now2 = System.currentTimeMillis();
        logTimeDifference(now1, now2, "worse set");

        // Iterate through better set
        now1 = System.currentTimeMillis();

        for (int i=0; i<NUMBER_OF_KEYS; i++) {
            BetterKey key = new BetterKey(i);
            betterSet.contains(key);
        }
        now2 = System.currentTimeMillis();
        logTimeDifference(now1, now2, "better set");
    }

}
