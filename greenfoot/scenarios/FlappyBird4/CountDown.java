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
        GreenfootImage image = getImage();                       // get current image
        image.clear();                                           // erase image
        image.setFont(new Font("Impact", false, false, 60));       // choose font
        image.setColor(Color.YELLOW);                            // choose drawing color
        image.drawString("" + count, 20, image.getHeight());     // write count value on image
    }
}
