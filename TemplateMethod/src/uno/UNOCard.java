package uno;

import base.Card;

public class UNOCard extends Card {
    private final Color color;
    private final uno.Number number;

    public UNOCard(Color color, uno.Number number) {
        this.color = color;
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }

    public static boolean sameColor(UNOCard cardA, UNOCard cardB) {
        return cardA.getColor().equals(cardB.getColor());
    }

    public static boolean sameNumber(UNOCard cardA, UNOCard cardB) {
        return cardA.getNumber().equals(cardB.getNumber());
    }

    @Override
    public String toString() {
        return color.toString() + number.toString();
    }

    @Override
    public int compare(Card card) {
        return 0;
    }
}
