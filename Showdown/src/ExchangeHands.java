import Card.Card;

import java.util.List;

public class ExchangeHands {
    private Player exchangePlayer;
    private Player owner;
    private int exchangeTimes = 0;
    private int waitingRound = 0;

    public ExchangeHands(Player owner) {
        this.owner = owner;
    }

    public boolean isUsed() {
        return exchangeTimes > 0;
    }

    public void countDownAndExchangeBack() {
        waitingRound += 1;
        if (waitingRound == 3) {
            exchange();
        }
    }

    public void with(Player player) {
        if (player == owner) {
            System.out.println("Can't exchange with yourself.");
        } else {
            exchangePlayer = player;
        }
    }

    public void exchange() {
        exchangeTimes += 1;
        List<Card> cards = owner.getHand();
        owner.setHand(exchangePlayer.getHand());
        exchangePlayer.setHand(cards);
    }
}
