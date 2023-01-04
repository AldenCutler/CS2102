import java.util.LinkedList;

public class Stock {

    LinkedList<LinkedList<StoreItem>> expItemsByDept = new LinkedList<LinkedList<StoreItem>>();
    LinkedList<StoreItem> expiredItems = new LinkedList<StoreItem>();
    LinkedList<StoreItem> otherItems = new LinkedList<StoreItem>();
    LinkedList<StoreItem> dairyItems = new LinkedList<StoreItem>();
    LinkedList<StoreItem> fruitItems = new LinkedList<StoreItem>();


    public Stock() {
    }

    LinkedList<LinkedList<StoreItem>> findExpiredItems(LinkedList<StoreItem> items, int todaysDate) {

        for (int i = 0; i < items.size(); i = i + 1) {
            StoreItem thisItem = items.get(i);
            if (thisItem.numDaysOnShelf > 7 || thisItem.expDate < todaysDate) {
                expiredItems.add(thisItem);
            }
        }
        for (int k = 0; k < expiredItems.size(); k = k + 1) {
            StoreItem anExpiredItem = expiredItems.get(k);
            if (anExpiredItem.dept.equals("fruit")) {
                fruitItems.add(anExpiredItem);
                expItemsByDept.add(fruitItems);
            } else if (anExpiredItem.dept.equals("dairy")) {
                dairyItems.add(anExpiredItem);
                expItemsByDept.add(dairyItems);
            } else {
                otherItems.add(anExpiredItem);
            }
            expItemsByDept.add(otherItems);
        }
        return expItemsByDept;
    }
}