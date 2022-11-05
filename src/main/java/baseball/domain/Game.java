package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

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
        outputView.print("숫자를 입력해주세요 : ");
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
            outputView.print("1볼 ");
            return;
        }
        if (score.isTwoBall()) {
            outputView.print("2볼 ");
            return;
        }
        if (score.isThreeBall()) {
            outputView.print("3볼 ");
        }
    }

    private void printStrikeMessage(BaseballScore score) {
        if (score.isOneStrike()) {
            outputView.print("1스트라이크");
            return;
        }
        if (score.isTwoStrike()) {
            outputView.print("2스트라이크");
            return;
        }
        if (score.isThreeStrike()) {
            outputView.print("3스트라이크");
        }
    }

    private void printNothingMessage(BaseballScore score) {
        if (score.isZeroBall() && score.isZeroStrike()) {
            outputView.print("낫싱");
        }
    }

    private void printEndMessage() {
        outputView.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }
}
