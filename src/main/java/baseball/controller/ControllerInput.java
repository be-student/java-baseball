package baseball.controller;

import baseball.config.ControllerConstants;
import baseball.view.InputView;

import static baseball.config.ControllerMessages.CONTROLLER_ERROR_MESSAGE;

/**
 * 컨트롤러에서 필요한 input을 얻는 클래스
 */
public class ControllerInput {
    private final InputView inputView;

    private ControllerInput(InputView inputView) {
        this.inputView = inputView;
    }

    /**
     * ControllerInput 객체를 반환하는 정적 팩토리 메서드
     *
     * @param inputView 입력 가능한 구현체
     * @return ControllerInput 객체
     */
    public static ControllerInput from(InputView inputView) {
        return new ControllerInput(inputView);
    }

    /**
     * 인풋을 얻도록 만드는 메서드
     *
     * @return 1, 2의 경우만을 허용하고, 이를 Enum으로 감싸서 반환함
     */
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
