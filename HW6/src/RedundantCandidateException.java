public class RedundantCandidateException extends Exception {
    String name;


    public RedundantCandidateException(String name) {
        this.name = name;
    }
}