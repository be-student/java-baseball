package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RandomAnswerTest {
    @DisplayName("Random 값을 생성할 수 있음")
    @Test
    void 잘_작동함() {
        assertDoesNotThrow(RandomAnswer::createRandom);
    }

    @DisplayName("RandomInRange를 주입한다")
    @Test
    void randomInRange() throws NoSuchMethodException {
        Constructor constructor = RandomAnswer.class.getConstructor(RandomInRangeImpl.class);
        constructor.setAccessible(true);
        RandomInRangeImpl randomInRange = new RandomInRangeImpl() {
            private int temp = 1;

            @Override
            public int pickInRange(int startInclusive, int endInclusive) {
                return temp++;
            }
        };

        RandomAnswer test = new RandomAnswer(randomInRange);
        assertThat(test.digitWithIndex(0)).isEqualTo(1);
        assertThat(test.digitWithIndex(1)).isEqualTo(2);
        assertThat(test.digitWithIndex(2)).isEqualTo(3);
    }
}
