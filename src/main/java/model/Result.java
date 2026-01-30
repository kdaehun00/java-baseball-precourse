package model;

public record Result(int strike, int ball) {
    public boolean isThreeStrike() {
        return strike == 3;
    }
}