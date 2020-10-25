import java.util.ArrayList;

/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents a reservation for a boat
 */
public class BoatReservation extends Reservation
{
    private ArrayList<String> boatPref;

    /**
     *Constructor that sets the customer name and time slot for the boat reservation
     */
    public BoatReservation(String customerName, int timeSlot)
    {
        super(customerName, timeSlot);
        boatPref = new ArrayList<String>();
    }

    /**
     *Adds a boat to the preference list
     */
    public void addBoatPreference(String boatName)
    {
        boatPref.add(boatName);
    }

    /**
     *Gets a score for the boat with the given preference list in mind
     */
    @Override
    public int getScore(ReservableItem resItem)
    {
        if (resItem != null && resItem instanceof Boat)
        {
            Boat boat = (Boat)resItem;

            if (!boat.isAvailable(this.getTime()))
            {
                return 0;
            }
            else
            {
                //The closer to the start of the list, the better the boat is
                for (int i = 0; i < boatPref.size(); i++)
                {
                    if (boatPref.get(i).equals(boat.getId()))
                    {
                        return 100 - i;
                    }
                }
            }
        }
        return 0;
    }

    /**
     *Returns a deep copy of this object
     */
    @Override
    public BoatReservation clone()
    {
        return new BoatReservation(this.getCustomer(), this.getTime());
    }
}
