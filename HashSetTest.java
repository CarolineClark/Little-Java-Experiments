import java.util.*;

/*
 * Create a key that always returns the same hashCode but false for equals.
 * This is to create the worst case HashSet, which is essentially a LinkedList.
 * This should have the O(N) for add and contains functions.
 */
class WorstCaseKey {
    public int value;

    WorstCaseKey(int value) {
        this.value = value;
    }

    public int hashCode() {
        return 5;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

/*
 * Create a key that has a unique hash code for each key.
 * This should have the O(1) for add and contains functions.
 */
class BetterKey {
    public int value;

    BetterKey(int value) {
        this.value = value;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof BetterKey) {
            return (this.value == ((BetterKey)obj).value);
        }
        return false;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}


public class HashSetTest {
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
