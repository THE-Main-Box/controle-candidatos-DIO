package candidatura;

import candidatura.model.Candidate;
import candidatura.util.services.CandidateContactService;
import candidatura.util.services.CandidatesCashEvaluationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static candidatura.util.constants.Constants.CandidatesEvaluationValues.*;
import static candidatura.util.tools.DebugHelper.getRandomNoteValue;
import static candidatura.util.tools.DebugHelper.getRandomSalaryValue;

public class CandidateEvaluation {
    protected static CandidatesCashEvaluationService candidatesCashEService = new CandidatesCashEvaluationService();
    private static CandidateContactService candidateContactService = new CandidateContactService();
    protected static List<Candidate> candidates = new ArrayList<>();
    protected static List<Candidate> selectedCandidates = new ArrayList<>();

    public CandidateEvaluation() {
        initCandidates();
        initEvaluation();

        showApprovedCandidate();
    }

    private void showApprovedCandidate() {
        for (Candidate c : selectedCandidates) {
//            System.out.println("O candidato(a): " + c.getName() + " foi aprovado para a próxima fase");
            candidateContactService.contact(c);
        }
    }

    /// Inicia o processo seletivo automatizado
    private void initEvaluation() {
        for (Candidate candidate : candidates) {
            if (selectedCandidates.size() == candidateLimit) {
                break;
            }

            Candidate currentC = candidatesCashEService.checkCandidate(
                    candidate,
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


}
