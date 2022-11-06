package baseball.game;

/**
 * mocking을 위한 인터페이스를 만들었습니다
 * random값을 생성하는 객체가 의존하는 interface입니다
 * 이를 통해서 랜덤 값을 테스트 할 수 있습니다
 */
public interface RandomInRangeImpl {
    Digit pickInRange(int startInclusive, int endInclusive);
}
