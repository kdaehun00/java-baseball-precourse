package baseball.model;

import baseball.exception.CommonErrorCode;
import baseball.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserGuessTest {

    @DisplayName("정상적인 3자리 숫자 입력이면 UserGuess가 생성된다")
    @Test
    void from_validInput_createsUserGuess() {
        UserGuess guess = UserGuess.from("135");

        assertEquals(1, guess.digitAt(0));
        assertEquals(3, guess.digitAt(1));
        assertEquals(5, guess.digitAt(2));
    }

    @DisplayName("입력이 null이면 EMPTY_INPUT 예외가 발생한다")
    @Test
    void from_nullInput_throwsException() {
        InvalidInputException e = assertThrows(
                InvalidInputException.class,
                () -> UserGuess.from(null)
        );

        assertEquals(CommonErrorCode.EMPTY_INPUT, e.getCommonErrorCode());
    }

    @DisplayName("입력 길이가 3이 아니면 INVALID_LENGTH 예외가 발생한다")
    @Test
    void from_invalidLength_throwsException() {
        InvalidInputException e = assertThrows(
                InvalidInputException.class,
                () -> UserGuess.from("12")
        );

        assertEquals(CommonErrorCode.INVALID_LENGTH, e.getCommonErrorCode());
    }

    @DisplayName("숫자가 아닌 문자가 포함되면 NOT_A_NUMBER 예외가 발생한다")
    @Test
    void from_nonDigit_throwsException() {
        InvalidInputException e = assertThrows(
                InvalidInputException.class,
                () -> UserGuess.from("1a3")
        );

        assertEquals(CommonErrorCode.NOT_A_NUMBER, e.getCommonErrorCode());
    }

    @DisplayName("숫자가 1~9 범위를 벗어나면 NUMBER_OUT_OF_RANGE 예외가 발생한다")
    @Test
    void from_outOfRange_throwsException() {
        InvalidInputException e = assertThrows(
                InvalidInputException.class,
                () -> UserGuess.from("109")
        );

        assertEquals(CommonErrorCode.NUMBER_OUT_OF_RANGE, e.getCommonErrorCode());
    }

    @DisplayName("중복된 숫자가 있으면 DUPLICATED_NUMBER 예외가 발생한다")
    @Test
    void from_duplicatedDigits_throwsException() {
        InvalidInputException e = assertThrows(
                InvalidInputException.class,
                () -> UserGuess.from("113")
        );

        assertEquals(CommonErrorCode.DUPLICATED_NUMBER, e.getCommonErrorCode());
    }
}
