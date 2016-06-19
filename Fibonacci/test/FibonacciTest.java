import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest {

    private int[] seq;

    @Before
    public void setup() {
        seq = new Fibonacci().calculateSequence();
    }

    @Test
    @Parameters({"0", "1"})
    public void firstTwoNumbersMatchIndex(int i) {
        assertEquals(i, seq[i]);
    }

    @Test
    @Parameters({"0", "1", "4", "6", "9", "38"})
    public void laterNumbersEqualSumOfPreviousNumbers(int i) {
        assertEquals(seq[i] + seq[i+1], seq[i+2]);
    }
}
