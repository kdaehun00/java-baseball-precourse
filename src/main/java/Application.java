import baseball.controller.BaseballGame;
import baseball.model.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGame controller = new BaseballGame(new InputView(), new OutputView(), ComputerNumber::createRandom);
        controller.run();
    }
}
