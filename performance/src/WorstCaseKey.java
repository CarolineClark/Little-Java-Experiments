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
