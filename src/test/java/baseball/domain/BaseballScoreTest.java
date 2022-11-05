package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballScoreTest {
    @DisplayName("Strike와 Ball이 잘 계산됨")
    @Test
    void 잘_작동() {
        assertThat(BaseballScore.of(0, 0).isZeroBall()).isEqualTo(true);
        assertThat(BaseballScore.of(0, 0).isZeroStrike()).isEqualTo(true);

        assertThat(BaseballScore.of(1, 1).isOneBall()).isEqualTo(true);
        assertThat(BaseballScore.of(1, 1).isOneStrike()).isEqualTo(true);

        assertThat(BaseballScore.of(2, 2).isTwoBall()).isEqualTo(true);
        assertThat(BaseballScore.of(2, 2).isTwoStrike()).isEqualTo(true);

        assertThat(BaseballScore.of(3, 3).isThreeBall()).isEqualTo(true);
        assertThat(BaseballScore.of(3, 3).isThreeStrike()).isEqualTo(true);
    }

    @DisplayName("Strike와 Ball이 범위 바깥 에러")
    @Test
    void 범위_바깥_에러() {
        assertThrows(IllegalArgumentException.class, () -> BaseballScore.of(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> BaseballScore.of(0, -1));
    }
}
