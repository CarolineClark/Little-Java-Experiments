
public class TenPinBowling {

    private int TOTAL_FRAME_SCORE = 10;

    int getFrameScore(int i, int j) {
        return i + j;
    }

    int getSpareFrameScore(int i) {
        return TOTAL_FRAME_SCORE + i;
    }
}
