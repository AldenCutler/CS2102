import java.util.LinkedList;

public interface IBorrowable {
    double lateFee(int days);
}

public abstract class LibItem {
    String title;
    int timesOut;
    boolean isOverdue;
    String location;


    public LibItem(String title, String location, int timesOut, boolean isOverdue) {
        this.title = title;
        this.location = location;
        this.timesOut = timesOut;
        this.isOverdue = isOverdue;
    }

    public LibItem(String title, String location, int timesOut) {
        this.title = title;
        this.location = location;
        this.timesOut = timesOut;
        this.isOverdue = false;
    }
}

public class Library {
    LinkedList<LibItem> holdings = new LinkedList<LibItem>();

    public Library(LinkedList<LibItem> holdings) {
            this.holdings = holdings;
    }

    public LibItem findByTitle(String title) {
        for (int i = 0; i < holdings.size(); i++) {
            LibItem anItem = holdings.get(i);
            if (anItem.title.equals(title)) {
                return anItem;
            }
        } return null;
    }
}

public class DVD extends LibItem implements IBorrowable {

    public DVD(String title, String location, int timesOut, boolean isOverdue)  {
        super(title, location, timesOut, isOverdue);
    }

    public double lateFee(int days){
        if (days <= 3) return 5.0;
        else return 20.0;
    }
}