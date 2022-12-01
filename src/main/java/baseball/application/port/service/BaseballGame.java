package baseball.application.port.service;

import baseball.application.port.in.GamePlayCommand;
import baseball.application.port.in.GameUseCase;
import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumberGenerator;
import baseball.domain.GameResultDto;

public class BaseballGame implements GameUseCase {

    private static final int BASEBALL_LENGTH = 3;
    private final BaseballNumberGenerator generator;
    private BaseballNumber computerNumber;
    private BaseballNumber playerNumber;

    public BaseballGame(BaseballNumberGenerator generator) {
        this.generator = generator;
        computerNumber = generator.generate();
    }

    @Override
    public GameResultDto play(GamePlayCommand gamePlayCommand) {
        playerNumber = new BaseballNumber(gamePlayCommand.getPlayerInput());
        return computerNumber.calculateScore(playerNumber);
    }

    @Override
    public void reset() {
        computerNumber = generator.generate();
    }

    @Override
    public boolean finished() {
        if (isNotInitialized()) {
            return false;
        }
        return computerNumber.calculateScore(playerNumber)
                .getStrike() == BASEBALL_LENGTH;
    }

    private boolean isNotInitialized() {
        return playerNumber == null || computerNumber == null;
    }
}
