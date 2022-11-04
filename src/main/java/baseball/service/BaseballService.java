package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.PlayerChoice;
import baseball.util.PlayerInput;

import java.util.Arrays;
import java.util.List;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;
import static baseball.view.SystemOutView.endMessage;
import static baseball.view.SystemOutView.resultMessage;

public class BaseballService {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private BaseballNumber number;

    public BaseballService() {
    }

    public void init(BaseballNumber number) {
        this.number = number;
    }

    public void run() {
        while (true) {
            int input = PlayerInput.playerTry();
            PlayerChoice choice = new PlayerChoice(input);
            List<Integer> playerScore = getPlayerScore(choice);
            resultMessage(playerScore.get(BALL_INDEX), playerScore.get(STRIKE_INDEX));
            if (playerScore.get(STRIKE_INDEX) == BASEBALL_LENGTH) {
                endMessage();
                return;
            }
        }
    }

    private List<Integer> getPlayerScore(PlayerChoice choice) {
        List<Integer> answer = Arrays.asList(0, 0);
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (number.isStrike(i, choice.getInput(i))) {
                answer.set(STRIKE_INDEX, answer.get(STRIKE_INDEX) + 1);
                continue;
            }
            if (number.isBall(choice.getInput(i))) {
                answer.set(BALL_INDEX, answer.get(BALL_INDEX) + 1);
            }
        }
        return answer;
    }

}
