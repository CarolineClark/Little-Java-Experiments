
public class TenPinBowling {

    public static int NORMAL = 0;
    public static int SPARE = 1;
    public static int STRIKE = 2;

    private static int TOTAL_FRAME_SCORE = 10;

    int getFrameScore(int i, int j) {
        return i + j;
    }

    int getSpareFrameScore(int i) {
        return TOTAL_FRAME_SCORE + i;
    }

    int getStrikeFrameScore(int i, int j) {
        return TOTAL_FRAME_SCORE + i + j;
    }

    int getFrameType(int i, int j) {
        return STRIKE;
    }
}
