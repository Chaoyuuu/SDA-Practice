package individual;

import java.util.Arrays;

public class Individual {
    private final int id;
    private final Gender gender;
    private final int age;
    private final String intro;
    private final String[] habits;
    private final Coord coord;

    public Individual(int id, Gender gender, int age, String intro, Coord coord, String... habits) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.intro = intro;
        this.habits = habits;
        this.coord = coord;
        validation();
    }

    public String[] getHabits() {
        return habits;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getId() {
        return String.valueOf(id);
    }

    private void validation() {
        if (id <= 0 || age < 18 || intro.length() > 200) {
            throw new IllegalArgumentException("Invalid individual.Individual Argument");
        }

        Arrays.stream(habits).forEach(h -> {
            if (h.length() > 10) {
                throw new IllegalArgumentException("Invalid individual.Individual Argument");
            }
        });
    }
}
