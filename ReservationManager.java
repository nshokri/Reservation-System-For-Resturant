import java.util.ArrayList;

/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */


/**
 * A class that handles all reservations and keeps track of the
 * reserved items
 */
public class ReservationManager
{

    private ArrayList<Reservation> reservations;
    private ArrayList<ReservableItem> reservableItems;

    /**
     * Constructor that instantiates the reservations and reservableItems list
     */
    public ReservationManager()
    {
        reservations = new ArrayList<Reservation>();
        reservableItems = new ArrayList<ReservableItem>();
    }

    /**
     *Adds the given item to list to be reserved
     */
    public void addReservable(ReservableItem item)
    {
        //Used clone to prevent privacy leeks
        reservableItems.add(item.clone());
    }

    /**
     *Makes a reservation if the given reservation is available
     */
    public void makeReservation(Reservation trailRes)
    {
        int bestScore = 0;
        int bestScoreIndex = -1;

        for (int i = 0; i < reservableItems.size(); i++)
        {
            //Checks if it is the best possible time
            if (trailRes.getScore(reservableItems.get(i)) > bestScore)
            {
                bestScore = trailRes.getScore(reservableItems.get(i));
                bestScoreIndex = i;
            }
        }

        if (bestScore > 0)
        {
            //Adds both reserved item and reservation to list also sets reservation id
            reservableItems.get(bestScoreIndex).reserveTime(trailRes.getTime());

            //Used clone to prevent privacy leeks
            Reservation clone = trailRes.clone();

            clone.setResourceId(reservableItems.get(bestScoreIndex).getId());
            reservations.add(clone);
        }
        else
        {
            System.out.println("Unsuccessful reservation: " + trailRes.toString());
        }
    }

    /**
     * Sorts all the reservation's by customer name
     */
    //Algorithm was taken from in-class lecture slides
    public void sortReservations()
    {
        //Bubble sort
        boolean swap = true;
        int i = 0;

        while (swap)
        {
            swap = false;
            for (int j = 0; j < reservations.size() - i - 1; j++)
            {
                //NOTE: the compareTo on reservations compares customer names
                if (reservations.get(j).compareTo(reservations.get(j + 1)) > 0)
                {
                    Reservation temp = reservations.get(j + 1);
                    reservations.set(j + 1, reservations.get(j));
                    reservations.set(j, temp);

                    swap = true;
                }
            }
            i++;
        }
    }

    /**
     *Returns a string the represents all the current reservations in the list
     */
    @Override
    public String toString()
    {
        String s = "";

        for (Reservation n : reservations)
        {
            s += n.toString() + "\n";
        }

        return s;
    }
}
