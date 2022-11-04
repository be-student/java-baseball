package baseball.dto;

public class BaseballScore {
    private final int strikeCount;
    private final int ballCount;

    public BaseballScore(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
