package baseball.domain;

public class GameResultDto {

    private final int strike;
    private final int ball;

    public GameResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
