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

    equals(loc) {
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


const FINISH_COLOR = "rgb(255, 0, 0)";
const WALL_COLOR = "rgb(89, 51, 1)";
const PATH_COLOR = "rgb(255, 243, 211)";
const MOUSE_COLOR = "rgb(150, 150, 150)";
const TRACK_COLOR = "rgb(0, 255, 0)";

class GridPanel {
    // Constructor
    constructor(context, mazeModel) {
        this.context = context;
        this.mazeModel = mazeModel;
    }

    // DrawGrid - draws the grid on the panel
    drawGrid() {
        for (let c = 0; c < 400; c += 20) {
            for (let r = 0; r < 400; r += 20) {
                let loc = new Location(r / 20, c / 20);

                if (this.mazeModel.isExit(loc))
                    this.context.fillStyle = FINISH_COLOR;
                if (this.mazeModel.isWall(loc))
                    this.context.fillStyle = WALL_COLOR;
                if (this.mazeModel.isPath(loc))
                    this.context.fillStyle = PATH_COLOR;
                if (this.mazeModel.isMouse(loc))
                    this.context.fillStyle = MOUSE_COLOR;
                if (this.mazeModel.isTrack(loc))
                    this.context.fillStyle = TRACK_COLOR;

                this.context.strokeStyle = "rgb(120, 120, 120)";
                this.context.strokeRect(c, r, 20, 20);
                this.context.fillRect(c, r, 20, 20);
            }
        }
    }
}

// Constants
var EXIT = "X";
var WALL = "W";
var PATH = "P";
var MOUSE = "M";
var TRACK = "T";
var SEARCHING = 0;
var EXIT = 1;
var NO_EXIT = 2;
var DONE = 3;

class MazeModel {

    // Constructor
    constructor() {
        this.maze = [];
        for (let r = 0; r < 20; r++) {
            let columns = [];
            for (let c = 0; c < 20; c++) {
                columns[c] = "";
            }
            this.maze[r] = columns;
        }
        this.stack = [];
        this.mouseLoc = 0; // current location
        this.mouseStart = 0; // staring location
        this.noMorePaths = 0;
    }

    // The createMaze method initializes the stack and
    // sets the positions of the paths, walls, start, and
    // exit within the two-dimensional grid(maze). It also
    // places the mouse at its starting location within the
    // maze.
    createMaze() {
        // Assign paths
        this.setPaths();
        // Assign walls
        this.setWalls();
        // Assign starting position
        this.setStart();
        // Assign finish line
        this.setExit();
    }

    // The searchMaze method is responsible for finding a path
    // through the maze that will
    searchMaze() {
        console.log("searching...\n");
        let pathFound = false;
        let west = this.mouseLoc.west();
        if (this.inBounds(west) && pathFound === false) {
            if (this.isExit(west)) {
                return EXIT;
            }
            if (this.isPath(west)) {
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = TRACK;
                this.stack.push(this.mouseLoc);
                this.mouseLoc = west;
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
                pathFound = true;
            }
        }

        let north = this.mouseLoc.north();
        if (this.inBounds(north) && pathFound === false) {
            if (this.isExit(north)) {
                return EXIT_FOUND;
            }
            if (this.isPath(north)) {
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = TRACK;
                this.stack.push(this.mouseLoc);
                this.mouseLoc = north;
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
                pathFound = true;
            }
        }

        let south = this.mouseLoc.south();
        if (this.inBounds(south) && pathFound === false) {
            if (this.isExit(south)) {
                return EXIT_FOUND;
            }
            if (this.isPath(south)) {
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = TRACK;
                this.stack.push(this.mouseLoc);
                this.mouseLoc = south;
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
                pathFound = true;
            }
        }

        let east = this.mouseLoc.east();
        if (this.inBounds(east) && pathFound === false) {
            if (this.isExit(east)) {
                return EXIT_FOUND;
            }
            if (this.isPath(east)) {
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = TRACK;
                this.stack.push(this.mouseLoc);
                this.mouseLoc = east;
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
                pathFound = true;
            }
        }

        // Backtrack
        if (pathFound === false) {
            this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = TRACK;
            this.mouseLoc = this.stack.pop();
            if (this.mouseLoc !== undefined && this.mouseLoc.equals(this.mouseStart)) {
                this.noMorePaths = true;
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
                return SEARCHING;
            } else if (this.mouseLoc !== undefined)
                this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
            //  if (this.mouseLoc !== undefined)
            //     this.maze[this.mouseLoc.getRow()][this.mouseLoc.getColumn()] = MOUSE;
        }

        if (this.stack.length === 0) {
            return NO_EXIT; // cannot find an exit
        }

        return SEARCHING; // continue searching
    }

    clearStack() {
        this.stack = [];
    }

    // The setPaths method sets the entire grid cells
    // as paths.
    setPaths() {
        for (let r = 0; r < 20; r++) {
            for (let c = 0; c < 20; c++) {
                this.maze[r][c] = PATH;
            }
        }
    }

    // The setWalls method randomly sets the cells within the
    // grid to walls. There is a 40% chance that a path will
    // be turned into a wall.
    setWalls() {
        let prob = 0;
        for (let r = 0; r < 20; r++) {
            for (let c = 0; c < 20; c++) {
                prob = Math.random();
                if (prob <= 0.4) // 40%
                    this.maze[r][c] = WALL;
            }
        }
    }

    // The setStart method sets the starting position of
    // the mouse within the maze it is located along the
    // right boundary of the maze.
    setStart() {
        let r = Math.floor(Math.random() * 18) + 1;
        this.maze[r][19] = MOUSE;
        this.maze[r][18] = PATH;
        this.mouseLoc = new Location(r, 19);
        this.mouseStart = this.mouseLoc;
        this.stack.push(this.mouseLoc);
    }

    // The setExit method sets the exit for the maze. The
    // exit is located along the left boundary of the
    // maze
    setExit() {
        let r = Math.floor(Math.random() * 18) + 1;
        this.maze[r][0] = EXIT;
        this.maze[r][1] = PATH;
    }

    // The isExit method returns true if loc is the
    // same location as the exit; false otherwise.
    isExit(loc) {
        if (this.maze[loc.getRow()][loc.getColumn()] === EXIT)
            return true;
        else
            return false;
    }

    // The isWall method returns true if loc is a
    // wall; false otherwise.
    isWall(loc) {
        if (this.maze[loc.getRow()][loc.getColumn()] === WALL)
            return true;
        else
            return false;
    }

    // The isPath method returns true if loc is a
    // path; false otherwise;
    isPath(loc) {
        if (this.maze[loc.getRow()][loc.getColumn()] === PATH)
            return true;
        else
            return false;
    }

    // The isMouse method returns true if loc is the
    // mouse's position; false otherwise.
    isMouse(loc) {
        if (this.maze[loc.getRow()][loc.getColumn()] === MOUSE)
            return true;
        else
            return false;
    }

    // The isTrack method returns true if loc is a track.
    // A track is a position within the grid that the mouse
    // has already visited.
    isTrack(loc) {
        if (this.maze[loc.getRow()][loc.getColumn()] === TRACK)
            return true;
        else
            return false;
    }

    // The inBounds method returns true is loc is a valid
    // location within the grid; false otherwise.
    inBounds(loc) {
        if (loc.getRow() >= 0 && loc.getRow() <= 19 &&
            loc.getColumn() >= 0 && loc.getColumn() <= 19)
            return true;
        else
            return false;
    }

    toString() {
        let str = "";

        for (let r = 0; r < 20; r++) {
            for (let c = 0; c < 20; c++) {
                str += this.maze[r][c] + " ";
            }
            str += "\n";
        }
        return str;
    }

    getStackLength() {
        return this.stack.length;
    }

    getStack() {
        return this.stack;
    }

    flushStack() {
        while (this.stack.length != 0) {
            this.stack.pop();
        }
    }
}


// The MazeView class represents the view of the program. It is
// responsible for drawing the maze on a frame window. It contains
// a MazeModel object which represents the model of the program.
// MazeView is responsible for the graphics part of the program and
// MazeModel is responsible for the logic and storing the data necessary
// to execute the program.

class MazeView {

    // Constructor
    constructor(context, mazeModel) {
        this.context = context;
        this.mazeModel = mazeModel;
        this.gridPanel = new GridPanel(context, mazeModel);
        this.runID = 0;
        this.startID = 0;
        this.delayTime = 0;
        this.searchResult = 0;
        this.speedBar = document.getElementById("mazeSpeedRange");
        this.makeMaze();
    }

    newMaze() {
        this.makeMaze();
    }

    makeMaze() {
        this.mazeModel.createMaze();
        this.gridPanel.drawGrid();
    }

    startSearch() {
        this.delayTime = Number.parseInt(document.getElementById("mazeSpeedRange").value);
        this.mazeModel.clearStack();
        this.run();
    }

    run() {
        this.searchResult = SEARCHING;
        this.delayTime = Number.parseInt(document.getElementById("mazeSpeedRange").value);

        this.startID = window.setTimeout(() => {

            this.searchResult = this.mazeModel.searchMaze();

            if (this.searchResult === EXIT) {
                alert("Mouse found an exit!");
            } else if (this.searchResult === NO_EXIT) {
                alert("Mouse could not find an exit.");
            } else if (this.searchResult === SEARCHING) {
                this.runId = window.requestAnimationFrame(this.run.bind(this));
                this.gridPanel.drawGrid();
            } else {
                window.cancelAnimationFrame(this.runId);
                window.clearTimeout(this.startID);
            }
        }, this.delayTime);
    }
}