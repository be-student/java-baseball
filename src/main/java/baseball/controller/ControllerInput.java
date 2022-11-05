package baseball.controller;

import baseball.config.ControllerConstants;
import baseball.view.InputView;

import static baseball.config.ControllerMessages.CONTROLLER_ERROR_MESSAGE;

public class ControllerInput {
    private final InputView inputView;

    private ControllerInput(InputView inputView) {
        this.inputView = inputView;
    }

    public static ControllerInput from(InputView inputView) {
        return new ControllerInput(inputView);
    }

    public ControllerConstants getInput() {
        try {
            String inputLine = inputView.readLine();
            return ControllerConstants.from(Integer.parseInt(inputLine));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw new IllegalArgumentException(CONTROLLER_ERROR_MESSAGE, e);
        }

    }
}
