
public class TenPinBowling {

    private int TOTAL_FRAME_SCORE = 10;

    public int getFrameScore(int i, int j) {
        return i + j;
    }

    public int getSpareFrameScore(int i) {
        return TOTAL_FRAME_SCORE + i;
    }
}
