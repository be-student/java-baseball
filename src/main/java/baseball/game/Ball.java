package baseball.game;

import java.util.Arrays;

/**
 * 한 게임에서 나오는 볼의 수를 관리하는 enum
 * 0,1,2,3까지 볼을 나타낼 수 있음
 */
public enum Ball {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);
    private final int value;

    Ball(int value) {
        this.value = value;
    }

    public static Ball from(int value) {
        return Arrays.stream(Ball.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
