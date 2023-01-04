public class CandidateNotFoundException extends Exception{
    String name;

    public CandidateNotFoundException(String name) {
        this.name = name;
    }
}