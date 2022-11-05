package baseball.view.console;

import baseball.view.OutputView;

/**
 * 숫자 야구에서 콘솔을 통해서 입력을 받는 구현체
 */
public class ConsoleOutput implements OutputView {
    private ConsoleOutput() {
    }

    /**
     * @return OutputView ConsoleOutput 객체를 반환한다
     */
    public static OutputView getInstance() {
        return new ConsoleOutput();
    }

    /**
     * @param content 출력할 내용을 담는다
     */
    @Override
    public void print(String content) {
        System.out.print(content);
    }
}
