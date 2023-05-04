import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.*;

// The MazeView class represents the view of the program. It is
// responsible for drawing the maze on a frame window. It contains
// a MazeModel object which represents the model of the program.
// MazeView is responsible for the graphics part of the program and
// MazeModel is responsible for the logic and storing the data necessary
// to execute the program.

public class MazeView extends JFrame
{
    // Instance Variables
    private MazeModel mazeModel;       // maintains the data
    private GridPanel gridPanel;
    private ControlPanel controlPanel;

    // Constructor
    public MazeView(MazeModel model)
    {
        mazeModel = model;
        Container contentPane = getContentPane();
        gridPanel = new GridPanel();
        contentPane.add(gridPanel, BorderLayout.CENTER);
        controlPanel = new ControlPanel();
        contentPane.add(controlPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Maze");
        setSize(407, 470);
        setVisible(true);
    }

    // The isResizable method is overridden so that the
    // frame window cannot be resized.
    public boolean isResizable()
    {
        return false;
    }

    // This panel draws and maintains the maze grid
    public class GridPanel extends JPanel
    {
        final Color FINISH = Color.red;
        final Color WALL = new Color(89, 51, 1);
        final Color PATH = new Color(255, 243, 211);
        final Color MOUSE = Color.gray;
        final Color TRACK = Color.green;

        // Constructor
        public GridPanel()
        {
            setBackground(Color.white);
            setPreferredSize(new Dimension(400,400));
        }

        // paintComponent is called each time the panel needs
        // to be redrawn.
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            DrawGrid(g);
        }

        // DrawGrid - draws the grid on the panel
        public void DrawGrid(Graphics g)
        {
           for(int c = 0; c < 400; c+=20)
           {
             for(int r = 0; r < 400; r+=20)
              {
                 Location loc = new Location(r/20, c/20);
                 if(mazeModel.isExit(loc))
                     g.setColor(FINISH);
                 if(mazeModel.isWall(loc))
                     g.setColor(WALL);
                 if(mazeModel.isPath(loc))
                     g.setColor(PATH);
                 if(mazeModel.isMouse(loc))
                     g.setColor(MOUSE);
                 if(mazeModel.isTrack(loc))
                     g.setColor(TRACK);

                 g.fill3DRect(c, r, 20, 20,true);
              }
           }
        }
    }

    // This panel is the placeholder for the buttons and slider
    public class ControlPanel extends JPanel implements ActionListener, ChangeListener
    {
        // Instance Variables
        private JButton newMazeButton;
        private JButton startButton;
        private JSlider slider;
        private int delayInterval;
        private long time;
        private SearchThread thread;
        boolean needNewMaze;

        // Constructor
        public ControlPanel()
        {
           newMazeButton = new JButton(" New Maze ");
           startButton = new JButton("   Start   ");
           slider = new JSlider(0,600, 300);
           add(newMazeButton);
           add(slider);
           add(startButton);

           setBackground(new Color(225, 225, 225));
           newMazeButton.addActionListener(this);
           startButton.addActionListener(this);
           slider.addChangeListener(this);
           delayInterval = 300;
           thread = null;
           needNewMaze = false;
        }

        // The actionPerformed method is called when a button is
        // clicked.
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();

            // New Maze Button is Pressed
            if(source == newMazeButton)
            {
                mazeModel.createMaze();
                gridPanel.repaint();
                thread = null;
                needNewMaze = false;
            }

            // Start Button is Pressed
            if(needNewMaze == true)
            {
                JOptionPane.showMessageDialog(getParent(), "You need to create a new maze.");
            }
            else if(source == startButton)
            {
                needNewMaze = true;

                if(thread != null)
                   thread = null;
                else
                {
                    thread = new SearchThread();
                    thread.setDaemon(true);
                    thread.start();
                }

            }
        }

        // The stateChanged method is called when the slider
        // is moved.
        public void stateChanged(ChangeEvent event)
        {
            delayInterval = slider.getValue();
        }

        // The delay method is used control the speed of the
        // mouse when the slider is used.
        public void delay()
        {
             try
             {
                time += delayInterval;
                Thread.sleep(Math.max(0, time - System.currentTimeMillis()));
             }
             catch(InterruptedException ex)
             {

             }
        }

        // The SearchThread method is in charge of starting
        // and monitoring the mouse movement through the maze.
        public class SearchThread extends Thread
        {
           public void run()
           {
               time = System.currentTimeMillis();
               int searchResult = mazeModel.SEARCHING;
               while( searchResult == mazeModel.SEARCHING && needNewMaze == true)
               {
                  gridPanel.repaint();
                  delay();
                  searchResult = mazeModel.searchMaze();
               }

               if(searchResult == mazeModel.EXITFOUND)
               {
                  JOptionPane.showMessageDialog(getParent(), "Mouse found an exit!");
               }

               if(searchResult == mazeModel.NOEXITFOUND)
               {
                  JOptionPane.showMessageDialog(getParent(), "Mouse could not find an exit.");
               }

           }

        }
    }
}