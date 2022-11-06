package baseball.game;

import static baseball.config.GameConstants.BASEBALL_LENGTH;

/**
 * 점수 계산을 담당하는 클래스 입니다
 */
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

    /**
     * 볼, 스트라이크 점수를 계산하는 객체를 반환합니다
     *
     * @param player       사용자가 입력한 중복 없는 숫자를 의미합니다
     * @param randomAnswer 컴퓨터가 랜덤하게 생성한 3자리 숫자를 의미합니다
     * @return 점수가 담긴 객체를 반환합니다
     */
    public static BaseballScore of(UniqueDigits player, RandomAnswer randomAnswer) {
        return new BaseballScore(player, randomAnswer);
    }

    /**
     * 0점에 해당하는 BaseballScore 객체를 반환합니다
     *
     * @return strike, ball이 모두 0점인 BaseballScore 객체
     */
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

    /**
     * strike, ball 모두 0점인 여부를 반환합니다
     *
     * @return 모두 0점이라면 true
     */
    public boolean isNothing() {
        return this.isZeroBall() && this.isZeroStrike();
    }

    /**
     * ball이 0점인지를 반환합니다
     *
     * @return ball이 0점이라면 true
     */
    public boolean isZeroBall() {
        return this.ball == Ball.ZERO;
    }

    /**
     * ball이 1점인지를 반환합니다
     *
     * @return ball이 1점이라면 true
     */
    public boolean isOneBall() {
        return this.ball == Ball.ONE;
    }

    /**
     * ball이 2점인지를 반환합니다
     *
     * @return ball이 2점이라면 true
     */

    public boolean isTwoBall() {
        return this.ball == Ball.TWO;
    }

    /**
     * ball이 3점인지를 반환합니다
     *
     * @return ball이 3점이라면 true
     */

    public boolean isThreeBall() {
        return this.ball == Ball.THREE;
    }

    /**
     * strike이 0점인지를 반환합니다
     *
     * @return strike가 0점이라면 true
     */

    public boolean isZeroStrike() {
        return this.strike == Strike.ZERO;
    }

    /**
     * strike이 1점인지를 반환합니다
     *
     * @return strike가 1점이라면 true
     */

    public boolean isOneStrike() {
        return this.strike == Strike.ONE;
    }

    /**
     * strike이 2점인지를 반환합니다
     *
     * @return strike가 2점이라면 true
     */

    public boolean isTwoStrike() {
        return this.strike == Strike.TWO;
    }

    /**
     * strike이 3점인지를 반환합니다
     *
     * @return strike가 3점이라면 true
     */

    public boolean isThreeStrike() {
        return this.strike == Strike.THREE;
    }
}
