package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import baseball.util.PlayerInput;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;
import static baseball.config.BaseballConstant.FINISH;
import static baseball.config.BaseballConstant.RETRY;
import static baseball.view.SystemOutView.endMessage;
import static baseball.view.SystemOutView.initialMessage;
import static baseball.view.SystemOutView.resultMessage;

public class BaseballController {
    private static final int NOT_SELECTED = 0;
    private final BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
        initGame();
    }

    public void run() {
        int input = PlayerInput.playerTry();
        BaseballScore score = baseballService.run(input);
        resultMessage(score);

        int playerChoice = NOT_SELECTED;

        if (score.getStrikeCount() == BASEBALL_LENGTH) {
            //Todo 게임이 종료 되는 것, 종료 검증, 종료 후 해야할 일들 분리하기
            endMessage();
            //Todo Enum
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

    //Todo 한 번만 호출한다
    private void initGame() {
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballService.init(baseballNumber);
        initialMessage();
    }
}
