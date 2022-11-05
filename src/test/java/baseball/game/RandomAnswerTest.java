package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RandomAnswerTest {
    @DisplayName("Random 값을 생성할 수 있음")
    @Test
    void 잘_작동함() {
        assertDoesNotThrow(RandomAnswer::createRandom);
    }
}
