package uno;

import base.Deck;
import base.Game;
import base.Player;

import java.util.List;

import static uno.UNOCard.sameColor;
import static uno.UNOCard.sameNumber;

public class UNOGame extends Game {
    private final int MAX_HAND_CARDS = 5;
    private UNOCard tableCard;
    private int currentPlayer = 0;
    private int round = 0;

    public UNOGame(List<Player> players, Deck deck) {
        super(players, deck);
    }

    @Override
    protected void drawCards() {
        for (int i = 0; i < MAX_HAND_CARDS; i++) {
            players.forEach(p -> p.getCard(deck.dealCard()));
        }
    }

    @Override
    protected void beforeTheGameStart() {
        tableCard = (UNOCard) deck.dealCard();
        System.out.println("Table Card is " + tableCard);
    }

    @Override
    protected void round() {
        Player player = players.get(currentPlayer);

        if (!hasValidCardsToPlay(player)) {
            UNOCard showCard = (UNOCard) player.show();
            if (validCard(showCard)){
                tableCard = showCard;
                System.out.println(round + "/ " + player.getName() + " use " + showCard);
            } else {
                player.getCard(showCard);
                System.out.println(round + "/ Invalid Card " + showCard + ". " + player.getName() + " passed this round.");
            }
        }

        currentPlayer = currentPlayer == 3 ? 0: currentPlayer + 1;
        round ++;
    }

    private boolean validCard(UNOCard card) {
        return sameColor(tableCard, card) || sameNumber(tableCard, card);
    }

    private boolean hasValidCardsToPlay(Player player) {
        long numberOfInvalidCards = player.getHands().stream().filter(hand -> !validCard((UNOCard) hand)).count();
        return numberOfInvalidCards != player.getHands().size();
    }

    @Override
    protected boolean isGameOver() {
        return players.get(currentPlayer).getNumberOfHands() == 0;
    }

    @Override
    protected Player getWinner() {
        return players.get(currentPlayer);
    }
}
