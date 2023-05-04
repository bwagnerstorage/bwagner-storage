import greenfoot.*;

/**
 * Write a description of class CountDown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountDown extends Actor
{
    public CountDown()
    {
        GreenfootImage image = new GreenfootImage(80,80);
        setImage(image);
    }
    
    public void setCount(int count)
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setFont(new Font("Impact", false, false, 60));
        image.setColor(Color.YELLOW);
        image.drawString("" + count, 20, image.getHeight());
        setImage(image);
    }
}
