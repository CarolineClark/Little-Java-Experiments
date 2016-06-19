import java.util.Arrays;

public class TenPinBowling {

    public static int NORMAL = 0;
    public static int SPARE = 1;
    public static int STRIKE = 2;
    private static int TOTAL_FRAME_SCORE = 10;

    private int[] frames;
    private int[] rolls;
    private int rollCounter;

    public TenPinBowling() {
        frames = new int[TOTAL_FRAME_SCORE];
        Arrays.fill(frames, -1);

        rolls = new int[TOTAL_FRAME_SCORE * 2];
        Arrays.fill(rolls, -1);

        rollCounter = 0;
    }

    int getNormalTurn(int i, int j) {
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
            frames[i] = getNormalTurn(rolls[i], rolls[i + 1]);
        } else if (type == SPARE) {
            frames[i] = getSpareTurn(rolls[i + 2]);
        } else {
            frames[i] = getStrikeTurn(rolls[i + 2], rolls[i + 3]);
        }
        if (i >= 1) {
            frames[i] += frames[i - 1];
        }
    }

    int getFrame(int i) {
        return frames[i];
    }
}
