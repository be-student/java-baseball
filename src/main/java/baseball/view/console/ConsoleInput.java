package baseball.view.console;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

/**
 * 숫자 야구에서 콘솔을 통해서 입력을 받는 구현체
 */
public class ConsoleInput implements InputView {
    /**
     * @return InputView ConsoleInput 객체를 반환한다
     */
    public static InputView getInstance() {
        return new ConsoleInput();
    }

    /**
     * @return String Console.readLine();을 통해서 얻은 결과를 반환한다
     */
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
