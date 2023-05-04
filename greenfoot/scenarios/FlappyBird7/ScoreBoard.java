import greenfoot.*;

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    public ScoreBoard()
    {
        GreenfootImage image = new GreenfootImage(150,80);
        setImage(image);
    }
    
    public void setScore(int score)
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setFont(new Font("Impact", false, false, 72));
        image.drawString("" + score, 20, image.getHeight());
        setImage(image);
    }
}
