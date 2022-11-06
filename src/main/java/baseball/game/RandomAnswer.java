package baseball.game;

import static baseball.config.GameConstants.BASEBALL_LENGTH;

/**
 * 컴퓨터의 랜덤 정답을 생성합니다
 */
public class RandomAnswer {
    private final Digits answer;
    private final RandomInRangeImpl random;

    private RandomAnswer(RandomInRangeImpl random) {
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
    private Digits generateAnswer() {
        Digits answer = Digits.create();
        //100의 자리수는 1~9이기에 미리 추가함
        answer.add(random.pickInRange(1, 9));
        while (answer.size() < BASEBALL_LENGTH) {
            tryToAddRandom(answer);
        }
        return answer;
    }

    private void tryToAddRandom(Digits answer) {
        Digit randomNumber = random.pickInRange(0, 9);
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber);
        }
    }

    /**
     * 컴퓨터의 정답에 해당하는 수의 특정 자리수에 해당하는 정수를 반환합니다
     *
     * @param index 0이면 100의 자리수, 1이면 10의자리수 2면 1의 자리수를 의미합니다
     * @return 그 자리수에 해당하는 실제 숫자를 반환합니다
     */
    public Digit digitWithIndex(int index) {
        return answer.digitWithIndex(index);
    }
}
