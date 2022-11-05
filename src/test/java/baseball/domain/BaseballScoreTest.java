package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballScoreTest {
    private final RandomAnswer randomAnswer = RandomAnswer.createRandom();

    @DisplayName("Strike와 Ball이 잘 계산됨")
    @Test
    void 잘_작동() throws NoSuchFieldException, IllegalAccessException {
        Field field = RandomAnswer.class.getDeclaredField("answer");
        field.setAccessible(true);
        field.set(randomAnswer, List.of(1, 2, 3));

        UniqueDigits player1 = UniqueDigits.from(123);
        BaseballScore temp1 = BaseballScore.of(player1, randomAnswer);
        assertThat(temp1.isThreeStrike()).isEqualTo(true);
        assertThat(temp1.isZeroBall()).isEqualTo(true);

        UniqueDigits player2 = UniqueDigits.from(923);
        BaseballScore temp2 = BaseballScore.of(player2, randomAnswer);
        assertThat(temp2.isTwoStrike()).isEqualTo(true);
        assertThat(temp2.isZeroBall()).isEqualTo(true);

        UniqueDigits player3 = UniqueDigits.from(321);
        BaseballScore temp3 = BaseballScore.of(player3, randomAnswer);
        assertThat(temp3.isOneStrike()).isEqualTo(true);
        assertThat(temp3.isTwoBall()).isEqualTo(true);
    }
}
