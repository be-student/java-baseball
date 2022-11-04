package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.PlayerChoice;
import baseball.util.PlayerInput;

import java.util.Arrays;
import java.util.List;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;
import static baseball.view.SystemOutView.resultMessage;

public class BaseballService {
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
            resultMessage(playerScore.get(0), playerScore.get(1));
            if (playerScore.get(0) == 3) {
                return;
            }
        }
    }

    private List<Integer> getPlayerScore(PlayerChoice choice) {
        List<Integer> answer = Arrays.asList(0, 0);
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (choice.getInput(i) == number.getNumber().get(i)) {
                answer.set(0, answer.get(0) + 1);
                continue;
            }
            if (number.getNumber().contains(choice.getInput(i))) {
                answer.set(1, answer.get(1) + 1);
            }
        }
        return answer;
    }

}
