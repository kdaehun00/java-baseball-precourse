package model;

import exception.InvalidInputException;
import view.InputView;
import view.OutputView;

import java.util.*;

public class BaseballGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Random random = new Random();

    public void run() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            // 게임 시작
            playSingleGame();

            /* 재시작 여부 결정
                yes 선택 시: askRestart는 true 반환
                no 선택 시: askRestart는 false 반환
             */
            keepPlaying = askRestart();
        }
    }

    private void playSingleGame() {
        ComputerNumber targetNum = ComputerNumber.createRandom();

        outputView.printStartMessage();

        while (true) {
            try {
                String raw = inputView.readGuess();
                UserGuess guess = UserGuess.from(raw);

                Result result = Judge.judge(targetNum, guess);
                outputView.printHint(result);

                if (result.isThreeStrike()) {
                    outputView.printGameEndMessage();
                    break;
                }
            } catch (InvalidInputException e) {
                outputView.printError(e.getMessage());
            }

        }
    }

    private List<Integer> generateComputerNumber() {
        Set<Integer> setNum = new LinkedHashSet<>();
        while (setNum.size() < 3) {
            int n = random.nextInt(9) + 1;
            setNum.add(n);
        }
        return new ArrayList<>(setNum);
    }


    private boolean askRestart() {
        while (true) {
            try {
                String cmd = inputView.readRestartCommand();
                validateRestartCommand(cmd);

                return "1".equals(cmd);
            } catch (InvalidInputException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void validateRestartCommand(String cmd) {
        if (!"1".equals(cmd) && !"2".equals(cmd)) {
            throw new InvalidInputException("1 또는 2를 입력해야 합니다.");
        }
    }
}
