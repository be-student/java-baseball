package baseball;

import baseball.controller.BaseballController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballController baseballController = new BaseballController();
        baseballController.run();
    }
}
