package candidatura;

import candidatura.model.Candidate;
import candidatura.util.services.CandidatesCashEvaluationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static candidatura.util.services.SalaryService.getBaseSalaryRange;

public class CandidateEvaluation {
    protected static CandidatesCashEvaluationService candidatesCashE = new CandidatesCashEvaluationService();
    protected static List<Candidate> candidates = new ArrayList<>();
    protected static List<Candidate> selectedCandidates = new ArrayList<>();

    public CandidateEvaluation() {
        initCandidates();
        initEvaluation();

        showApprovedCandidate();
    }

    private void showApprovedCandidate(){
        for(Candidate c : selectedCandidates){
            System.out.println("O candidato(a): " + c.getName() + " foi aprovado para a próxima fase");
        }
    }

    private int candidateLimit = 5;
    private final double minV = 0;
    private final double maxV = 5;

    /// Inicia o processo seletivo automatizado
    private void initEvaluation() {
        for (int i = 0; i < candidates.size(); i++) {
            if (selectedCandidates.size() == candidateLimit) {
                break;
            }

            Candidate currentC = candidatesCashE.checkCandidate(
                    candidates.get(i),
                    minV,
                    maxV
            );

            if (currentC == null) continue;

            selectedCandidates.add(currentC);
        }
    }

    /// Inicia todos os candidatos(Pode ser substituído por uma busca num banco de dados caso queira expandir)
    private void initCandidates() {
        candidates.addAll(
                Arrays.asList(
                        new Candidate("Felipe", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Marcia", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Julia", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Paulo", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Augusto", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Ana", getRandomNoteValue(), getRandomSalaryValue()),
                        new Candidate("Maria", getRandomNoteValue(), getRandomSalaryValue())
                ));
    }

    public double getRandomSalaryValue() {
        double min = getBaseSalaryRange().x;
        double max = getBaseSalaryRange().y;

        double raw = ThreadLocalRandom.current().nextDouble(min, max);

        // Arredonda para duas casas decimais
        return Math.round(raw * 100.0) / 100.0;
    }

    public double getRandomNoteValue() {
        return ThreadLocalRandom.current().nextDouble(minV, maxV);
    }
}
