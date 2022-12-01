package baseball.adapter.in.game;

import baseball.domain.GameResultDto;

public final class ClientOutputView {

    private static final int BASEBALL_LENGTH = 3;
    private static final int NOTHING = 0;

    void printResult(GameResultDto gameResultDto) {
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

    void printRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    void printNumberMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }


    void printInputMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
