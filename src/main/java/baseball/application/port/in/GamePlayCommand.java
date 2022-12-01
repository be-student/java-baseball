package baseball.application.port.in;

import java.util.List;

public class GamePlayCommand {

    private static final String NULL_MESSAGE = "입력에 null 이 있으면 안 됩니다";

    private final List<Integer> playerInput;

    public GamePlayCommand(List<Integer> playerInput) {
        this.playerInput = playerInput;
        validate();
    }

    private void validate() {
        if (playerInput == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        if (playerInput.contains(null)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }


    public List<Integer> getPlayerInput() {
        return playerInput;
    }
}

