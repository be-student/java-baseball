package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitTest {
    @DisplayName("0~9까지 숫자에서는 문제 없이 생성됨")
    @Test
    void 잘_작동() {
        assertThat(Digit.from(0)).isEqualTo(Digit.ZERO);
        assertThat(Digit.from(0).toInt()).isEqualTo(0);
        assertThat(Digit.from(1)).isEqualTo(Digit.ONE);
        assertThat(Digit.from(1).toInt()).isEqualTo(1);
        assertThat(Digit.from(2)).isEqualTo(Digit.TWO);
        assertThat(Digit.from(2).toInt()).isEqualTo(2);
        assertThat(Digit.from(3)).isEqualTo(Digit.THREE);
        assertThat(Digit.from(3).toInt()).isEqualTo(3);
        assertThat(Digit.from(4)).isEqualTo(Digit.FOUR);
        assertThat(Digit.from(4).toInt()).isEqualTo(4);
        assertThat(Digit.from(5)).isEqualTo(Digit.FIVE);
        assertThat(Digit.from(5).toInt()).isEqualTo(5);
        assertThat(Digit.from(6)).isEqualTo(Digit.SIX);
        assertThat(Digit.from(6).toInt()).isEqualTo(6);
        assertThat(Digit.from(7)).isEqualTo(Digit.SEVEN);
        assertThat(Digit.from(7).toInt()).isEqualTo(7);
        assertThat(Digit.from(8)).isEqualTo(Digit.EIGHT);
        assertThat(Digit.from(8).toInt()).isEqualTo(8);
        assertThat(Digit.from(9)).isEqualTo(Digit.NINE);
        assertThat(Digit.from(9).toInt()).isEqualTo(9);
    }

    @DisplayName("범위 바깥 에러")
    @Test
    void 에러() {
        assertThrows(IllegalArgumentException.class, () -> Digit.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Digit.from(10));
    }
}
