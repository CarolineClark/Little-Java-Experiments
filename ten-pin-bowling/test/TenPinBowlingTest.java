import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TenPinBowlingTest {
    private TenPinBowling tpb;
    @Before
    public void setup() {
        tpb = new TenPinBowling();
    }

    @Test
    public void aFrameThatIsNotASpareOrStrike_isASumOfTheIndividualRolls() {
        assertEquals(3, tpb.getFrameScore(2, 1));
    }

    @Test
    public void aFrameThatIsASpare_isASumOfTheFramePlusTheNextRoll() {
        assertEquals(13, tpb.getSpareFrameScore(3));
    }

    @Test
    public void aFrameThatIsAStrike_isASumOfTheFramePlusTheNextTwoRolls() {
         assertEquals(18, tpb.getStrikeFrameScore(3, 5));
    }

    @Test
    public void aFrameWithFirstRollWithScore10_isAStrike() {
        assertEquals(TenPinBowling.STRIKE, tpb.getFrameType(10, 0));
    }

    @Test
    public void aFrameWithFirstAndSecondRollSumTo10_isASpare() {
        assertEquals(TenPinBowling.SPARE, tpb.getFrameType(5, 5));
    }
}
