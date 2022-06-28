import Card.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards;

    public Deck() {
        this.cards = createStandardDeck();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    private ArrayList<Card> createStandardDeck() {
        ArrayList<Card> cards = new ArrayList<>();
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }
}
