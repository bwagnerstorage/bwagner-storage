'use strict';
// This class represents a location within a two
// dimensional grid. Each object contains a row
// and column value. The class also provides methods
// for moving from one location to another within the
// grid (i.e., North, South, East, and West)

class Location {
    // Constructor
    constructor(row, column) {
        this.row = row;
        this.column = column;
    }

    // Accessor Methods
    getRow() {
        return this.row;
    }

    getColumn() {
        return this.column;
    }

    // The north method returns a Location object
    // that is one row up from the current location.
    north() {
        return new Location(this.row - 1, this.column);
    }

    // The south method returns a Location object
    // that is one row down from the current location.
    south() {
        return new Location(this.row + 1, this.column);
    }

    // The east method returns a Location object
    // that is one column to the right of the current location.
    east() {
        return new Location(this.row, this.column + 1);
    }

    // The west method returns a Location object
    // that is one column to the left of the current location.
    west() {
        return new Location(this.row, this.column - 1);
    }

    equals(loc)
    {
        return loc.row === this.row && loc.column === this.column;
    }

    // toString method
    // returns a string representation of the Location object
    // in the following format [3,4].
    toString() {
        let str;
        str = "[" + this.row + ", " + this.column + "]";
        return str;
    }
}