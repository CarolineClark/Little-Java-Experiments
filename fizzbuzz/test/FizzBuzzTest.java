import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTest {
    private String sequence;
    @Before
    public void setup() {
        sequence = new FizzBuzz().calculate();
    }

    @Test
    @Parameters({"1", "2"})
    public void firstTwoNumbersMatchIndex(int index) {
        int element = getElementAtIndex(sequence, index);
        assertEquals(index, element);
    }

    private int getElementAtIndex(String seq, int index) {
        return Integer.parseInt(seq.split(",")[index - 1]);

    }
}
