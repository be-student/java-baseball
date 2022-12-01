package baseball.adapter.in.game;

import java.util.Arrays;

public enum ClientChoice {
    RETRY(1),
    QUIT(2);

    private static final String NOT_FOUND_ERROR = "1,2만 입력하셔야 합니다";
    private final int value;

    ClientChoice(int value) {
        this.value = value;
    }

    public static ClientChoice from(int value) {
        return Arrays.stream(ClientChoice.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }

    public int getValue() {
        return value;
    }
}
