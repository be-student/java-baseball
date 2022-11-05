package baseball.view;

/**
 * 이 인터페이스를 구현하면
 * 숫자 야구 게임의 출력을 이 인터페이스를 통해 진행할 수 있다
 */
public interface OutputView {
    /**
     * @param content 출력할 내용을 담는다
     */
    void print(String content);
}
