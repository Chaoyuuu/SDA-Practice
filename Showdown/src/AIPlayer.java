import Card.Card;

import java.util.Random;

public class AIPlayer extends Player {
    private final Random random = new Random();

    @Override
    public void nameMyself() {
        this.name = "AI Player";
    }

    @Override
    public Card show() {
        int cardIndex = random.nextInt(hand.size() + 1) - 1;
        System.out.println("Please choose a card: "+ cardIndex);
        return hand.remove(cardIndex);
    }
}
