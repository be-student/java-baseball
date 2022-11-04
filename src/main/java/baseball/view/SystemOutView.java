package baseball.view;

public class SystemOutView {
    private SystemOutView() {
    }

    public static void initialMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void resultMessage(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return;
        }
        ballMessage(ballCount);
        strikeMessage(strikeCount);
        System.out.println();
        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static void ballMessage(int ballCount) {
        if (ballCount == 0) {
            return;
        }
        System.out.print(ballCount + "볼 ");
    }

    private static void strikeMessage(int strikeCount) {
        if (strikeCount == 0) {
            return;
        }
        System.out.print(strikeCount + "스트라이크");
    }

    public static void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void retryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
