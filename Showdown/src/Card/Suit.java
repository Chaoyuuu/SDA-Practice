package Card;

public enum Suit {
    CLUB("♣"), DIAMOND("♦"), HEART("♥"), SPADE("♠");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}