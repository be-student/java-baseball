package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    void randomInRange() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor[] constructors = RandomAnswer.class.getDeclaredConstructors();
        constructors[0].setAccessible(true);
        RandomInRangeImpl randomInRange = new RandomInRangeImpl() {
            private int temp = 1;

            @Override
            public Digit pickInRange(int startInclusive, int endInclusive) {
                return Digit.from(temp++);
            }
        };

        RandomAnswer test = (RandomAnswer) constructors[0].newInstance(randomInRange);
        assertThat(test.digitWithIndex(0)).isEqualTo(Digit.ONE);
        assertThat(test.digitWithIndex(1)).isEqualTo(Digit.TWO);
        assertThat(test.digitWithIndex(2)).isEqualTo(Digit.THREE);
    }
}
