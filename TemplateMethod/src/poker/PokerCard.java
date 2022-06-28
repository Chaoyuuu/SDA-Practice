package poker;

import base.Card;

public class PokerCard extends Card {
    private final Rank rank;
    private final Suit suit;

    public PokerCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compare(Card card) {
        PokerCard pokerCard = (PokerCard) card;
        int suitCompareResult = suit.compareTo(pokerCard.getSuit());
        int rankCompareResult = rank.compareTo(pokerCard.getRank());
        if (suitCompareResult == 0 && rankCompareResult == 0) {
            return 0;
        } else if ((suitCompareResult == 0 && rankCompareResult < 0) || (suitCompareResult < 0)) {
            return -1;
        } else {
            return 1;
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit.toString() + rank.toString();
    }
}
