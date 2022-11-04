package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerChoice {
    private static final int START_INCLUSIVE = 100;
    private static final int END_EXCLUSIVE = 1000;
    private static final String rangeMessage = "입력에 " + START_INCLUSIVE + "와 " + END_EXCLUSIVE + "바깥의 값이 들어왔습니다";
    private static final String duplicateMessage = "입력에 중복된 숫자가 들어왔습니다";
    private final List<Integer> input;

    public PlayerChoice(int input) {
        if (input < START_INCLUSIVE) {
            throw new IllegalArgumentException(rangeMessage);
        }
        if (input >= END_EXCLUSIVE) {
            throw new IllegalArgumentException(rangeMessage);
        }

        this.input = splitInput(input);
    }

    private List<Integer> splitInput(int inputNumber) {
        int operand = inputNumber;
        List<Integer> store = new ArrayList<>();

        while (operand > 0) {
            int one = operand % 10;
            if (store.contains(one)) {
                throw new IllegalArgumentException(duplicateMessage);
            }
            operand /= 10;
            store.add(0, one);
        }

        return store;
    }

    public Integer getInput(int index) {
        return input.get(index);
    }
}
