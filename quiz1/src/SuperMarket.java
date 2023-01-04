


public class SuperMarket {
    String companyName;
    String streetAddress;
    boolean openTwentyFourHours;
    int numEmployees;
    double customersPerDay;

    //Constructor omitted

    SuperMarket (String companyName, String streetAddress, boolean openTwentyFourHours, Integer numEmployees, double customersPerDay) {
        this.companyName = companyName;
        this.streetAddress = streetAddress;
        this.openTwentyFourHours = openTwentyFourHours;
        this.numEmployees = numEmployees;
        this.customersPerDay = customersPerDay;
    }

    /** Determines if this supermarket is busier than another
     * compares customers per employee per day of the supermarkets
     * considers a supermarket to be twice as busy if it is not open 24 hours.
     * @param other a supermarket to compare to
     * @return true if this supermarket is busier in the same amount of time
     */

    public boolean busierThan(SuperMarket other) {
        double scaleThisTime = 1;
        if(!this.openTwentyFourHours) {
            scaleThisTime = 2;
        }
        double scaleOtherTime = 1;
        if(!other.openTwentyFourHours) {
            scaleOtherTime = 2;
        }

        double thisCustPerEmpDay  = (this.customersPerDay / this.numEmployees);
        double otherCustPerEmpDay = (other.customersPerDay / other.numEmployees);

        if(scaleThisTime * thisCustPerEmpDay > scaleOtherTime * otherCustPerEmpDay)
            return true;
        else
            return false;
    }



}