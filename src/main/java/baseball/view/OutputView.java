package baseball.view;

import baseball.model.Result;

public class OutputView {
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printHint(Result result) {
        int strike = result.strike();
        int ball = result.ball();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) sb.append(ball).append("볼 ");
        if (strike > 0) sb.append(strike).append("스트라이크");
        System.out.println(sb.toString().trim());
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
