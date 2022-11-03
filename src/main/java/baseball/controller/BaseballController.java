package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.service.BaseballService;
import baseball.util.PlayerInput;

import static baseball.view.SystemOutView.*;

public class BaseballController {
    private static final int FINISH=2;
    private BaseballService baseballService;
    private BaseballNumber baseballNumber;


    public BaseballController() {
        this.baseballService = new BaseballService();
    }


    public void run() {
        while (true) {
            initGame();
            baseballService.run();
            retryMessage();
            int playerChoice= PlayerInput.retry();
            if(playerChoice==FINISH){
                return;
            }
        }
    }

    private void initGame() {
        this.baseballNumber = new BaseballNumber();
    }
}
