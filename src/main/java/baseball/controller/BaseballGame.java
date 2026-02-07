package baseball.controller;

import baseball.exception.CommonErrorCode;
import baseball.exception.InvalidInputException;
import lombok.RequiredArgsConstructor;
import baseball.model.ComputerNumber;
import baseball.model.Judge;
import baseball.model.Result;
import baseball.model.UserGuess;
import baseball.view.InputView;
import baseball.view.OutputView;

@RequiredArgsConstructor
public class BaseballGame {
    private final InputView inputView;
    private final OutputView outputView;

    public void run() {
        while (true) {
            playSingleGame();
            if (!askRestart()) {
                return;
            }
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
            throw new InvalidInputException(CommonErrorCode.INVALID_COMMAND);
        }
    }
}
