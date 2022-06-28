package poker;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Suit {
    CLUB("♣"), DIAMOND("♦"), HEART("♥"), SPADE("♠");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Stream<Suit> getValues() {
        return Arrays.stream(Suit.values());
    }

}
