package base;

import java.util.List;

public abstract class Game {
    public static final int NUMBER_OF_PLAYERS = 4;
    protected final List<Player> players;
    protected final Deck deck;

    public Game(List<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
    }

    public void play() {
        prepare();
        drawCards();
        beforeTheGameStart();
        while (!isGameOver()) {
            round();
        }
    }

    public void showWinner() {
        Player winner = getWinner();
        System.out.println("This is winner: " + winner.getName());
    }

    private void prepare() {
        players.forEach(Player::nameMySelf);
        deck.shuffle();
    }

    protected void beforeTheGameStart() {};
    protected abstract void drawCards();
    protected abstract void round();
    protected abstract boolean isGameOver();
    protected abstract Player getWinner();
}
