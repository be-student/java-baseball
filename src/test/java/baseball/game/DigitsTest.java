package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitsTest {
    @DisplayName("Digits 일급 컬렉션이 잘 작동함")
    @Test
    void 잘_작동() {
        Digits digits = Digits.create();
        assertThat(digits.size()).isEqualTo(0);
        Digit ZERO = Digit.from(0);

        digits.add(ZERO);
        assertThat(digits.size()).isEqualTo(1);

        assertThat(digits.contains(ZERO)).isEqualTo(true);
        assertThat(digits.size()).isEqualTo(1);

        digits.add(ZERO);
        assertThat(digits.size()).isEqualTo(2);
        assertThat(digits.uniqueSize()).isEqualTo(1);
    }
}
