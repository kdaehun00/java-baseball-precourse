package model;

public record Result(int strike, int ball) {
    private static final int DIGIT_COUNT = 3;

    public boolean isThreeStrike() {
        return strike == DIGIT_COUNT;
    }
}
