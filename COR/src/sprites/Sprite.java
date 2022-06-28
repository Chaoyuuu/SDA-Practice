package sprites;

public class Sprite {
    private int location;
    private final Character symbol;
    private final int incineratorLocation = 100;

    public Sprite(int location, Character symbol) {
        this.location = location;
        this.symbol = symbol;
    }

    public void dead() {
        this.location = incineratorLocation;
    }

    public boolean isAlive() {
        return this.location < incineratorLocation;
    }

    public void move(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return symbol.toString() + ": " + location;
    }
}
