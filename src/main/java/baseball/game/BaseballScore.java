package baseball.game;

import static baseball.config.GameConstants.BASEBALL_LENGTH;

public class BaseballScore {
    private final Ball ball;
    private final Strike strike;

    private BaseballScore(UniqueDigits player, RandomAnswer computer) {
        int ballCount = calculateBallCount(player, computer);
        int strikeCount = calculateStrikeCount(player, computer);
        this.ball = Ball.from(ballCount);
        this.strike = Strike.from(strikeCount);
    }

    private BaseballScore() {
        this.ball = Ball.ZERO;
        this.strike = Strike.ZERO;
    }

    public static BaseballScore of(UniqueDigits player, RandomAnswer randomAnswer) {
        return new BaseballScore(player, randomAnswer);
    }

    public static BaseballScore ZERO() {
        return new BaseballScore();
    }

    private int calculateBallCount(UniqueDigits player, RandomAnswer computer) {
        int ballCount = 0;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (isBall(player, computer, i)) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean isBall(UniqueDigits player, RandomAnswer computer, int index) {
        if (player.digitWithIndex(index).equals(computer.digitWithIndex(index))) {
            return false;
        }
        return player.contains(computer.digitWithIndex(index));
    }

    private int calculateStrikeCount(UniqueDigits player, RandomAnswer computer) {
        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (isStrike(player, computer, i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private boolean isStrike(UniqueDigits player, RandomAnswer computer, int index) {
        return player.digitWithIndex(index).equals(computer.digitWithIndex(index));
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
