package baseball.game;

import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.config.GameMessages.ALL_CORRECT;
import static baseball.config.GameMessages.INPUT_MESSAGE;
import static baseball.config.GameMessages.NOTHING;
import static baseball.config.GameMessages.ONE_BALL;
import static baseball.config.GameMessages.ONE_STRIKE;
import static baseball.config.GameMessages.THREE_BALL;
import static baseball.config.GameMessages.THREE_STRIKE;
import static baseball.config.GameMessages.TWO_BALL;
import static baseball.config.GameMessages.TWO_STRIKE;

public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private RandomAnswer randomAnswer;

    private Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static Game of(InputView inputView, OutputView outputView) {
        return new Game(inputView, outputView);
    }

    public void run() {
        initGame();
        BaseballScore score = BaseballScore.ZERO();

        while (!score.isThreeStrike()) {
            printInputMessage();
            UniqueDigits playerInput = getPlayerInput();
            score = BaseballScore.of(playerInput, randomAnswer);
            printResultMessage(score);
        }

        printEndMessage();
    }

    public void initGame() {
        this.randomAnswer = RandomAnswer.createRandom();
    }

    private void printInputMessage() {
        outputView.print(INPUT_MESSAGE);
    }

    private UniqueDigits getPlayerInput() {
        return GameInput.from(inputView).getInputNumber();
    }

    private void printResultMessage(BaseballScore score) {
        printBallMessage(score);
        printStrikeMessage(score);
        printNothingMessage(score);
        outputView.print("\n");
    }

    private void printBallMessage(BaseballScore score) {
        if (score.isOneBall()) {
            outputView.print(ONE_BALL);
            return;
        }
        if (score.isTwoBall()) {
            outputView.print(TWO_BALL);
            return;
        }
        if (score.isThreeBall()) {
            outputView.print(THREE_BALL);
        }
    }

    private void printStrikeMessage(BaseballScore score) {
        if (score.isOneStrike()) {
            outputView.print(ONE_STRIKE);
            return;
        }
        if (score.isTwoStrike()) {
            outputView.print(TWO_STRIKE);
            return;
        }
        if (score.isThreeStrike()) {
            outputView.print(THREE_STRIKE);
        }
    }

    private void printNothingMessage(BaseballScore score) {
        if (score.isZeroBall() && score.isZeroStrike()) {
            outputView.print(NOTHING);
        }
    }

    private void printEndMessage() {
        outputView.print(ALL_CORRECT);
    }
}
