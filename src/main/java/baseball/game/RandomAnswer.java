package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static baseball.config.GameConstants.BASEBALL_LENGTH;

/**
 * 컴퓨터의 랜덤 정답을 생성합니다
 */
public class RandomAnswer {
    private final List<Integer> answer;
    private final RandomInRangeImpl random;

    public RandomAnswer(RandomInRangeImpl random) {
        this.random = random;
        this.answer = generateAnswer();
    }

    public static RandomAnswer createRandom() {
        return new RandomAnswer(new RandomInRange());
    }

    /**
     * 컴퓨터의 정답을 만듭니다
     *
     * @return 중복이 절대 없는 1자리 자연수 3개 List를 반환합니다
     */
    private List<Integer> generateAnswer() {
        List<Integer> answer = new ArrayList<>();
        //100의 자리수는 1~9이기에 미리 추가함
        answer.add(random.pickInRange(1, 9));

        while (answer.size() < BASEBALL_LENGTH) {
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
