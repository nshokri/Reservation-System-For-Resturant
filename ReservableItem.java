/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents an item that can be reserved
 */
public abstract class ReservableItem implements Cloneable
{
    private String id;
    protected boolean[] timeSlots;

    /**
     *Constructor that stores the id of the item and instantiates the time slots
     */
    public ReservableItem(String id)
    {
        this.id = id;
        timeSlots = new boolean[10];
    }

    /**
     *Returns the ID the the item being reserved
     */
    public String getId()
    {
        return id;
    }

    /**
     *Returns true only if the time slot is available
     */
    public boolean isAvailable(int t)
    {
        return !timeSlots[t];
    }

    /**
     *If the item slot is available to be reserved, it will mark the time slot
     * as reserved
     */
    public void reserveTime(int t)
    {
        if(timeSlots[t] == false)
        {
            timeSlots[t] = true;
        }
    }

    /**
     *Returns a deep copy
     */
    @Override
    public abstract ReservableItem clone();
}
