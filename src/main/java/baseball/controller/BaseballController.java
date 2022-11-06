package baseball.controller;

import baseball.config.ControllerConstants;
import baseball.game.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.ControllerMessages.INIT_MESSAGE;
import static baseball.config.ControllerMessages.RETRY_MESSAGE;

/**
 * 게임을 구동시키는 컨트롤러의 역할을 하는 클래스
 */
public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;

    private BaseballController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 생성했을 때 input방식과, output방식이 결정 되어야 함
     *
     * @param inputView  입력을 담당하는 view
     * @param outputView 출력을 담당하는 view
     * @return 컨트롤러 객체를 리턴해줌
     */
    public static BaseballController from(InputView inputView, OutputView outputView) {
        return new BaseballController(inputView, outputView);
    }

    public void run() {
        initController();
        ControllerConstants choice = ControllerConstants.RETRY;
        while (choice != ControllerConstants.FINISH) {
            Game.of(inputView, outputView).run();

            choice = getRetryInput();
        }
    }

    private ControllerConstants getRetryInput() {
        printRetryMessage();
        return ControllerInput.from(inputView).getInput();
    }

    /**
     * 처음 컨트롤러가 구동되었을 때 시작해야 할 초기화 작업
     */
    private void initController() {
        printInitMessage();
    }

    private void printInitMessage() {
        outputView.print(INIT_MESSAGE);
    }

    private void printRetryMessage() {
        outputView.print(RETRY_MESSAGE);
    }
}
