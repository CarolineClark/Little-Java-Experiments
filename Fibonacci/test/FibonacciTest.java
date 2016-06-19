import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FibonacciTest {

    @Test
    public void firstTwoNumbersMatchIndex() {
        int[] seq = new Fibonacci().calculateSequence();
        assertEquals(0, seq[0]);
    }
}
