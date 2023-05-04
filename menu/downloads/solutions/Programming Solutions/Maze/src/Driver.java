import java.awt.*;
import javax.swing.*;

public class Driver
{
    public static void main(String[] args)
    {
        MazeModel mazeModel = new MazeModel();
        MazeView mazeView = new MazeView(mazeModel);
    }
}