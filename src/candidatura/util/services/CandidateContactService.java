package candidatura.util.services;

import candidatura.model.Candidate;

import static candidatura.util.constants.Constants.CandidatesContactValues.maxContactTries;
import static candidatura.util.tools.DebugHelper.isContacted;

public class CandidateContactService {

    public void contact(Candidate candidate) {
        do {
            candidate.setContacted(isContacted());
            candidate.addContactTries();

            if (candidate.isContacted())
                break;

        } while (!candidate.isContacted() && candidate.getTriedContacts() < maxContactTries);

        if (candidate.isContacted()) {

            System.out.println(
                    "Conseguimos contato com o candidato ["
                            + candidate.getName()
                            + "] na tentativa ["
                            + candidate.getTriedContacts()
                            + "]"
            );
        } else {

            System.out.println(
                    "Não conseguimos contato com o candidato ["
                            + candidate.getName()
                            + "] na "
                            + candidate.getTriedContacts()
                            + " tentativa"
            );
        }
    }

}
