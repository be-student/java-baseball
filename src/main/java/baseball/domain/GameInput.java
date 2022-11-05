package baseball.domain;

import baseball.view.InputView;

public class GameInput {
    private static final String INPUT_ERROR_MESSAGE = "입력값은 100~999사이 중복 없는 숫자여야 합니다.";
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
