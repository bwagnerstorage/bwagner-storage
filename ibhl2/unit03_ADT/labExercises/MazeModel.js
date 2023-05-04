'use strict';

// Constants
const EXIT = "X";
const WALL = "W";
const PATH = "P";
const MOUSE = "M";
const TRACK = "T";
const SEARCHING = 0;
const EXITFOUND = 1;
const NOEXITFOUND = 2;
const DONE = 3;

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
        this.mouseLoc; // current location
        this.mouseStart; // starting location
        this.noMorePaths;
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
    // through the maze.
    searchMaze() {
        console.log("searching...\n");
        let pathFound = false;
        let west = this.mouseLoc.west();
        if (this.inBounds(west) && pathFound === false) {
            if (this.isExit(west)) {
                return EXITFOUND;
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
                return EXITFOUND;
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
                return EXITFOUND;
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
                return EXITFOUND;
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
            return NOEXITFOUND; // cannot find an exit
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
                if (prob <= .4) // 40%
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