package baseball.domain;

import baseball.config.ControllerConstants;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    private BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static BaseballController from(InputView inputView, OutputView outputView) {
        return new BaseballController(inputView, outputView);
    }

    public void run() {
        initController();
        while (true) {
            Game.of(inputView, outputView).run();
            printRetryMessage();
            if (ControllerInput.from(inputView).getInput() == ControllerConstants.FINISH) {
                return;
            }
        }
    }

    private void initController() {
        printInitMessage();
    }

    private void printInitMessage() {
        outputView.print("숫자 야구 게임을 시작합니다.\n");
    }

    private void printRetryMessage() {
        outputView.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}
