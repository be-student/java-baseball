package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.PlayerChoice;
import baseball.dto.BaseballScore;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;

public class BaseballService {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;
    private BaseballNumber number;

    public BaseballService() {
    }

    public void init(BaseballNumber number) {
        this.number = number;
    }

    public BaseballScore run(int input) {
        PlayerChoice choice = new PlayerChoice(input);
        return getPlayerScore(choice);
    }

    private BaseballScore getPlayerScore(PlayerChoice choice) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < BASEBALL_LENGTH; i++) {
            if (number.isStrike(i, choice.getInput(i))) {
                strikeCount++;
                continue;
            }
            if (number.isBall(i, choice.getInput(i))) {
                ballCount++;
            }
        }
        return new BaseballScore(strikeCount, ballCount);
    }

}
