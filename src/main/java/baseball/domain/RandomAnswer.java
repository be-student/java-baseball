package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswer {
    private final List<Integer> answer;

    public RandomAnswer() {
        this.answer = generateAnswer();
    }

    public static RandomAnswer createRandom() {
        return new RandomAnswer();
    }

    private List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        //100의 자리수는 1~9이기에 미리 추가함
        answer.add(Randoms.pickNumberInRange(1, 9));

        while (answer.size() < 3) {
            tryToAddRandom(answer);
        }

        return answer;
    }

    private void tryToAddRandom(List<Integer> answer) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }
}
