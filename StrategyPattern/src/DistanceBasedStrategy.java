import individual.Individual;

public class DistanceBasedStrategy extends MatchStrategy {
    @Override
    protected double getMatchScore(Individual me, Individual candidate) {
        return me.getCoord().distance(candidate.getCoord());
    }
}
