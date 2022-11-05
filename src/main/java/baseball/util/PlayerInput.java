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
            boolean isRetryInputValid = playerChoice == RETRY || playerChoice == FINISH;
            if (!isRetryInputValid) {
                throw new IllegalArgumentException("1,2 외에 다른 입력이 들어왔습니다");
            }
            //목적을 뒤로
            return playerChoice;
        } catch (IllegalArgumentException e) {
            //Todo err 출력
            System.err.println(e.getMessage());
            throw new IllegalArgumentException("재시도 함수에서 에러가 발생했습니다", e);
        }
    }


    public static int playerTry() {
        try {
            inputMessage();
            String lineChoice = Console.readLine();
            return Integer.parseInt(lineChoice);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("사용자의 숫자 입력 함수에서 에러가 발생했습니다", e);
        }
    }
}
