package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            BaseballController baseballController = new BaseballController();
            baseballController.run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
