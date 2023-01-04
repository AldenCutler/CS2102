import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysRatingsLinkedList implements DataCollection {
    private LinkedList<TodaysRatings> todaysRatings;

    public TodaysRatingsLinkedList(LinkedList<TodaysRatings> todaysRatings) {
        this.todaysRatings = todaysRatings;
    }

    /**
     *
     * @param month represents the given month
     * @param year represents the given year
     * @return an integer representing the total number of downloads for all the TodaysRatings objects given that their
     *         dates are within the given month of the given year
     */
    public int totalDownloads(int month, int year) {
        int totalDownloads = 0;
        for (TodaysRatings ratings : todaysRatings) {
            if(ratings.inMonth(month, year)) {
                totalDownloads += ratings.totalDownloads();
            }
        }
        return totalDownloads;
    }

    /**
     *
     * @return an integer representing the smallest, or best, rank in the list of TodaysRatings objects
     */
    public int smallestRank() {
        int smallest = Integer.MAX_VALUE;
        for (TodaysRatings rating : this.todaysRatings) {
            int lowest = rating.lowestRank();
            if(smallest > lowest) {
                smallest = lowest;
            }
        }
        return smallest;
    }

    /**
     *
     * @param surveys represents a linked list of Survey objects
     * @param today represents the date
     * The method takes each survey object in the list and uses it to construct a new TodaysRatings object with all the Survey data
     */
    public void addSurvey(LinkedList<Survey> surveys, GregorianCalendar today) {
        LinkedList<Integer> ranks = new LinkedList<>();
        LinkedList<Integer> downloads = new LinkedList<>();


        for (Survey survey : surveys) {
            ranks.add(survey.getRank());
            downloads.add(survey.getDownloads());
        }

        // construct thing
        this.todaysRatings.add(new TodaysRatings(today, ranks, downloads));
    }

}
