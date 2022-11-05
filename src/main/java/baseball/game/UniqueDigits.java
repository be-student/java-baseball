package baseball.game;

import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.BASEBALL_LENGTH;
import static baseball.config.GameConstants.MAX_INPUT_INCLUSIVE;
import static baseball.config.GameConstants.MIN_INPUT_INCLUSIVE;
import static baseball.config.GameMessages.DUPLICATE_INPUT_MESSAGE;
import static baseball.config.GameMessages.LESS_RANGE_MESSAGE;
import static baseball.config.GameMessages.OVER_RANGE_MESSAGE;

/**
 * 절대로 중복을 용납하지 않는 3자리 자연수를 1자리씩 쪼개서 반환합니다
 * 중복이 발생하면 IllegalArgumentException을 발생시킵니다
 */
public class UniqueDigits {
    private final List<Integer> uniqueDigits;

    private UniqueDigits(int uniqueNumber) {
        isDigitInRange(uniqueNumber);
        this.uniqueDigits = splitDigits(uniqueNumber);
    }

    public static UniqueDigits from(int digits) {
        return new UniqueDigits(digits);
    }

    private void isDigitInRange(int uniqueNumber) {
        if (uniqueNumber > MAX_INPUT_INCLUSIVE) {
            throw new IllegalArgumentException(OVER_RANGE_MESSAGE);
        }
        if (uniqueNumber < MIN_INPUT_INCLUSIVE) {
            throw new IllegalArgumentException(LESS_RANGE_MESSAGE);
        }
    }

    private List<Integer> splitDigits(int uniqueNumber) {
        List<Integer> digits = new ArrayList<>();

        while (uniqueNumber > 0) {
            digits.add(0, uniqueNumber % 10);
            uniqueNumber /= 10;
        }

        if (Sets.newHashSet(digits).size() != BASEBALL_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
        return digits;
    }

    public Integer digitWithIndex(int index) {
        return uniqueDigits.get(index);
    }

    public boolean contains(int value) {
        return uniqueDigits.contains(value);
    }
}
