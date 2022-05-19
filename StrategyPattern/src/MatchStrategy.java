import individual.Individual;

import java.util.List;
import java.util.Optional;

public abstract class MatchStrategy {

    public Optional<Individual> match(Individual me, List<Individual> candidates) {
        Individual fitted = null;
        double maxScore = 0;
        for (Individual candidate : candidates) {
            if (!candidate.equals(me) && maxScore < getMatchScore(me, candidate)) {
                fitted = candidate;
            }
        }
        return Optional.ofNullable(fitted);
    }

    protected abstract double getMatchScore(Individual me, Individual candidate);
}
