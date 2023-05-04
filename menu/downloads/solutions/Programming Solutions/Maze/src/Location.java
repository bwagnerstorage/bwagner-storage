// This class represents a location within a two
// dimensional grid. Each object contains a row
// and column value. The class also provides methods
// for moving from one location to another within the
// grid (i.e., North, South, East, and West)

public class Location
{
    // Instance variable
    private int row;
    private int column;
    
    // Constructor
    public Location(int r, int c)
    {
       row = r;
       column = c;  
    }
    
    // Accessor Methods
    public int getRow()
    {
        return row;
    }
    
    public int getColumn()
    {
        return column;
    }
    
    // The north method returns a Location object
    // that is one row up from the current location.
    public Location north()
    {
        return new Location(row-1, column);
    }
    
    // The south method returns a Location object
    // that is one row down from the current location.
    public Location south()
    {
        return new Location(row+1, column);
    }
    
    // The east method returns a Location object
    // that is one column to the right of the current location.
    public Location east()
    {
        return new Location(row, column+1);
    }

    // The west method returns a Location object
    // that is one column to the left of the current location.  
    public Location west()
    {
        return new Location(row, column-1);
    }
    
    // toString method
    // returns a string representation of the Location object
    // in the following format [3,4].
    public String toString()
    {
        String str;
        str = "[" + row + ", " + column + "]";
        return str;
    }
}