package baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 한 자리 숫자씩 쪼개져있는 숫자를 관리하는 일급 컬렉션입니다
 */
public class Digits {
    List<Digit> digits;

    private Digits() {
        digits = new ArrayList<>();
    }

    /**
     * 기본 생성자를 호출하는 정적 메서드
     *
     * @return Digits 객체를 반환합니다.
     */
    public static Digits create() {
        return new Digits();
    }

    /**
     * Digits에 숫자 하나를 추가합니다
     *
     * @param digit Digit객체를 만듭니다
     */
    public void add(Digit digit) {
        digits.add(digit);
    }

    public void add(int index, Digit digit) {
        digits.add(index, digit);
    }

    /**
     * Digits에 숫자가 포함되어있는지 확인합니다
     *
     * @param digit Digit객체를 포함하고 있는지 여부를 반환합니다
     * @return 포함하고 있다면 true
     */
    public boolean contains(Digit digit) {
        return digits.contains(digit);
    }

    /**
     * Digits가 몇 자리 숫자인지를 반환합니다
     *
     * @return 몇 자리 숫자인지를 나타내는 정수
     */
    public int size() {
        return digits.size();
    }

    /**
     * Digits안에 중복되지 않는 숫자가 몇 자리인지 체크한다
     *
     * @return 중복되지 않는 자리수가 몇 자리인지 정수로 반환
     */
    public int uniqueSize() {
        List<Integer> list = digits.stream().map(Digit::toInt).collect(Collectors.toList());
        return new HashSet<>(list).size();
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
