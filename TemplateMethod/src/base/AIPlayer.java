package base;

public class AIPlayer extends Player {
    @Override
    public Card show() {
        int index = (int) (Math.random() * hands.size());
        return hands.remove(index);
    }

    @Override
    public void nameMySelf() {
        int id = (int) (Math.random() * 100) + 1;
        this.name = "AI" + id;
    }
}
