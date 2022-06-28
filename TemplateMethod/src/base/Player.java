package base;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String name;
    protected final List<Card> hands = new ArrayList<>();

    public abstract Card show();
    public abstract void nameMySelf();

    public void getCard(Card card) {
        hands.add(card);
    }

    public int getNumberOfHands() {
        return hands.size();
    }

    public List<Card> getHands() {
        return hands;
    }

    public String getName() {
        return name;
    }
}
