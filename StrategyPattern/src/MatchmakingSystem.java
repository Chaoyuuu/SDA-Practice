import individual.Individual;

import java.util.*;

import static individual.Coord.coord;
import static individual.Gender.FEMALE;
import static individual.Gender.MALE;

public class MatchmakingSystem {
    private final MatchStrategy strategy;
    private final List<Individual> individuals = new LinkedList<>();

    public MatchmakingSystem(MatchStrategy strategy) {
        this.strategy = strategy;
    }

    public void addIndividuals(Individual[] newIndividuals) {
        individuals.addAll(Arrays.asList(newIndividuals));
    }

    public void matchAndShowResult() {
        List<String[]> matchingResult = this.match();
        matchingResult.forEach(r -> System.out.printf("Individual %s matchs Individual %s\n", r[0], r[1]));
    }

    public List<String[]> match() {
        List<String[]> matchingResult = new LinkedList<>();
        for (Individual toBeMatched: individuals) {
            Optional<Individual> fittedUser = strategy.match(toBeMatched, individuals);
            String fittedUserId = fittedUser.isPresent()?fittedUser.get().getId() : "No Matching";
            matchingResult.add(new String[]{toBeMatched.getId(), fittedUserId});
        }
        return matchingResult;
    }

    private static Individual[] createIndividuals() {
        Individual A = new Individual(1, FEMALE, 20, "A", coord(10, 2), "movie", "music", "drawing");
        Individual B = new Individual(2, MALE, 21, "B", coord(2, 5), "cat", "food", "drawing");
        Individual C = new Individual(3, FEMALE, 20, "B", coord(6, 1), "water", "movie", "music");
        return new Individual[]{A, B, C};
    }

    public static void main(String[] args) {
        MatchmakingSystem system = new MatchmakingSystem(new DistanceBasedStrategy());
        system.addIndividuals(createIndividuals());
        system.matchAndShowResult();
    }
}
