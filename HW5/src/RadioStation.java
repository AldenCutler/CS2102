import java.util.GregorianCalendar;
import java.util.LinkedList;

public class RadioStation {
    private DataCollection ratingsList;
    private GregorianCalendar today;

    public RadioStation(DataCollection ratingsList, GregorianCalendar today) {
        this.ratingsList = ratingsList;
        this.today = today;
    }

    /**
     *
     * @return the best rank this month (best = smallest)
     */
    public int bestRankThisMonth() {
        return ratingsList.smallestRank();
    }

    /**
     *
     * @param month given month
     * @param year given year
     * @return returns the largest number of downloads for a song in the given month and year
     */
    public int totalSongDownloads(int month, int year) {
        return ratingsList.totalDownloads(month, year);
    }

    /**
     *
     * @param surveys a linked list of Survey objects, uses those surveys to construct a TodaysRatings object for the current date, saves the TodaysRatings object, as well as adds 1 day to the current date
     */
    public void addTodaysSurveys(LinkedList<Survey> surveys) {
        ratingsList.addSurvey(surveys, today);

        // Add 1 to day
        this.today.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }
}


/*

1. What might be a better data structure than a LinkedList<TodaysRatings> to encapsulate? Why?

Instead of using a LinkedList<TodaysRatings>, maybe we could use heaps to structure and process our data.
When working with LinkedLists, they can be inefficient because you have to reassign memory values whenever you modify them.

2. If you implemented a class to encapsulate that data structure as a field, how would that class implement the methods of the interface you designed?

Implementing smallestRank() would be really easy because by the definition of a heap, the smallest value is on top. To get the total number of song
downloads, we could use a recursive method to iterate through every item in the tree and add up all the downloads. As for addSurvey(), adding an element to a heap
requires knowing where in the heap the element should go.

3. Do you think it is possible to implement that class without modifying the interface? Why or why not?

If we were to implement that class, we would need to modify the interface to enable using recursive methods.

*/