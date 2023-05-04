// This panel is the placeholder for the buttons and slider
class ControlPanel {
    // Instance Variables
    //private JButton newMazeButton;
    //private JButton startButton;
    //private JSlider slider;
    //private int delayInterval;
    //private long time;
    //private SearchThread thread;
    //boolean needNewMaze;

    // Constructor
    constructor(context, mazeModel) {
        this.mazeModel = mazeModel;
        this.needNewMaze = false;
        this.delayInterval = 0;
        this.time = 0;
    }

    // The actionPerformed method is called when a button is
    // clicked.
    newMaze() {
        mazeModel.createMaze();
        needNewMaze = false;
    }

    start() {
        if (needNewMaze == true) {
            alert("You need to create a new maze.");
        } else if (source == startButton) {
            needNewMaze = true;
        }
    }

    // The delay method is used control the speed of the
    // mouse when the slider is used.
    /*  delay() {
          try {
              time += delayInterval;
              Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
          } catch (InterruptedException ex) {

          }
      } */

    // The SearchThread method is in charge of starting
    // and monitoring the mouse movement through the maze.
    /*class SearchThread {
        run() {
            time = System.currentTimeMillis();
            let searchResult = mazeModel.SEARCHING;
            while (searchResult == mazeModel.SEARCHING && needNewMaze == true) {
                delay();
                searchResult = mazeModel.searchMaze();
            }

            if (searchResult == mazeModel.EXITFOUND) {
                alert("Mouse found an exit!");
            }

            if (searchResult == mazeModel.NOEXITFOUND) {
                alert("Mouse could not find an exit.");
            }

        }*/

}