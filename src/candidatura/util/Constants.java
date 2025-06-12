package candidatura.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    /**
     * Armazena todos os salários-base,
     * já que podemos ter mais de um salário base para os candidatos se basearem
     */
    public class BaseSalary {
        private static final List<Double> salariesIntended = new ArrayList<>();

        static {
            salariesIntended.addAll(Arrays.asList(
                    2_000.00,
                    3_500.00,
                    4_000.00,
                    5_500.00,
                    10_000.00
            ));
        }

        /**
         * @param nota    valor do desempenho do candidato em na seleção
         * @param notaMin nota minima esperada
         *                para facilitar a escala de validação do candidato relativamente a seu salário base
         *                Serve para deixar o sistema de métrica mais flexível, o sistema normaliza tudo
         * @param notaMax nota máxima
         *                para facilitar a escala de validação do candidato relativamente a seu salário base
         *                Serve para deixar o sistema de métrica mais flexível, o sistema normaliza tudo
         */
        public static double getSalary(double nota, double notaMin, double notaMax) {
            // Garante que a nota está dentro do intervalo permitido
            if (nota < notaMin || nota > notaMax) {
                throw new IllegalArgumentException("Nota fora do intervalo permitido.");
            }

            // Normaliza a nota para um valor entre 0 e 1
            double normalized = (nota - notaMin) / (notaMax - notaMin);

            // Pega o índice máximo da lista de salários
            int maxIndex = salariesIntended.size() - 1;

            // Converte a nota normalizada em um índice proporcional na lista
            int index = (int) Math.round(normalized * maxIndex);

            // Retorna o salário correspondente ao índice calculado
            return salariesIntended.get(index);
        }

    }

}
