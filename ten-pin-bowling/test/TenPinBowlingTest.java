import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TenPinBowlingTest {

    @Test
    public void aFrameThatIsNotASpareOrStrike_isASumOfTheIndividualRolls() {
        TenPinBowling tpb = new TenPinBowling();
        assertEquals(tpb.getFrameScore(2, 1), 3);
    }
}
