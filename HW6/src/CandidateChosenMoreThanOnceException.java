public class CandidateChosenMoreThanOnceException extends Exception {
    String name;

    public CandidateChosenMoreThanOnceException(String name) {
        this.name = name;
    }
}