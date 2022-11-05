package baseball.config;

/**
 * Controller에서 출력을 위해 사용되는 모든 메시지들을 모아놓은 클래스
 */
public class ControllerMessages {
    public static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static final String CONTROLLER_ERROR_MESSAGE = "1,2의 입력만 들어와야 합니다";

    private ControllerMessages() {
    }
}
