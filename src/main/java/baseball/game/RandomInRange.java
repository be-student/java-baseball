package baseball.game;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomInRange implements RandomInRangeImpl {
    private static final String LIBRARY_ERROR_MESSAGE = "random 라이브러리가 잘못되었습니다";

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
