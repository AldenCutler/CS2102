import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysRatings {
    private GregorianCalendar date;
    private LinkedList<Integer> rankings;
    private LinkedList<Integer> downloads;

    TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankings, LinkedList<Integer> downloads) {
        this.date = date;
        this.rankings = rankings;
        this.downloads = downloads;
    }

    /**
     *
     * @return the lowest rank (equivalent to the best rank) in a list of rankings
     */
    public int lowestRank() {
        int lowest = Integer.MAX_VALUE;
        for(int rank : rankings) {
            if(rank < lowest) {
                lowest = rank;
            }
        }
        return lowest;
    }

    /**
     *
     * @return the total number of song downloads today
     */
    public int totalDownloads() {
        int total = 0;
        for (int downloadNum : this.downloads) {
            total += downloadNum;
        }
        return total;
    }

    /**
     *
     * @param month given month
     * @param year given year
     * @return true if this TodaysRatings object's date is in both the given month and year
     */
    public boolean inMonth(int month, int year) {
        return (this.date.get(GregorianCalendar.MONTH) == month) &&
                (this.date.get(GregorianCalendar.YEAR) == year);
    }
}