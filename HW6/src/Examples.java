import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    // method to set up a ballot and cast votes

    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");
            vd.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd);

    }

    VotingData setup2() {
        VotingData vd = new VotingData();

        try {
            vd.nominateCandidate("husky");
            vd.nominateCandidate("gompei");
            vd.nominateCandidate("ziggy");
        } catch (Exception e) {}

        try {
            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("husky", "ziggy", "gompei");
            vd.submitVote("ziggy", "gompei", "husky");
        } catch (Exception e) {}

        return vd;
    }

    // now run a test on a specific election
    @Test
    public void testMostFirstWinner () {
        assertEquals ("gompei", this.setup1().pickWinnerMostFirstChoice());
    }

    @Test
    public void testWinnerRunoff(){ // Uses setup2
        assertEquals("*Requires Runoff Poll*", this.setup2().pickWinnerMostFirstChoice());
    }

    @Test
    public void testMostAgreeableWinner(){
        assertEquals("gompei", this.setup1().pickWinnerMostAgreeable());
    }

    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void testDuplicateCandidates() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException {
        this.setup1().submitVote("gompei", "gompei", "husky");
    }

    @Test(expected = CandidateNotFoundException.class)
    public void testCandidateNotFound() throws CandidateChosenMoreThanOnceException, CandidateNotFoundException {
        this.setup1().submitVote("gompei", "corgi", "ziggy");
    }

    @Test(expected = RedundantCandidateException.class)
    public void testNominateDuplicateCandidate() throws RedundantCandidateException{
        this.setup1().nominateCandidate("husky");
    }

    @Test
    public void testIsCandidateOnBallotTrue(){
        assertTrue(this.setup1().isCandidateOnBallot("gompei"));
    }

    @Test
    public void testIsCandidateOnBallotFalse(){
        assertFalse(this.setup1().isCandidateOnBallot("corgi"));
    }

}
