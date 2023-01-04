// A class for storing guests at a (potentially large) event

import java.util.LinkedList;

class EventGuests {

    Object guests;



    EventGuests(Object guests) {

        this.guests = guests;

    }



    // record a new guest as coming (add the guest to the set)

    void addGuest(String newGuestName) {
        Object listClass = guests.getClass();
        this.guests = null;

    }



    // check whether a guest is coming (use hasElt() to see if
    // the guest is in the set)

    boolean isComing(String name) {

        return false;

    }

    // return the number of guests in the guest list 
    int numGuests(){

        return 0;

    }

}