package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.util.PlayerInput;

import static baseball.config.BaseballConstant.FINISH;
import static baseball.view.SystemOutView.initialMessage;
import static baseball.view.SystemOutView.retryMessage;

public class BaseballController {
    private final BaseballService baseballService;
    private BaseballNumber baseballNumber;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    public void run() {
        while (true) {
            initGame();
            baseballService.run();
            retryMessage();
            int playerChoice = PlayerInput.retry();
            if (playerChoice == FINISH) {
                return;
            }
        }
    }

    private void initGame() {
        this.baseballNumber = new BaseballNumber();
        baseballService.init(baseballNumber);
        initialMessage();
    }
}
