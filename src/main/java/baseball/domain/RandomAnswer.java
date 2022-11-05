package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomAnswer {
    private final List<Integer> answer;
    private final RandomInRange random = new RandomInRange();

    public RandomAnswer() {
        this.answer = generateAnswer();
    }

    public static RandomAnswer createRandom() {
        return new RandomAnswer();
    }

    private List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        //100의 자리수는 1~9이기에 미리 추가함
        answer.add(random.pickInRange(1, 9));

        while (answer.size() < 3) {
            tryToAddRandom(answer);
        }

        return answer;
    }

    private void tryToAddRandom(List<Integer> answer) {
        int randomNumber = random.pickInRange(0, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    public Integer digitWithIndex(int index) {
        return answer.get(index);
    }
}
