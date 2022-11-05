package baseball.controller;

import baseball.config.ControllerConstants;
import baseball.game.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.ControllerMessages.INIT_MESSAGE;
import static baseball.config.ControllerMessages.RETRY_MESSAGE;

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
        ControllerConstants choice = ControllerConstants.RETRY;
        while (choice == ControllerConstants.RETRY) {
            Game.of(inputView, outputView).run();
            printRetryMessage();
            choice = ControllerInput.from(inputView).getInput();
        }
    }

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
