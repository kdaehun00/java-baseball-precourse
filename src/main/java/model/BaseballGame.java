package model;

public class BaseballGame {
    private final InputView inputView = new InputView();
    private final OutPutView outPutView = new OutputView();

    public void run() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            // 게임 시작
            playingGame();

            /* 재시작 여부 결정
                yes 선택 시: askRestart는 true 반환
                no 선택 시: askRestart는 false 반환
             */
            keepPlaying = askRestart();
        }
    }
}
