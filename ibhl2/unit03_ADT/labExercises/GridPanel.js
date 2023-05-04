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
                    context.fillStyle = FINISH_COLOR;
                if (this.mazeModel.isWall(loc))
                    context.fillStyle = WALL_COLOR;
                if (this.mazeModel.isPath(loc))
                    context.fillStyle = PATH_COLOR;
                if (this.mazeModel.isMouse(loc))
                    context.fillStyle = MOUSE_COLOR;
                if (this.mazeModel.isTrack(loc))
                    context.fillStyle = TRACK_COLOR;

                //console.log(c + "," + r);
                context.strokeStyle = "rgb(120, 120, 120)";
                context.strokeRect(c, r, 20, 20);
                context.fillRect(c, r, 20, 20);
            }
        }
        //requestAnimationFrame(this.drawGrid);
    }
}