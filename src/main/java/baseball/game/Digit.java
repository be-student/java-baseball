package baseball.game;

import java.util.Arrays;

/**
 * 1자리 숫자를 관리하는 enum입니다
 */
public enum Digit {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int value;

    Digit(int value) {
        this.value = value;
    }

    /**
     * 0~9까지 정수를 enum의 형태로 바꿔줍니다
     *
     * @param value 0부터 9까지 정수
     * @return 각 숫자에 해당하는 enum을 만듭니다
     */
    public static Digit from(int value) {
        return Arrays.stream(Digit.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    /**
     * @return enum의 실제 숫자를 정수 형태로 반환합니다
     */
    public int toInt() {
        return value;
    }
}
