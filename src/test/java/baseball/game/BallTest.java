package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallTest {
    @DisplayName("ball이 잘 생성됨")
    @Test
    void 잘_작동_테스트() {
        assertDoesNotThrow(() -> {
            Ball.from(0);
            Ball.from(1);
            Ball.from(2);
            Ball.from(3);
        });
    }

    @DisplayName("ball이 0~3이 끝이 아님")
    @Test
    void ball_에러_체크() {
        assertThrows(IllegalArgumentException.class, () -> Ball.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Ball.from(4));
    }
}
