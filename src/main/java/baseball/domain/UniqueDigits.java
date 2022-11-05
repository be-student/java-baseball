package baseball.domain;

import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.MAX_INPUT_INCLUSIVE;
import static baseball.config.GameConstants.MIN_INPUT_INCLUSIVE;

public class UniqueDigits {
    private static final String OVER_RANGE_MESSAGE = "입력이 999를 초과했습니다";
    private static final String LESS_RANGE_MESSAGE = "입력이 100보다 작았습니다";
    private static final String DUPLICATE_INPUT_MESSAGE = "입력에 중복값이 있습니다";
    private List<Integer> uniqueDigits;

    private UniqueDigits(int uniqueNumber) {
        isDigitInRange(uniqueNumber);
        this.uniqueDigits = splitDigits(uniqueNumber);
    }

    public static UniqueDigits of(int digits) {
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

        if (Sets.newHashSet(digits).size() != 3) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
        return digits;
    }
}
