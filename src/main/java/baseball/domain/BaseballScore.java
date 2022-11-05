package baseball.domain;

public class BaseballScore {
    private final Ball ball;
    private final Strike strike;

    private BaseballScore(int ballCount, int strikeCount) {
        this.ball = Ball.from(ballCount);
        this.strike = Strike.from(strikeCount);
    }

    public static BaseballScore of(int ballCount, int strikeCount) {
        return new BaseballScore(ballCount, strikeCount);
    }

    public boolean isZeroBall() {
        return this.ball == Ball.ZERO;
    }

    public boolean isOneBall() {
        return this.ball == Ball.ONE;
    }

    public boolean isTwoBall() {
        return this.ball == Ball.TWO;
    }

    public boolean isThreeBall() {
        return this.ball == Ball.THREE;
    }

    public boolean isZeroStrike() {
        return this.strike == Strike.ZERO;
    }

    public boolean isOneStrike() {
        return this.strike == Strike.ONE;
    }

    public boolean isTwoStrike() {
        return this.strike == Strike.TWO;
    }

    public boolean isThreeStrike() {
        return this.strike == Strike.THREE;
    }
}
