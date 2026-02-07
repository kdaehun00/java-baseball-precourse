package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Result 결과 상태 테스트")
class ResultTest {

    @DisplayName("스트라이크가 3이면 isThreeStrike는 true를 반환한다")
    @Test
    void isThreeStrike_whenStrikeIsThree_returnsTrue() {
        Result result = new Result(3, 0);

        assertTrue(result.isThreeStrike());
    }

    @DisplayName("스트라이크가 3이 아니면 isThreeStrike는 false를 반환한다")
    @Test
    void isThreeStrike_whenStrikeIsNotThree_returnsFalse() {
        Result result = new Result(2, 1);

        assertFalse(result.isThreeStrike());
    }
}
