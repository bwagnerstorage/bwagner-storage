import greenfoot.*;

/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    int score;
    int damage;
    int forceField;
    
    public Scoreboard()
    {
        GreenfootImage image = new GreenfootImage(500,80);
        setImage(image);
        score = 0;
        damage = 3;
        forceField = 3;
        
        drawBoard();
    }
    
    public void act()
    {
        drawBoard();
    }
    
    public void drawBoard()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.setColor(Color.WHITE);
        image.setFont(new Font("Arial", false, false, 24));
        image.drawString("Score " + score + "         Damage " + damage + "         ForceField " + forceField, 20, image.getHeight()-5);
        setImage(image);
    }
    
    public void updateScore(int s)
    {
        score = s;
    }
    
    public void updateDamage(int d)
    {
        damage = d;
    }
    
    public void updateForceField(int f)
    {
        forceField = f;
    }
}
