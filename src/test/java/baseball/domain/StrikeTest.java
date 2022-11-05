package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StrikeTest {
    @DisplayName("스트라이크가 잘 생성됨")
    @Test
    void 잘_작동함() {
        assertDoesNotThrow(() -> {
            Strike.from(0);
            Strike.from(1);
            Strike.from(2);
            Strike.from(3);
        });
    }

    @DisplayName("스트라이크가 범위바깥 에러 발생")
    @Test
    void 에러_발생() {
        assertThrows(IllegalArgumentException.class, () -> Strike.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Strike.from(4));
    }
}
