package Card;

import static Card.CompareResult.*;
import static Card.Rank.*;
import static Card.Suit.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public CompareResult compare(Card card) {
        int suitResult = this.suit.compareTo(card.suit);
        int rankResult = this.rank.compareTo(card.rank);

        if (suitResult == 0) {
            if (rankResult == 0) return EQUAL;
            else if (rankResult > 0) return BIGGER;
            else return SMALLER;
        } else if (suitResult > 0) {
            return BIGGER;
        } else {
            return SMALLER;
        }
    }

    @Override
    public String toString() {
        return suit.getSymbol() + "-" + rank.getValue();
    }

    // testcases
    public static void main(String[] args) {
        // test-1 Compare ♦-A with ♦-10, should be bigger
        Card big = new Card(DIAMOND, A);
        Card small = new Card(DIAMOND, TEN);
        if (big.compare(small) != BIGGER) {
            throw new ArithmeticException("should be bigger");
        }

        // test-2 Compare ♥-2 with ♦-10, should be smaller
        Card heart = new Card(HEART, TWO);
        Card diamond = new Card(DIAMOND, Rank.TEN);
        if (diamond.compare(heart) != SMALLER) {
            throw new ArithmeticException("should be smaller");
        }

        // test-3 Compare ♣-7 with ♣-7, Should be equal
        Card card1 = new Card(CLUB, SEVEN);
        Card card2 = new Card(CLUB, SEVEN);
        if (card1.compare(card2) != EQUAL) {
            throw new ArithmeticException("should be equal");
        }
    }
}



