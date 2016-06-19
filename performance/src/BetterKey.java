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
