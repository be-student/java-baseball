package baseball;

import baseball.domain.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.console.ConsoleInput;
import baseball.view.console.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = ConsoleInput.getInstance();
        OutputView outputView = ConsoleOutput.getInstance();
        BaseballController.from(inputView, outputView).run();
    }
}
