import Card.Card;

import java.util.*;

import static Card.CompareResult.BIGGER;

class Showdown {
    private final Deck deck = new Deck();
    private final LinkedList<Player> players = new LinkedList<>();
    public static Scanner input = new Scanner(System.in);
    private final int MAX_PLAYERS = 4;

    private void startGame() {
        prepare();
        drawCards();
        for (int round = 0; round < 13; round++) {
            startARound(round);
        }
        showWinner();
    }

    private void prepare() {
        createPlayers();
        deck.shuffle();
    }

    private void createPlayers() {
        System.out.print("How many human player wants to join the game? (at most 4 player):");
        int numberOfPlayer = input.nextInt();

        for (int i = 0; i < MAX_PLAYERS; i++) {
            Player player = i < numberOfPlayer ? new HumanPlayer(): new AIPlayer();
            player.nameMyself();
            players.add(player);
        }
    }

    private void drawCards() {
        for (int i = 0; i < 13; i++) {
            for (int k = 0; k < MAX_PLAYERS; k++) {
                Card card = deck.getCard(k + i * MAX_PLAYERS);
                players.get(k).drawCard(card);
            }
        }
    }

    private void startARound(int round) {
        System.out.println("--- round/" + round + "---");
        Player winner = players.get(0);
        Card biggestCard = takeATurn(winner);

        for (int i = 1; i < MAX_PLAYERS; i++) {
            Player player = players.get(i);
            Card card = takeATurn(player);
            if (biggestCard.compare(card) == BIGGER) {
                biggestCard = card;
                winner = player;
            }
        }
        System.out.println("the biggest card is " + biggestCard + ", and the winner is " + winner.getName());
        winner.winPoints(1);
    }

    private Card takeATurn(Player player) {
        System.out.println("* " + player.name + "'s turn");
        useExchangeHands(player);
        return showCard(player);
    }

    private void useExchangeHands(Player player) {
        ExchangeHands exchangeHands = player.getExchangeHands();
        if (exchangeHands.isUsed()) {
            exchangeHands.countDownAndExchangeBack();
        } else {
            System.out.print("Do you want to use 'ExchangeHands'?");
            if (input.nextInt() == 1) {
                System.out.print("Choose a player to exchange (player index): ");
                exchangeHands.with(players.get(input.nextInt()));
                exchangeHands.exchange();
            }
        }
    }

    private Card showCard(Player player) {
        System.out.print(player.getName() + "'s hand cards: ");
        Card[] handCard = player.getHand().toArray(new Card[0]);
        for (int i = 0; i < handCard.length; i++) {
            String delimiter = i == handCard.length - 1 ? "\n" : ", ";
            System.out.print("(" + i + ") " + handCard[i] + delimiter);
        }
        return player.show();
    }

    private void showWinner() {
        players.sort(Comparator.comparingInt(Player::getPoint));
        System.out.println("the winner is - " + players.getLast().getName() + " !!");
    }

    public static void main(String[] args) {
        Showdown game = new Showdown();
        game.startGame();
    }
}