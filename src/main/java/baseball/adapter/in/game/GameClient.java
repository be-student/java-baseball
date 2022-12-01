package baseball.adapter.in.game;

import baseball.application.port.in.GamePlayCommand;
import baseball.application.port.in.GameUseCase;
import baseball.domain.GameResultDto;

public class GameClient {

    private static final int BASEBALL_LENGTH = 3;
    private static final int NOTHING = 0;
    private final ClientInputView inputView;
    private final GameUseCase gameUseCase;

    public GameClient(GameUseCase gameUseCase, ClientInputView inputView) {
        this.gameUseCase = gameUseCase;
        this.inputView = inputView;
    }

    public void playGame() {
        printInputMessage();
        ClientChoice clientChoice = ClientChoice.RETRY;
        while (clientChoice != ClientChoice.QUIT) {
            gameUseCase.reset();
            playOneGame();
            clientChoice = askClientToQuitOrRetry();
        }
    }

    private void printInputMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void playOneGame() {
        while (!gameUseCase.finished()) {
            GamePlayCommand gamePlayCommand = askPlayerNumber();
            GameResultDto gameResultDto = gameUseCase.play(gamePlayCommand);
            printResult(gameResultDto);
        }
    }

    private GamePlayCommand askPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = inputView.readLine();
        return new GamePlayCommand(input);
    }

    private ClientChoice askClientToQuitOrRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = inputView.readLine();
        return ClientChoice.from(input);
    }

    private void printResult(GameResultDto gameResultDto) {
        if (isAllStrike(gameResultDto)) {
            printCompleteMessage();
            return;
        }
        if (isNothing(gameResultDto)) {
            printNothingMessage();
            return;
        }
        printBallAndStrike(gameResultDto);
    }


    private boolean isAllStrike(GameResultDto gameResultDto) {
        return gameResultDto.getStrike() == BASEBALL_LENGTH;
    }

    private void printCompleteMessage() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isNothing(GameResultDto gameResultDto) {
        return gameResultDto.getStrike() == NOTHING && gameResultDto.getBall() == NOTHING;
    }

    private void printNothingMessage() {
        System.out.println("낫싱");
    }

    private void printBallAndStrike(GameResultDto gameResultDto) {
        System.out.print(gameResultDto.getBall() + "볼 ");
        System.out.print(gameResultDto.getStrike() + "스트라이크");
        System.out.println();
    }
}
