package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //Todo Input 여기다 view 주입
        //Todo new 를 사용 줄이기
        BaseballController baseballController = new BaseballController();
        baseballController.run();
    }
}
