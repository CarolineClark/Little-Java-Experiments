
public class TenPinBowling {

    private int[] frames = new int[10];
    private int[] rolls = new int[20];
    private int rollCounter = 0;

    public static int NORMAL = 0;
    public static int SPARE = 1;
    public static int STRIKE = 2;

    private static int TOTAL_FRAME_SCORE = 10;

    int getTurn(int i, int j) {
        return i + j;
    }

    int getSpareTurn(int i) {
        return TOTAL_FRAME_SCORE + i;
    }

    int getStrikeTurn(int i, int j) {
        return TOTAL_FRAME_SCORE + i + j;
    }

    int getFrameType(int i, int j) {
        if (i == TOTAL_FRAME_SCORE) {
            return STRIKE;
        } else if (i + j == TOTAL_FRAME_SCORE) {
            return SPARE;
        } else {
            return NORMAL;
        }
    }

    void setNextRoll(int i) {
        rolls[rollCounter] = i;
        rollCounter++;
    }

    void calculateFrame(int i) {
        int type = getFrameType(rolls[i], rolls[i + 1]);
        if (type == NORMAL) {
            if (i >= 1) {
                frames[i] = getTurn(rolls[i], rolls[i + 1]) + frames[i - 1];
            }
            else {
                frames[i] = getTurn(rolls[i], rolls[i + 1]);
            }
        }
    }

    int getFrame(int i) {
        return frames[i];
    }
}
