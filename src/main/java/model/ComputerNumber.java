package model;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
public final class ComputerNumber {
    private static final Random RANDOM = new Random();
    private final List<Integer> digits;

    public static ComputerNumber createRandom() {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < 3) {
            int n = RANDOM.nextInt(9) + 1; // 1~9
            set.add(n); // 중복 자동 제거
        }
        return new ComputerNumber(new ArrayList<>(set));
    }

    public int digitAt(int index) {
        return digits.get(index);
    }

    public boolean contains(int digit) {
        return digits.contains(digit);
    }

    public int size() {
        return digits.size();
    }
}
