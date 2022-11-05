package baseball.domain;

import baseball.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameInputTest {
    @DisplayName("잘 작동함")
    @Test
    void 잘_작동함() {
        InputView mockInputView = new InputView() {
            @Override
            public String readLine() {
                return "123";
            }
        };

        assertDoesNotThrow(() -> {
            GameInput.from(mockInputView).getInputNumber();
        });
    }

    @DisplayName("숫자가 아닌 값이 있을 경우 에러 체크")
    @Test
    void not_number() {
        InputView mockInputView = new InputView() {
            @Override
            public String readLine() {
                return "12a";
            }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.from(mockInputView).getInputNumber();
        });
    }

    @DisplayName("숫자가 99이하로 들어왔을 경우 에러")
    @Test
    void 너무_작은_숫자() {
        InputView mockInputView = new InputView() {
            @Override
            public String readLine() {
                return "98";
            }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.from(mockInputView).getInputNumber();
        });
    }

    @DisplayName("숫자가 99이하로 들어왔을 경우 에러")
    @Test
    void 너무_큰_숫자() {
        InputView mockInputView = new InputView() {
            @Override
            public String readLine() {
                return "1234";
            }
        };

        assertThrows(IllegalArgumentException.class, () -> {
            GameInput.from(mockInputView).getInputNumber();
        });
    }
}
