package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Judge 스트라이크/볼 판정 테스트")
class JudgeTest {

    @DisplayName("모든 숫자와 자리가 같으면 3스트라이크이다")
    @Test
    void judge_allMatch_returnsThreeStrike() {
        ComputerNumber answer = ComputerNumber.of(List.of(1, 3, 7));
        UserGuess guess = UserGuess.from("137");

        Result result = Judge.judge(answer, guess);

        assertEquals(3, result.strike());
        assertEquals(0, result.ball());
        assertTrue(result.isThreeStrike());
    }

    @DisplayName("숫자는 같지만 자리가 다르면 볼로 판정한다")
    @Test
    void judge_sameDigitsDifferentPosition_returnsBalls() {
        ComputerNumber answer = ComputerNumber.of(List.of(1, 3, 7));
        UserGuess guess = UserGuess.from("731");

        Result result = Judge.judge(answer, guess);

        assertEquals(0, result.strike());
        assertEquals(3, result.ball());
    }

    @DisplayName("스트라이크와 볼이 함께 존재할 수 있다")
    @Test
    void judge_strikeAndBallMixed() {
        ComputerNumber answer = ComputerNumber.of(List.of(1, 3, 7));
        UserGuess guess = UserGuess.from("173");

        Result result = Judge.judge(answer, guess);

        assertEquals(1, result.strike()); // 1
        assertEquals(2, result.ball());   // 7, 3
    }

    @DisplayName("공통 숫자가 없으면 스트라이크와 볼은 0이다")
    @Test
    void judge_noMatchingDigits_returnsNothing() {
        ComputerNumber answer = ComputerNumber.of(List.of(1, 3, 7));
        UserGuess guess = UserGuess.from("258");

        Result result = Judge.judge(answer, guess);

        assertEquals(0, result.strike());
        assertEquals(0, result.ball());
    }

    @DisplayName("일부만 같은 경우 스트라이크만 판정될 수 있다")
    @Test
    void judge_onlyStrike() {
        ComputerNumber answer = ComputerNumber.of(List.of(1, 3, 7));
        UserGuess guess = UserGuess.from("128");

        Result result = Judge.judge(answer, guess);

        assertEquals(1, result.strike()); // 1
        assertEquals(0, result.ball());
    }
}
