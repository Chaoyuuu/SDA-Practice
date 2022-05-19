package individual;

public class Coord {
    private final double x;
    private final double y;

    private Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coord coord(double x, double y) {
        return new Coord(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Coord coord) {
        return Math.sqrt((x - coord.x) * (x - coord.x) + (y - coord.y) * (y - coord.y));
    }
}
