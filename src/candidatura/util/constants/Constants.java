package candidatura.util.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

    //TODO:Ficar de olho nessa classe,
    // pois ela mando o compilador impedir a compilação por excesso de variáveis,
    // mesmo estando usando classes e constantes estáticas e finais

    /**
     * Armazena todos os valores constantes que serão usados para auxiliar o algorithm de avaliação*/
    public static class CandidatesEvaluationValues {
        public static final int candidateLimit = 5;
        public static final double minV = 0;
        public static final double maxV = 5;
    }

    /**
     * Armazena todos os valores constantes que serão usados para auxiliar o contato com os candidatos que passaram*/
    public static class CandidatesContactValues{
        public static final int maxContactTries= 3;
    }

    /**
     * Armazena todos os salários-base que um candidato pode ter dependendo do seu desempenho com o avaliador,
     * já que podemos ter mais de um salário base para os candidatos se basearem
     */
    public static class BaseSalary {
        public static final List<Double> salariesIntended = new ArrayList<>();

        static {
            salariesIntended.addAll(Arrays.asList(
                    2_000.00,
                    2_500.00,
                    3_000.00,
                    3_500.00,
                    4_000.00,
                    4_500.00,
                    5_000.00,
                    5_500.00,
                    6_000.00,
                    6_500.00,
                    7_000.00,
                    7_500.00,
                    8_000.00,
                    8_500.00,
                    9_000.00,
                    9_500.00,
                    10_000.00,
                    10_500.00
            ));
        }

    }

}
