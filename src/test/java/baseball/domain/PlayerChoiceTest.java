package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerChoiceTest {
    @Test
    void case1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PlayerChoice(1000);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new PlayerChoice(99);
        });
    }

    @Test
    void case2() {
        assertThat(new PlayerChoice(100));
        assertThat(new PlayerChoice(999));
    }
}
