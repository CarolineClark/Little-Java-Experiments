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
        String element = getElementAtIndex(sequence, index);
        assertEquals(Integer.toString(index), element);
    }

    @Test
    public void multipleOfThreesNotFive_isFizz() {
        assertEquals("fizz", getElementAtIndex(sequence, 3));
    }

    private String getElementAtIndex(String seq, int index) {
        return seq.split(",")[index - 1];

    }
}
