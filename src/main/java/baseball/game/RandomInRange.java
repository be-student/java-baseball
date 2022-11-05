package baseball.game;

import static baseball.config.GameMessages.LIBRARY_ERROR_MESSAGE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * 범위 안에 랜덤 숫자를 얻어옵니다
 * 라이브러리를 통해서 가져오는데, 이때 라이브러리가 오작동 했을 경우
 * IllegalArgumentException을 발생시킵니다
 */
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
