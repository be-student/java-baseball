package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.BaseballConstant.INPUT_END_EXCLUSIVE;
import static baseball.config.BaseballConstant.INPUT_START_INCLUSIVE;

public class PlayerChoice {
    private static final String rangeMessage = "입력에 " + INPUT_START_INCLUSIVE + "와 " + INPUT_END_EXCLUSIVE + "바깥의 값이 들어왔습니다";
    private static final String duplicateMessage = "입력에 중복된 숫자가 들어왔습니다";
    private final List<Integer> input;

    public PlayerChoice(int input) {
        if (input < INPUT_START_INCLUSIVE) {
            throw new IllegalArgumentException(rangeMessage);
        }
        if (input >= INPUT_END_EXCLUSIVE) {
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
