import individual.Individual;

import java.util.Arrays;

public class HabitBasedStrategy extends MatchStrategy {
    @Override
    protected double getMatchScore(Individual me, Individual candidate) {
        int score = 0;
        for (String myHabit : me.getHabits()) {
            if (Arrays.asList(candidate.getHabits()).contains(myHabit)) {
                score ++;
            }
        }
        return score;
    }
}
