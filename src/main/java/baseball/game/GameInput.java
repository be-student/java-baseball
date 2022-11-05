package baseball.game;

import baseball.view.InputView;

import static baseball.config.GameMessages.INPUT_ERROR_MESSAGE;

/**
 * 게임을 진행하는데 생기는 입력을 모두 담당합니다
 * 사용자로부터 중복이 없는 숫자 1줄을 받아 반환합니다
 * 중복이 있거나, 범위를 넘어가면 IllegalArgumentException을 발생시킵니다
 */
public class GameInput {
    private final InputView inputView;

    private GameInput(InputView inputView) {
        this.inputView = inputView;
    }

    public static GameInput from(InputView input) {
        return new GameInput(input);
    }

    public UniqueDigits getInputNumber() {
        try {
            String inputLine = inputView.readLine();
            int digits = Integer.parseInt(inputLine);
            return UniqueDigits.from(digits);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE, e);
        }
    }
}
