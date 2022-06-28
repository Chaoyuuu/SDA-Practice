package base;

import poker.PokerCard;
import poker.Rank;
import poker.Suit;
import uno.Color;
import uno.UNOCard;
import uno.Number;

import java.util.*;

public class Deck {
    private final Stack<Card> cards;

    public Deck(Stack<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        return cards.pop();
    }

    public static Deck standardUNODeck() {
        Stack<Card> cards = new Stack<>();
        Number.getValues().forEach(n ->
                Color.getValues().forEach(c -> cards.add(new UNOCard(c, n))));
        return new Deck(cards);
    }

    public static Deck standardPokerDeck() {
        Stack<Card> cards = new Stack<>();
        Rank.getValues().forEach(r ->
                Suit.getValues().forEach(s -> cards.add(new PokerCard(r, s))));
        return new Deck(cards);
    }
}
