public class StoreItem {

    String name;
    String dept;
    int numDaysOnShelf;
    int expDate;

    public StoreItem(String name, String dept, int numDaysOnShelf, int expDate) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = numDaysOnShelf;
        this.expDate = expDate;
    }

    public StoreItem(String name, String dept, int expDate) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = 0; //used for items that were just put on the shelf
        this.expDate = expDate;
    }

    public StoreItem(String name, String dept) {
        this.name = name;
        this.dept = dept;
        this.numDaysOnShelf = 0;
        this.expDate = -1; //used for non-perishables like toilet paper, kitchen utensils, etc.
    }

    public boolean equals(StoreItem storeItem) {
        return this.expDate == storeItem.expDate && this.dept.equals(storeItem.dept);
    }

}