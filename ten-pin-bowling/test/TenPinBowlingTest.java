import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TenPinBowlingTest {

    @Test
    public void aFrameThatIsNotASpareOrStrike_isASumOfTheIndividualRolls() {
        TenPinBowling tpb = new TenPinBowling();
        assertEquals(tpb.getFrameScore(2, 1), 3);
    }

    @Test
    public void aFrameThatIsASpare_isASumOfTheFramePlusTheNextRoll() {
        TenPinBowling tpb = new TenPinBowling();
        assertEquals(tpb.getSpareFrameScore(3), 13);
    }
}
