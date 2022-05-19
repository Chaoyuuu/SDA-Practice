import Card.Card;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {
    protected String name;
    private int point = 0;
    protected List<Card> hand = new LinkedList<>();
    private final ExchangeHands exchangeHands = new ExchangeHands(this);

    public abstract void nameMyself();

    public abstract Card show();

    public void winPoints(int point) {
        this.point += point;
    }

    public ExchangeHands getExchangeHands() {
        return exchangeHands;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void drawCard(Card card) {
        this.hand.add(card);
    }
    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public int getPoint() {
        return this.point;
    }

    public String getName() {
        return name;
    }
}
