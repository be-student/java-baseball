package baseball.domain;

import baseball.config.ControllerConstants;
import baseball.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerInputTest {
    @DisplayName("인풋을 잘 읽어온다")
    @Test
    void 인풋_잘_읽어옴() {
        InputView inputView = new InputView() {
            @Override
            public String readLine() {
                return "1";
            }
        };
        assertThat(ControllerInput.from(inputView)
                .getInput())
                .isEqualTo(
                        ControllerConstants.valueOf("RETRY"));
    }

    @DisplayName("input에 1,2외의 문자열이 들어온다")
    @Test
    void 인풋_에러() {
        InputView inputView = new InputView() {
            @Override
            public String readLine() {
                return "hello";
            }
        };
        assertThrows(IllegalArgumentException.class,
                () -> ControllerInput.from(inputView)
                        .getInput());
    }
}
