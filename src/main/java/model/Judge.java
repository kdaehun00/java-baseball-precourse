package model;

public final class Judge {
    private Judge() { }

    public static Result judge(ComputerNumber answer, UserGuess guess) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            int g = guess.digitAt(i);

            if (answer.digitAt(i) == g) {
                strike++;
            } else if (answer.contains(g)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }
}
