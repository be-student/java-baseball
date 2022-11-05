package baseball.game;

import baseball.view.InputView;

import static baseball.config.GameMessages.INPUT_ERROR_MESSAGE;

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
