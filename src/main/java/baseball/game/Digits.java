package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    List<Digit> digits;

    public Digits() {
        digits = new ArrayList<>();
    }

    public void add(Digit digit) {
        digits.add(digit);
    }

    public boolean contains(Digit digit) {
        return digits.contains(digit);
    }

    public int size() {
        return digits.size();
    }

    public int intWithIndex(int index) {
        return digits.get(index).getValue();
    }
}
