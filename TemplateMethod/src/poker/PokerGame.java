package poker;

import base.Card;
import base.Deck;
import base.Game;
import base.Player;

import java.util.*;

public class PokerGame extends Game {
    private final int ROUNDS = 13;
    private int currentRound = 1;
    private final Map<Player, Integer> scores = new HashMap<>();

    public PokerGame(List<Player> players, Deck deck) {
        super(players, deck);
        initialScores(players);
    }

    private void initialScores(List<Player> players) {
        players.forEach(p -> scores.put(p, 0));
    }

    @Override
    protected void drawCards() {
        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("round:" + i);
            players.forEach(p -> p.getCard(deck.dealCard()));
        }
    }

    @Override
    protected void round() {
        System.out.println("--- Round/" + currentRound + "---");
        List<Card> tableCards = showCards();
        Player winner = findTheBiggestCardPlayer(tableCards);
        winnerGetPoints(winner);
        currentRound++;
    }

    private List<Card> showCards() {
        List<Card> tableCards = new ArrayList<>();
        players.forEach(p -> {
            Card card = p.show();
            System.out.println("basic.Player-" + p.getName() + " use " + card + ".");
            tableCards.add(card);
        });
        return tableCards;
    }

    private void winnerGetPoints(Player winner) {
        int previousScores = scores.get(winner);
        scores.replace(winner, previousScores + 1);
        System.out.println(winner.getName() + " has the biggest card in this round.\n");
    }

    private Player findTheBiggestCardPlayer(List<Card> cards) {
        int biggestCardIndex = 0;
        for (int index = 1; index < Game.NUMBER_OF_PLAYERS; index++) {
            int result = cards.get(biggestCardIndex).compare(cards.get(index));
            if (result > 0) {
                biggestCardIndex = index;
            }
        }
        return players.get(biggestCardIndex);
    }

    @Override
    protected boolean isGameOver() {
        return currentRound == ROUNDS;
    }

    @Override
    protected Player getWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (scores.get(player) >= scores.get(winner)) {
                winner = player;
            }
        }
        return winner;
    }
}
