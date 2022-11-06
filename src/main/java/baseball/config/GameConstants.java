package baseball.config;

/**
 * Game에서 사용되는 모든 상수들을 모아놓은 클래스
 */
public class GameConstants {
    /**
     * 이 숫자 미만의 값이 게임 도중 들어오면 IllegalArgumentException을 반환한다
     */
    public static final int MIN_INPUT_INCLUSIVE = 100;
    /**
     * 이 숫자를 초과하는 값이 게임 도중 들어오면 IllegalArgumentException을 반환한다
     */
    public static final int MAX_INPUT_INCLUSIVE = 999;
    /**
     * 숫자 야구 게밍의 총 자릿수를 의미합니다
     * 3은 3자리로 100~999까지의 숫자가 정답이 될 수 있습니다
     */
    public static final int BASEBALL_LENGTH = 3;

    private GameConstants() {
    }
}
