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
    public void aTurnThatIsNotASpareOrStrike_isASumOfTheIndividualRolls() {
        assertEquals(3, tpb.getNormalTurn(2, 1));
    }

    @Test
    public void aTurnThatIsASpare_isASumOfTheTurnPlusTheNextRoll() {
        assertEquals(13, tpb.getSpareTurn(3));
    }

    @Test
    public void aTurnThatIsAStrike_isASumOfTheTurnPlusTheNextTwoRolls() {
         assertEquals(18, tpb.getStrikeTurn(3, 5));
    }

    @Test
    public void aTurnWithFirstRollWithScore10_isAStrike() {
        assertEquals(TenPinBowling.STRIKE, tpb.getFrameType(10, 0));
    }

    @Test
    public void aTurnWithFirstAndSecondRollSumTo10_isASpare() {
        assertEquals(TenPinBowling.SPARE, tpb.getFrameType(5, 5));
    }

    @Test
    public void aTurnWithFirstAndSecondRollNotSumTo10_isANormalTurn() {
        assertEquals(TenPinBowling.NORMAL, tpb.getFrameType(3, 3));
    }

    @Test
    public void firstFrameAfterNormalTurn_isTurnScore() {
        // When
        tpb.setNextRoll(3);
        tpb.setNextRoll(5);
        tpb.calculateFrame(0);

        // Then
        assertEquals(8, tpb.getFrame(0));
    }

    @Test
    public void secondFrameAfterNormalTurn_isSumOfTurnScorePlusFirstFrame() {
        // When
        tpb.setNextRoll(3);
        tpb.setNextRoll(5);
        tpb.calculateFrame(0);
        tpb.setNextRoll(3);
        tpb.setNextRoll(5);
        tpb.calculateFrame(1);

        // Then
        assertEquals(16, tpb.getFrame(1));
    }

    @Test
    public void firstFrameAfterSpareTurn_isTurnScore() {
        // When
        tpb.setNextRoll(5);
        tpb.setNextRoll(5);
        tpb.setNextRoll(3);
        tpb.calculateFrame(0);

        // Then
        assertEquals(13, tpb.getFrame(0));
    }

    @Test
    public void firstFrameAfterStrikeTurn_isTurnScore() {
        // When
        tpb.setNextRoll(10);
        tpb.setNextRoll(0);
        tpb.setNextRoll(3);
        tpb.setNextRoll(5);
        tpb.calculateFrame(0);

        // Then
        assertEquals(18, tpb.getFrame(0));
    }

}
