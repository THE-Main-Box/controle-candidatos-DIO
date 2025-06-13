package candidatura.util.services;

import candidatura.model.Candidate;

import static candidatura.util.services.SalaryService.getSalary;

public class CandidatesCashEvaluationService {
    /**
     * @param candidate candidato a ser considerado
     * @param minV      valor mínimo da validação do processo seletivo
     * @param maxV      valor máximo para a validação do processo seletivo
     */
    public Candidate checkCandidate(Candidate candidate, double minV, double maxV) {
        try {
            double baseSalary = getSalary(candidate.getNote(), minV, maxV);

            if (baseSalary > candidate.getIntendedSalary()) {

//                System.out.println("LIGAR PARA CANDIDATO ["
//                        + candidate.getName()
//                        + "] "
//                        + " | "
//                        + candidate.getIntendedSalary()
//                        + " / "
//                        + baseSalary+ "\n"
//                );

                candidate.setOptimalSalaryExpectations(true);

            } else if (baseSalary == candidate.getIntendedSalary()) {
//
//                System.out.println("LIGAR PARA CANDIDATO ["
//                        + candidate.getName()
//                        + "] "
//                        + "COM CONTRA PROPOSTA"
//                        + " | "
//                        + candidate.getIntendedSalary()
//                        + " / "
//                        + baseSalary+ "\n"
//                );

                candidate.setOptimalSalaryExpectations(false);

            } else {
//                System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS ["
//                        + candidate.getName()
//                        + "] "
//                        + " | "
//                        + candidate.getIntendedSalary()
//                        + " / "
//                        + baseSalary + "\n"
//                );

                return null;
            }
            return candidate;

        } catch (IllegalArgumentException e) {
            System.out.printf("A nota %s causou um erro, pois é: %s", candidate.getNote(), e.getMessage());
            return null;
        }
    }

}
