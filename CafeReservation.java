/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents a reservation for a cafe table
 */
public class CafeReservation extends Reservation
{
    private int numSeatsNeeded;

    /**
     *Constructor that assigns the given name, time slot, and number of needed seats
     * to this reservation
     */
    public CafeReservation(String name, int timeSlot, int numSeatsNeeded)
    {
        super(name, timeSlot);
        this.numSeatsNeeded = numSeatsNeeded;
    }

    /**
     *Based on what this reservation needs, will give a score from 0 - 100 determining
     * how good of a fit the given item is for this reservation
     */
    @Override
    public int getScore(ReservableItem resItem)
    {
        if (resItem != null && resItem instanceof Table)
        {
            Table table = (Table) resItem;
            int score = numSeatsNeeded - table.getNumSeats();

            //Must be available and able to seat all the people
            if (!table.isAvailable(this.getTime()) || score > 0)
            {
                return 0;
            } else if (score == 0)
            {
                return 100;
            }
            //The closer to 0, the better
            else if (score < 0)
            {
                return 100 + score;
            }
        }

        return 0;
    }

    /**
     *Returns a deep copy of this object
     */
    @Override
    public CafeReservation clone()
    {
        return new CafeReservation(this.getCustomer(), this.getTime(), this.numSeatsNeeded);
    }
}
