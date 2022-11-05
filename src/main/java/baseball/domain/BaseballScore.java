package baseball.domain;

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
//Todo 어떤 플랫폼에서 사용될 것인지 고려 다른 플랫폼으로 바꾼다면 어떤게 바뀔 것인지
//다른 입력 방식, 출력 방식 고민할 것