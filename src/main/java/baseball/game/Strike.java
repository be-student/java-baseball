package baseball.game;

import java.util.Arrays;

/**
 * 한 게임에서 나오는 스트라이크의 수를 관리하는 enum
 * 0,1,2,3까지 스트라이크를 나타낼 수 있음
 */
public enum Strike {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);
    private final int value;

    Strike(int value) {
        this.value = value;
    }

    public static Strike from(int value) {
        return Arrays.stream(Strike.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}