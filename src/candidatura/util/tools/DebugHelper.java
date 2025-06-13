package candidatura.util.tools;

import java.util.concurrent.ThreadLocalRandom;

import static candidatura.util.constants.Constants.BaseSalary.salariesIntended;
import static candidatura.util.constants.Constants.CandidatesEvaluationValues.maxV;
import static candidatura.util.constants.Constants.CandidatesEvaluationValues.minV;

public class DebugHelper {

    public static Vector2 getBaseSalaryRange() {
        return new Vector2(salariesIntended.getFirst(), salariesIntended.getLast());
    }

    public static double getRandomSalaryValue() {
        double min = getBaseSalaryRange().x;
        double max = getBaseSalaryRange().y;

        double raw = ThreadLocalRandom.current().nextDouble(min, max);

        // Arredonda para duas casas decimais
        return Math.round(raw * 100.0) / 100.0;
    }

    public static double getRandomNoteValue() {
        return ThreadLocalRandom.current().nextDouble(minV, maxV);
    }

    public static boolean isContacted() {
        return ThreadLocalRandom.current().nextBoolean();
    }

}
