package baseball.view;

/**
 * 이 인터페이스를 구현하면
 * 숫자 야구 게임의 입력을 이 인터페이스를 통해 진행할 수 있다
 */
public interface InputView {
    /**
     * @return String 사용자가 입력이 가능한 환경에서 입력한 결과물
     */
    String readLine();
}
