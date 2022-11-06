package baseball.config;

import java.util.Arrays;

/**
 * 게임 종료시 입력받는 값을 관리하는 enum
 */
public enum ControllerConstants {
    RETRY(1),
    FINISH(2);
    private final int value;

    /**
     * ControllerConstants에 해당하는 enum을 생성한다
     *
     * @param value 1~2에 해당하는 정수
     */
    ControllerConstants(int value) {
        this.value = value;
    }

    /**
     * 정수로부터 enum에 맞는 값을 반환한다 맞는 값이 없다면 IllegalArgumentException
     *
     * @param value 1~2에 해당하는 정수
     * @return 그에 해당하는 enum
     */
    public static ControllerConstants from(int value) {
        return Arrays.stream(ControllerConstants.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
