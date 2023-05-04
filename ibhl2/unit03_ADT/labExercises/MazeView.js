'use strict';

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
        this.runID;
        this.startID;
        this.delayTime;
        this.searchResult;
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

            if (this.searchResult === EXITFOUND) {
                alert("Mouse found an exit!");
            } else if (this.searchResult === NOEXITFOUND) {
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