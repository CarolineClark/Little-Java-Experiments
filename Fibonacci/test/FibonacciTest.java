import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FibonacciTest {

    @Test
    @Parameters({"0", "1"})
    public void firstTwoNumbersMatchIndex(int i) {
        int[] seq = new Fibonacci().calculateSequence();
        assertEquals(i, seq[i]);
    }
}
