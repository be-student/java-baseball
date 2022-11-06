package baseball.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 한 자리 숫자씩 쪼개져있는 숫자를 관리하는 일급 컬렉션입니다
 */
public class Digits {
    List<Digit> digits;

    private Digits() {
        digits = new ArrayList<>();
    }

    public static Digits create() {
        return new Digits();
    }
    public void add(Digit digit) {
        digits.add(digit);
    }

    public boolean contains(Digit digit) {
        return digits.contains(digit);
    }

    public int size() {
        return digits.size();
    }

    /**
     * 특정 자리수에 있는 실제 값을 반환합니다
     *
     * @param index 가지고 싶은 자리수를 의미합니다. 0이 가장 큰 자리수입니다
     * @return 실제 int 값
     */
    public Digit digitWithIndex(int index) {
        return digits.get(index);
    }

}
