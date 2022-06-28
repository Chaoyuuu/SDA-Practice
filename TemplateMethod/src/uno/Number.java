package uno;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Number {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");

    private final String value;

    Number(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Stream<Number> getValues() {
        return Arrays.stream(Number.values());
    }
}
