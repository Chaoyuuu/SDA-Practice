import base.AIPlayer;
import base.Deck;
import base.Game;
import base.Player;
import poker.PokerGame;

import java.util.ArrayList;
import java.util.List;

import static base.Game.NUMBER_OF_PLAYERS;

public class Main {
    public static void main(String[] args) {
        Game game = new PokerGame(createAIPlayers(), Deck.standardPokerDeck());
//        Game game = new UNOGame(createAIPlayers(), Deck.standardUNODeck());
        game.play();
        game.showWinner();
    }

    private static List<Player> createAIPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PLAYERS; i ++) {
            players.add(new AIPlayer());
        }
        return players;
    }
}
