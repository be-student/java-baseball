package baseball.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ControllerConstantsTest {
    @DisplayName("1,2가 들어왔을 때 잘 작동함")
    @Test
    void 잘_작동() {
        assertDoesNotThrow(() -> {
            ControllerConstants.from(1);
            ControllerConstants.from(2);
        });
    }

    @DisplayName("1,2가 아닐때 에러")
    @Test
    void 에러_발생() {
        assertThrows(IllegalArgumentException.class, () -> ControllerConstants.from(3));
    }
}
