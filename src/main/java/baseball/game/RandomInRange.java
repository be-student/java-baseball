package baseball.game;

import static baseball.config.GameMessages.LIBRARY_ERROR_MESSAGE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * 범위 안에 랜덤 숫자를 얻어옵니다
 * 라이브러리를 통해서 가져오는데, 이때 라이브러리가 오작동 했을 경우
 * IllegalArgumentException을 발생시킵니다
 */
public class RandomInRange implements RandomInRangeImpl {

    /**
     * 특정 범위에 해당하는 랜덤 숫자를 반환합니다
     *
     * @param startInclusive 시작 범위
     * @param endInclusive   끝나는 범위
     * @return 시작부터 끝나는 범위 안의 숫자
     */
    @Override
    public Digit pickInRange(int startInclusive, int endInclusive) {
        try {
            int result = pickNumberInRange(startInclusive, endInclusive);
            isValid(result, startInclusive, endInclusive);
            return Digit.from(result);
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
