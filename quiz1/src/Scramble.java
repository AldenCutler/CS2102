interface IPrice {
    public double getCost();
}

class Bakery {
    IPrice purchase;

    public Bakery(IPrice purchase) {
        this.purchase = purchase;
    }

    public double checkPlease() {
        return purchase.getCost();
    }

    class BirthdayCake implements IPrice {
        boolean hasBirthdayMessage;
        public BirthdayCake(boolean hasBirthdayMessage) {
            this.hasBirthdayMessage = hasBirthdayMessage;
        }
        public double getCost() {
            if (hasBirthdayMessage == true) return 2.0;
            else return 1.5;

        }
    }

}




