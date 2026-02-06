package model;

import exception.CommonErrorCode;
import exception.InvalidInputException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UserGuess {
    private final List<Integer> digits;

    private static final int DIGIT_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static UserGuess from(String input) {
        if (input == null) {
            throw new InvalidInputException(CommonErrorCode.EMPTY_INPUT);
        }
        if (input.length() != DIGIT_COUNT) {
            throw new InvalidInputException(CommonErrorCode.INVALID_LENGTH);
        }

        List<Integer> digits = new ArrayList<>(DIGIT_COUNT);
        Set<Integer> dupCheck = new HashSet<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new InvalidInputException(CommonErrorCode.NOT_A_NUMBER);
            }

            int d = c - '0';
            if (d < MIN_NUMBER || d > MAX_NUMBER) {
                throw new InvalidInputException(CommonErrorCode.NUMBER_OUT_OF_RANGE);
            }
            if (!dupCheck.add(d)) {
                throw new InvalidInputException(CommonErrorCode.DUPLICATED_NUMBER);
            }
            digits.add(d);
        }

        return new UserGuess(digits);
    }

    public int digitAt(int index) {
        return digits.get(index);
    }
}
