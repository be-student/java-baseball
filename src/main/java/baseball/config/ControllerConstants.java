package baseball.config;

import java.util.Arrays;

/**
 * 게임 종료시 입력받는 값을 관리하는 enum
 */
public enum ControllerConstants {
    RETRY(1),
    FINISH(2);
    private final int value;

    ControllerConstants(int value) {
        this.value = value;
    }

    public static ControllerConstants from(int value) {
        return Arrays.stream(ControllerConstants.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
