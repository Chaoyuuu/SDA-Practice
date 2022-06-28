package uno;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Color {
    BLUE("B"), YELLOW("Y"), RED("R"), GREEN("G");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

    public static Stream<Color> getValues() {
        return Arrays.stream(Color.values());
    }
}
