
public class Fibonacci {

    public int[] calculateSequence() {
        int[] sequence = new int[50];
        sequence[0] = 0;
        sequence[1] = 1;

        for (int i=0; i<47; i++) {
            sequence[i + 2] = sequence[i + 1] + sequence[i];
        }

        return sequence;
    }
}
