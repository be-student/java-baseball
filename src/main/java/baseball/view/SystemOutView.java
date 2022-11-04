package baseball.view;

import baseball.dto.BaseballScore;

public class SystemOutView {
    private SystemOutView() {
    }

    public static void initialMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void resultMessage(BaseballScore score) {
        if (isWrong(score)) {
            System.out.println("낫싱");
            return;
        }
        ballMessage(score);
        strikeMessage(score);
        System.out.println();

        if (score.getStrikeCount() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static boolean isWrong(BaseballScore score) {
        return score.getBallCount() == 0 && score.getStrikeCount() == 0;
    }

    private static void ballMessage(BaseballScore score) {
        if (score.getBallCount() == 0) {
            return;
        }
        System.out.print(score.getBallCount() + "볼 ");
    }

    private static void strikeMessage(BaseballScore score) {
        if (score.getStrikeCount() == 0) {
            return;
        }
        System.out.print(score.getStrikeCount() + "스트라이크");
    }

    public static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void retryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
