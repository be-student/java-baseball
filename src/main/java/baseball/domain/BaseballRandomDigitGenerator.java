package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public final class BaseballRandomDigitGenerator implements BaseballDigitGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
