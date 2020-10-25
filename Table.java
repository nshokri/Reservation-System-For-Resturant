import java.util.Scanner;

/**
 * Name: Nick Shokri
 * Section: C (8:45AM - 10:45AM)
 * Assignment: ReservationSystem
 */

/**
 * A class that represents a table that can be reserved
 */
public class Table extends ReservableItem
{
    private int seats;

    /**
     *Reads the first line of input and assign the id and number
     * of seats to the table
     */
    public Table(Scanner inFile)
    {
        this(inFile.nextLine().split(" "));
    }

    /**
     *Private constructor used to parse the line given from the scanner
     */
    private Table(String[] line)
    {
        super(line[0]);
        this.seats = Integer.parseInt(line[1]);
    }


    /**
     *Returns the number of seats at this table
     */
    public int getNumSeats()
    {
        return seats;
    }

    /**
     *Returns a deep copy of this object
     */
    @Override
    public Table clone()
    {
        String[] line = {this.getId(), this.seats + ""};
        return new Table(line);
    }

}
