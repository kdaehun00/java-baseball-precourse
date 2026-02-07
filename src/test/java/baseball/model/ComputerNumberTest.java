package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ComputerNumber 생성 테스트")
class ComputerNumberTest {

    @DisplayName("컴퓨터 숫자는 항상 3자리로 생성된다")
    @Test
    void createRandom_createsThreeDigits() {
        ComputerNumber number = ComputerNumber.createRandom();

        assertEquals(3, number.size());
    }

    @DisplayName("컴퓨터 숫자는 1~9 범위의 숫자로만 구성된다")
    @Test
    void createRandom_digitsAreBetweenOneAndNine() {
        ComputerNumber number = ComputerNumber.createRandom();

        for (int i = 0; i < number.size(); i++) {
            int digit = number.digitAt(i);
            assertTrue(digit >= 1 && digit <= 9);
        }
    }

    @DisplayName("컴퓨터 숫자는 중복되지 않는다")
    @Test
    void createRandom_digitsAreUnique() {
        ComputerNumber number = ComputerNumber.createRandom();

        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < number.size(); i++) {
            unique.add(number.digitAt(i));
        }

        assertEquals(3, unique.size());
    }

    @DisplayName("contains는 포함된 숫자에 대해 true를 반환한다")
    @Test
    void contains_returnsTrueForExistingDigit() {
        ComputerNumber number = ComputerNumber.createRandom();

        int digit = number.digitAt(0);

        assertTrue(number.contains(digit));
    }
}
