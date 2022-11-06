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

/**
 * 야구 게임 1경기를 진행하는 역할을 가지고 있습니다
 */
public class Game {
    private final InputView inputView;
    private final OutputView outputView;
    private RandomAnswer randomAnswer;

    private Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 생성시에 input, output이 모두 결정되어 있어야 합니다
     *
     * @param inputView  입력의 방식이 담긴 구현체를 인자로 받습니다
     * @param outputView 출력 방식이 담긴 구현체를 인자로 받습니다
     * @return 게임 객체를 반환합니다
     */
    public static Game of(InputView inputView, OutputView outputView) {
        return new Game(inputView, outputView);
    }

    public void run() {
        initGame();
        BaseballScore score = BaseballScore.ZERO();
        while (!score.isThreeStrike()) {
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
        printInputMessage();
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
        if (score.isNothing()) {
            outputView.print(NOTHING);
        }
    }

    private void printEndMessage() {
        outputView.print(ALL_CORRECT);
    }
}
