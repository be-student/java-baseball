package baseball.game;

import java.util.Arrays;

/**
 * 1자리 숫자를 관리하는 enum입니다
 */
public enum Digit {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4),
    FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    private final int value;

    Digit(int value) {
        this.value = value;
    }

    public static Digit from(int value) {
        return Arrays.stream(Digit.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @return enum의 실제 숫자를 반환합니다
     */
    public int getValue() {
        return value;
    }
}
