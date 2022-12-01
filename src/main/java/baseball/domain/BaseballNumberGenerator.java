package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {

    private static final int BASEBALL_LENGTH = 3;
    private final BaseballDigitGenerator generator;

    public BaseballNumberGenerator(BaseballDigitGenerator generator) {
        this.generator = generator;
    }

    public BaseballNumber generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < BASEBALL_LENGTH) {
            addUniqueNumbers(numbers);
        }
        return new BaseballNumber(numbers);
    }

    private void addUniqueNumbers(List<Integer> numbers) {
        int digit = generator.generate();
        if (!numbers.contains(digit)) {
            numbers.add(digit);
        }
    }
}
