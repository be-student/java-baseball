package baseball.util;

import camp.nextstep.edu.missionutils.Console;

import static baseball.config.BaseballConstant.FINISH;
import static baseball.config.BaseballConstant.RETRY;
import static baseball.view.SystemOutView.inputMessage;
import static baseball.view.SystemOutView.retryMessage;

public class PlayerInput {
    private PlayerInput() {
    }

    public static int retry() {
        try {
            retryMessage();
            String lineChoice = Console.readLine();
            int playerChoice = Integer.parseInt(lineChoice);
            if (playerChoice == RETRY || playerChoice == FINISH) {
                return playerChoice;
            }
            throw new IllegalArgumentException("1,2 외에 다른 입력이 들어왔습니다");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("재시도 함수에서 에러가 발생했습니다");
        }
    }

    public static int playerTry() {
        try {
            inputMessage();
            String lineChoice = Console.readLine();
            return Integer.parseInt(lineChoice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("사용자의 숫자 입력 함수에서 에러가 발생했습니다");
        }
    }
}
