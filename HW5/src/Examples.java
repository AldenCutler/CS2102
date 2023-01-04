import java.util.GregorianCalendar;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {
    GregorianCalendar date = new GregorianCalendar();
    int month = date.get(GregorianCalendar.MONTH);
    int year = date.get(GregorianCalendar.YEAR);
    LinkedList<Integer> rankings = new LinkedList<>();

    LinkedList<Integer> downloads = new LinkedList<>();

    LinkedList<TodaysRatings> tRList = new LinkedList<>();
    TodaysRatings TR = new TodaysRatings(date, rankings, downloads);
    TodaysRatingsLinkedList  tRLL = new TodaysRatingsLinkedList(tRList);
    RadioStation RS = new RadioStation(tRLL, date);

    @Test
    public void testBestRankThisMonth(){
        tRList.add(TR);
        rankings.add(1);
        rankings.add(2);
        rankings.add(3);
        assertEquals(1, RS.bestRankThisMonth());
    }

    @Test
    public void testFalseBestRankThisMonth(){
        rankings.add(1);
        rankings.add(2);
        rankings.add(3);
        assertNotEquals(3, RS.bestRankThisMonth());
    }

    @Test
    public void testBestRankThisMonthNoData(){
        LinkedList<TodaysRatings> todaysRatings = new LinkedList<>();
        DataCollection ratingsList = new TodaysRatingsLinkedList(todaysRatings);
        GregorianCalendar today = new GregorianCalendar();
        RadioStation radio = new RadioStation(ratingsList, today);
        assertEquals(Integer.MAX_VALUE, radio.bestRankThisMonth());
    }

    @Test
    public void testLowestRank(){
        rankings.add(1);
        rankings.add(2);
        rankings.add(3);
        assertEquals(1, TR.lowestRank());
    }

    @Test
    public void testInMonth(){
        assertTrue(TR.inMonth(date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.YEAR)));
    }

    @Test
    public void testInMonthFalse(){
        assertFalse(TR.inMonth(0, 0));
    }

    @Test
    public void testTotalSongDownloads(){
        LinkedList<Survey> surveys = new LinkedList<>();
        surveys.add(new Survey(4, 50));
        surveys.add(new Survey(3, 80));
        surveys.add(new Survey(2, 85));
        surveys.add(new Survey(1, 100));
        RS.addTodaysSurveys(surveys);
        assertEquals(315, RS.totalSongDownloads(month, year));
    }

    @Test
    public void testTotalSongDownloads2(){
        LinkedList<Survey> surveys = new LinkedList<>();
        surveys.add(new Survey(4, 50));
        surveys.add(new Survey(3, 80));
        surveys.add(new Survey(2, 85));
        surveys.add(new Survey(1, 100));
        RS.addTodaysSurveys(surveys);
        assertNotEquals(0, RS.totalSongDownloads(month, year));
    }

    @Test
    public void testTotalSongDownloadsNoData(){
        assertEquals(0, RS.totalSongDownloads(0, 0));
    }

    @Test
    public void testTotalDownloads(){
        downloads.add(50);
        downloads.add(100);
        assertEquals(150, TR.totalDownloads());
    }




}