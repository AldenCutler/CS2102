import java.util.HashMap;
import java.util.Set;
public class VotingData {
    private HashMap<String, Candidate> ballot = new HashMap<String, Candidate>();
    VotingData() {
        try {
            this.nominateCandidate("Gompei");
            this.nominateCandidate("Husky");
            this.nominateCandidate("Laurie Leshin");
        } catch (Exception e){}
    }

    /**
     *
     * @param name represents the name of the candidate
     * @return true if the given candidate is on the ballot, false otherwise
     */
    public boolean isCandidateOnBallot (String name) {
        return ballot.containsKey(name);
    }


    /**
     *
     * @param first represents the user's first choice vote
     * @param second represents the user's second choice vote
     * @param third represents the user's third choice vote
     * @throws CandidateNotFoundException if the user's choice isn't a valid candidate on the ballot
     * @throws CandidateChosenMoreThanOnceException if the user tries to vote for the same candidate twice
     */
    public void submitVote (String first, String second, String third) throws CandidateNotFoundException, CandidateChosenMoreThanOnceException {
        if (!isCandidateOnBallot(first)) throw new CandidateNotFoundException(first);
        if (!isCandidateOnBallot(second)) throw new CandidateNotFoundException(second);
        if (!isCandidateOnBallot(third)) throw new CandidateNotFoundException(third);

        // Check for duplicate vote
        if (second.equals(first)) throw new CandidateChosenMoreThanOnceException(second);
        if (third.equals(first) || third.equals(second)) throw new CandidateChosenMoreThanOnceException(third);

        ballot.get(first).vote(1);
        ballot.get(second).vote(2);
        ballot.get(third).vote(3);
    }


    /**
     *
     * @param name represents the name of the candidate to be added to the ballot
     * @throws RedundantCandidateException if the candidate to be added to the ballot is already present on the ballot
     */
    public void nominateCandidate(String name) throws RedundantCandidateException {
        if (ballot.containsKey(name)) throw new RedundantCandidateException(name);
        ballot.put(name, new Candidate(name));
    }

    /**
     *
     * @return the candidate with the most first choice votes
     */
    public String pickWinnerMostFirstChoice() {
        int totalVotes = 0;
        Candidate currWinner = null;

        for (Candidate c : ballot.values()) {
            if (currWinner == null) {
                currWinner = c;
            } else if (c.getFirstVotes() > currWinner.getFirstVotes()) {
                currWinner = c;
            }
            totalVotes += c.getFirstVotes();
        }
        if (currWinner.getFirstVotes() > totalVotes / 2) {
            return currWinner.name;
        } else return "*Requires Runoff Poll*";
    }


    /**
     *
     * @return the candidate with the most points under the following formula: a candidate's points is the biggest number out of their first place votes, second place votes, and third place votes
     */
    public String pickWinnerMostAgreeable() {
        Candidate currWinner = null;

        for (Candidate c : ballot.values()) {
            if (currWinner == null) {
                currWinner = c;
            } else if (c.getPoints() > currWinner.getPoints()) {
                currWinner = c;
            }
        }
        return currWinner.name;
    }


    /**
     *
     * @return the ballot hashset
     */
    public Set<String> getCandidates() {
        return ballot.keySet();
    }
}
