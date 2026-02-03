import controller.BaseballGame;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGame controller = new BaseballGame(new InputView(), new OutputView());
        controller.run();
    }
}
