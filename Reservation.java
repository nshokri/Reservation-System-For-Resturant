/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents a reservation request for a ReservableItem
 */
public abstract class Reservation implements Comparable, Cloneable
{
    private String customerName;
    private int timeSlot;
    private String id;

    /**
     * Constructor that takes customer name and the time slot
     */
    public Reservation(String customerName, int timeSlot)
    {
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }

    /**
     *Returns the score (0-100) of this reservation based on best fit
     */
    public abstract int getScore(ReservableItem resItem);

    /**
     *Returns the customer's name
     */
    public String getCustomer()
    {
        return customerName;
    }

    /**
     *Returns the time slot of this reservation
     */
    public int getTime()
    {
        return timeSlot;
    }

    /**
     *Returns the customer name and time slot of the reservation
     */
    public String toString()
    {
        return "Reservation customer: " + customerName + ", timeSLot: " + timeSlot + ", Resource ID: " + id;
    }

    /**
     *Sets the id of this reservation
     */
    public void setResourceId(String id)
    {
        this.id = id;
    }

    /**
     *Compares the customer's name of this reservation and
     * the customer's name the the given reservation
     * and returns either a positive, negative, or 0 based
     * on the name comparison.
     */
    @Override
    public int compareTo(Object o)
    {
        Reservation r;

        if (o != null && o instanceof Reservation)
        {
            r = (Reservation)o;
        }
        else
        {
            //I would throw an error but I don't want it to stop the program
            System.out.println("ERROR: Can't Compare");
            return -1;
        }

        return this.getCustomer().compareTo(r.getCustomer());
    }

    /**
     *Returns a deep copy clone
     */
    @Override
    public abstract Reservation clone();
}
