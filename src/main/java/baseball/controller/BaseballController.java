package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.dto.BaseballScore;
import baseball.service.BaseballService;
import baseball.util.PlayerInput;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;
import static baseball.config.BaseballConstant.FINISH;
import static baseball.config.BaseballConstant.RETRY;
import static baseball.view.SystemOutView.endMessage;
import static baseball.view.SystemOutView.initialMessage;
import static baseball.view.SystemOutView.resultMessage;

public class BaseballController {
    private final BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
        initGame();
    }

    public void run() {
        int input = PlayerInput.playerTry();
        BaseballScore score = baseballService.run(input);
        resultMessage(score);

        int playerChoice = 0;

        if (score.getStrikeCount() == BASEBALL_LENGTH) {
            endMessage();
            playerChoice = PlayerInput.retry();
        }
        if (playerChoice == FINISH) {
            return;
        }
        if (playerChoice == RETRY) {
            initGame();
        }
        run();
    }

    private void initGame() {
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballService.init(baseballNumber);
        initialMessage();
    }
}
