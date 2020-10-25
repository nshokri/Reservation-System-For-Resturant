import java.util.Scanner;
/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents a Boat that can be reserved
 */
public class Boat extends ReservableItem
{

    /**
     *Constructor that takes an Scanner that contains boat info
     */
    public Boat(Scanner inFile)
    {
        super(inFile.nextLine());
    }

    /**
     *Private constructor used by clone
     */
    private Boat(String id)
    {
        super(id);
    }

    /**
     *Returns a deep copy of this object
     */
    @Override
    public Boat clone()
    {
        return new Boat(this.getId());
    }
}
