import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CursorTracker extends Actor
{
    private MouseInfo info;
    private GreenfootImage bk;
    
    public CursorTracker()
    {
        info = Greenfoot.getMouseInfo();
        bk = new GreenfootImage(80, 20);
        bk.setColor(Color.BLACK);
        bk.fillRect(0, 0, 60, 20);  // erase image
        bk.setFont(new Font("Arial", false, false, 18));
        this.setImage(bk);
    }
    
    /**
     * Act - do whatever the CursorTracker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
        {
            info = Greenfoot.getMouseInfo();
            bk = getImage();
            bk.setColor(Color.BLACK);
            bk.fillRect(0, 0, 80, 20);   // erase image
            String str = info.getX() + "," + info.getY();
            bk.setColor(Color.GREEN);
            bk.drawString(str, 8, 16);
            setImage(bk);
        }
    }    
}
