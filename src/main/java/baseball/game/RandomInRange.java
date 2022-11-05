package baseball.game;

import static baseball.config.GameMessages.LIBRARY_ERROR_MESSAGE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomInRange implements RandomInRangeImpl {

    @Override
    public int pickInRange(int startInclusive, int endInclusive) {
        try {
            int result = pickNumberInRange(startInclusive, endInclusive);
            isValid(result, startInclusive, endInclusive);
            return result;
        } catch (Exception e) {
            System.err.println(LIBRARY_ERROR_MESSAGE);
            throw new IllegalArgumentException(e);
        }
    }

    private void isValid(int result, int startInclusive, int endInclusive) {
        if (result > endInclusive) {
            throw new IllegalArgumentException();
        }
        if (result < startInclusive) {
            throw new IllegalArgumentException();
        }
    }
}
