import Card.Card;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner input = new Scanner(System.in);

    @Override
    public void nameMyself() {
        System.out.println("player's name: ");
        this.name = input.nextLine();
    }

    @Override
    public Card show() {
        System.out.print("Please choose a card: ");
        int cardIndex = input.nextInt();
        return hand.remove(cardIndex);
    }
}
