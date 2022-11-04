package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.BaseballConstant.*;

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

    public List<Integer> getNumber() {
        return baseballNumber;
    }
}
