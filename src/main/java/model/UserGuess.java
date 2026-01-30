package model;

import exception.InvalidInputException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UserGuess {
    private final List<Integer> digits;

    public static UserGuess from(String input) {
        if (input == null) {
            throw new InvalidInputException("입력값이 비어있습니다.");
        }
        if (input.length() != 3) {
            throw new InvalidInputException("3자리 숫자를 입력해야 합니다.");
        }

        List<Integer> digits = new ArrayList<>(3);
        Set<Integer> dupCheck = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new InvalidInputException("숫자만 입력해야 합니다.");
            }

            int d = c - '0';
            if (d < 1 || d > 9) {
                throw new InvalidInputException("각 자리는 1~9 사이여야 합니다.");
            }
            if (!dupCheck.add(d)) {
                throw new InvalidInputException("중복되지 않는 숫자 3개여야 합니다.");
            }
            digits.add(d);
        }

        return new UserGuess(digits);
    }

    public int digitAt(int index) {
        return digits.get(index);
    }
}
