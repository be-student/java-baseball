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

    /**
     * InputView에 해당하는 객체를 받아서 게임에서 input을 받을 때 사용하는
     * 객체를 반환해주는 정적 팩토리 메서드
     *
     * @param input InputView를 구현한 객체
     * @return GameInput에 해당하는 객체
     */
    public static GameInput from(InputView input) {
        return new GameInput(input);
    }

    /**
     * inputView에 해당하는 객체를 통해서 숫자를 받고 이를 반한합니다
     * 중복이 있거나, input의 범위에 넘어가는 숫자일 경우 IllegalArgumentException
     *
     * @return 중복이 없는 숫자를 반환합니다
     */
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
