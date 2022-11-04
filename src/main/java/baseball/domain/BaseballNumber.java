package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.BaseballConstant.BASEBALL_LENGTH;

public class BaseballNumber {
    private final List<Integer> baseballNumber;

    public BaseballNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < BASEBALL_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        this.baseballNumber = computer;
    }

    public boolean isBall(Integer value) {
        return baseballNumber.contains(value);
    }

    public boolean isStrike(int index, Integer value) {
        return baseballNumber.get(index).equals(value);
    }
}
