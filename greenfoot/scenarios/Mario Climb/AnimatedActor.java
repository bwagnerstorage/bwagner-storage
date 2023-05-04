import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;
import java.awt.image.*;


public class AnimatedActor extends Actor
{   
    // Instance Variables
    private int numFrames;
    private int currentFrame;
    private int startFrame;
    private int endFrame;
    private int frameWidth;
    private int frameHeight;
    private boolean looping;
    private boolean autoAdvance;
    private boolean freezeLastFrame;
    private long advanceSpeed;
    private long delay;
    private GreenfootImage image;
    
    public AnimatedActor(String imageFile, int numframes, int frameWidth, int frameHeight)
    {
       super();
       image = new GreenfootImage(imageFile);
       this.numFrames = numframes;
       startFrame = 0;
       endFrame = numframes-1;
       this.frameWidth = frameWidth;
       this.frameHeight = frameHeight;  
       currentFrame = 0;
       looping = false;
       autoAdvance = false;
       advanceSpeed = 0;
       delay = 0;
       
       // set actor to a temporary image so the greenfoot icon does not appear on screen
       GreenfootImage tempImage = new GreenfootImage(1, 1);
       setImage(tempImage);
    }
    
    public int getWidth()
    {
        return frameWidth;
    }
    
    public int getHeight()
    {
        return frameHeight;
    }
    
    public int getFrame()
    {
        return currentFrame;
    }   
    
    public void setFrame(int f)
    {
        if(f >= 0 && f < numFrames)
           currentFrame = f;
    }
    
    public void setLooping(boolean b)
    {
        looping = b;
    }
    
    public void setAdvanceSpeed(int s)
    {
       advanceSpeed = s;
    }
    
    public void setAutoAdvance(boolean b)
    {
        autoAdvance = b;
    }
    
    public void setFreezeLastFrame(boolean b)
    {
        freezeLastFrame = b;
    }
    
    public void setAutoAdvanceRange(int begin, int end)
    {
        if(begin >= 0 && end < numFrames)
        {
            startFrame = begin;
            endFrame = end;
        }
        else
            System.out.println("Auto advance out of range error");

    }
    
    public void nextFrame()
    {
        if(currentFrame < endFrame)
          currentFrame++;
        else if(looping == true)
          currentFrame = startFrame;
        else if(freezeLastFrame == false)
          getWorld().removeObject(this);
    }
    
    public void show()
    {
       GreenfootImage buffer = new GreenfootImage(frameWidth, frameHeight);
       BufferedImage bImage= buffer.getAwtImage();
       Graphics gr = bImage.getGraphics();
       gr.drawImage(image.getAwtImage(), 0, 0, frameWidth, frameHeight, currentFrame * frameWidth, 0, currentFrame * frameWidth + frameWidth, frameHeight, null);

       setImage(buffer); 
    }
    
    public void updateImage()
    {
       show();
       
       if(autoAdvance == true)
       {
          if(delay == 0)
          {
             delay = System.currentTimeMillis() + advanceSpeed * 25;
          }
          if(System.currentTimeMillis() > delay)
          {
             nextFrame();
             delay = System.currentTimeMillis() + advanceSpeed * 25;
          }
       }
    }
    
    public void act()
    {
       updateImage();
    }
}