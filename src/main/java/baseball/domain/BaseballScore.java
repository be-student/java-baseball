package baseball.domain;

public class BaseballScore {
    private final Ball ball;
    private final Strike strike;

    private BaseballScore(UniqueDigits player, RandomAnswer computer) {
        int ballCount = calculateBallCount(player, computer);
        int strikeCount = calculateStrikeCount(player, computer);
        this.ball = Ball.from(ballCount);
        this.strike = Strike.from(strikeCount);
    }

    public static BaseballScore of(UniqueDigits player, RandomAnswer randomAnswer) {
        return new BaseballScore(player, randomAnswer);
    }

    private int calculateBallCount(UniqueDigits player, RandomAnswer computer) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            if (!player.digitWithIndex(i).equals(computer.digitWithIndex(i)) && player.contains(computer.digitWithIndex(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int calculateStrikeCount(UniqueDigits player, RandomAnswer computer) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (player.digitWithIndex(i).equals(computer.digitWithIndex(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
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
