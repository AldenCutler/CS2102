import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface DataCollection {
    int totalDownloads(int month, int year);
    int smallestRank();
    void addSurvey(LinkedList<Survey> surveys, GregorianCalendar date);
}