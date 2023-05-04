import greenfoot.*;
import java.awt.*;  

/**
 * Write a description of class FlappyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int score = 0;
    ScoreBoard scoreBoard;
    
    final int SPACE_BETWEEN_PIPES = 275;
    final int FIRST_PIPE = 210;
    
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        setPaintOrder(Flappy.class, GameOver.class, Pipe.class);   
        
        Flappy flappy = new Flappy();
        addObject(flappy, 200, getHeight()/2);
        
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 400, 50);

    }
    
    public void act()
    {
        pipeCounter++;
        if(pipeCounter % 100 == 0)
        {
            createPipes();            
        }
        
        if(pipeCounter >= FIRST_PIPE)
        {
            if(flappyCounter % 100 == 0)
            {
                   displayScore();  
            }
            flappyCounter++;
            
        }
    }
    
    public void createPipes()
    {
        BottomPipe bottomPipe = new BottomPipe();
        GreenfootImage image = bottomPipe.getImage();
        int height = Greenfoot.getRandomNumber(150) + 20;
        addObject(bottomPipe, getWidth(), getHeight()/2 + image.getHeight() - height);
        
        TopPipe topPipe = new TopPipe();
        image = topPipe.getImage();
        addObject(topPipe, getWidth(), getHeight()/2 + image.getHeight()/2 - height - SPACE_BETWEEN_PIPES);

    }
    
    public void displayScore()
    {
        score++;
        scoreBoard.setScore(score);
    }
    
    public void started()
    {
        CountDown countDown = new CountDown();
        addObject(countDown, getWidth()/2, getHeight()/2 - 50);
        for(int count= 5; count >= 1; count--)
        {
            countDown.setCount(count);
            Greenfoot.delay(25);
        }
        removeObject(countDown);
    }
}
