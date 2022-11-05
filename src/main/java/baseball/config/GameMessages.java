package baseball.config;

public class GameMessages {
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String ONE_BALL = "1볼 ";
    public static final String TWO_BALL = "2볼 ";
    public static final String THREE_BALL = "3볼 ";
    public static final String ONE_STRIKE = "1스트라이크";
    public static final String TWO_STRIKE = "2스트라이크";
    public static final String THREE_STRIKE = "3스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public static final String INPUT_ERROR_MESSAGE = "입력값은 100~999사이 중복 없는 숫자여야 합니다.";
    public static final String LIBRARY_ERROR_MESSAGE = "random 라이브러리가 잘못되었습니다";

    public static final String OVER_RANGE_MESSAGE = "입력이 999를 초과했습니다";
    public static final String LESS_RANGE_MESSAGE = "입력이 100보다 작았습니다";
    public static final String DUPLICATE_INPUT_MESSAGE = "입력에 중복값이 있습니다";

    private GameMessages() {
    }
}
