package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;

public class BaseballNumber {
    private final List<Integer> baseballNumber;

    public BaseballNumber() {
        //100의 자리수를 미리 추가함
        List<Integer> computer = new ArrayList<>(List.of(Randoms.pickNumberInRange(1, 9)));

        while (computer.size() < BASEBALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        this.baseballNumber = computer;
    }

    public boolean isBall(int index, Integer value) {
        if (baseballNumber.get(index).equals(value)) {
            return false;
        }
        return baseballNumber.contains(value);
    }

    public boolean isStrike(int index, Integer value) {
        return baseballNumber.get(index).equals(value);
    }
}
