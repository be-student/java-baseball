package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UniqueDigitsTest {
    @DisplayName("잘 작동하는 경우 체크")
    @Test
    void 잘_작동함() {
        assertDoesNotThrow(() -> {
            UniqueDigits.from(123);
        });
    }

    @DisplayName("1000이상의 숫자일 때 에러")
    @Test
    void 최대_초과() {
        assertThrows(IllegalArgumentException.class, () -> UniqueDigits.from(1000));
    }

    @DisplayName("1000이상의 숫자일 때 에러")
    @Test
    void 최소_범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> UniqueDigits.from(98));
    }

    @DisplayName("중복이 있는 숫자일 경우 에러를 만듦")
    @Test
    void 중복_숫자() {
        assertThrows(IllegalArgumentException.class, () -> UniqueDigits.from(112));
    }
}
