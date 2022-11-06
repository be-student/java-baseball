package baseball.game;

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
    private final Digits uniqueDigits;

    private UniqueDigits(int uniqueNumber) {
        isDigitInRange(uniqueNumber);
        this.uniqueDigits = splitDigits(uniqueNumber);
    }

    /**
     * int값으로부터 UniqueDigits를 만드는 정적 팩토리 메서드
     * MAX_INPUT_INCLUSIVE(999)와 MIN_INPUT_INCLUSIVE(100) 사이의 값만 받아들임
     * 범의 바깥의 값이 들어오면 IllegalArgumentException
     *
     * @param digits int 정수
     * @return UniqueDigits 객체
     */
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

    private Digits splitDigits(int uniqueNumber) {
        Digits digits = Digits.create();
        while (uniqueNumber > 0) {
            digits.add(0, Digit.from(uniqueNumber % 10));
            uniqueNumber /= 10;
        }
        if (digits.uniqueSize() != BASEBALL_LENGTH) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
        return digits;
    }

    /**
     * 특정 자리수에 어떤 숫자가 있는지를 반환
     *
     * @param index 0이면 100의 자리, 1이면 10의자리 2면 1의 자리를 의미함
     * @return 숫자에 해당하는 Digit ENUM 반환
     */
    public Digit digitWithIndex(int index) {
        return uniqueDigits.digitWithIndex(index);
    }

    /**
     * 특정 숫자가 이미 포함되어 있는지 체크
     *
     * @param value 특정 숫자
     * @return 포함되어있다면 true
     */
    public boolean contains(Digit value) {
        return uniqueDigits.contains(value);
    }
}
