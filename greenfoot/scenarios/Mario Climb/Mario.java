import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mario extends AnimatedActor
{
    // constants
    final int GROUND_TOP = 338;
    
    // instance variables
    private int dx;
    private int dy;
    private int gravity;
    private String direction = "right";
    private boolean climbing = false;        // curretly climbing?
    private boolean onPlatform = false;      // currently on platform?
    private boolean isFalling = false;         // currently falling?
    private boolean dead = false;
    private boolean onPole = false;
    private Platform currentPlatform = null;
    private int ladderBottom;
    
    // constructor
    public Mario(String imageFile, int numframes, int frameWidth, int frameHeight)
    {
        super(imageFile, numframes, frameWidth, frameHeight);
        setAutoAdvance(true);
        setAdvanceSpeed(2);
        setLooping(true);
        setAutoAdvanceRange(0, 8);
        show();
    }
    
    public void act() 
    {
        super.act();
        
        if(!dead)
        {
            movementTest();
            
            wrapAroundTest();
            
            climbLadderTest();
            
            updateLocation();
        
        }
    }    
    
    public void updateLocation()
    {
        setLocation(getX() + dx, getY() + dy);
        dy = dy + gravity;
    }
    
    public void movementTest()
    {
        boolean keypressed = false;
        if(!climbing)
        {
            if(Greenfoot.isKeyDown("right"))
            {
                dx = 1;
                keypressed = true;
                if(direction.equals("left"))
                {
                    setAutoAdvanceRange(0,8);
                    setFrame(0);
                    direction = "right";
                    currentPlatform = (Platform)this.getOneObjectAtOffset(0, 25, Platform.class);
                }    
            }
            
            if(Greenfoot.isKeyDown("left"))
            {
                dx = -1;
                keypressed = true;
                if(direction.equals("right"))
                {
                    setAutoAdvanceRange(0,8);
                    setFrame(0);
                    direction = "left" ;
                    currentPlatform = (Platform)this.getOneObjectAtOffset(0, 25, Platform.class);
                }  
                else
                    this.getImage().mirrorHorizontally();
            }
            
            if(!keypressed)   // no key pressed
            {
                dx = 0;
                setFrame(0);
                if(direction.equals("left"))
                    this.getImage().mirrorHorizontally();         
            } 
            
            // check to see if Mario has walked off the edge of a platform
            if(onPlatform && Math.abs(GROUND_TOP - getY()) > this.getHeight()
               && this.getOneObjectAtOffset(0, getHeight()/2, Platform.class) == null
               && this.getOneObjectAtOffset(0, getHeight()/2, Ladder.class) == null)
            {
                dx = 0; 
                dy = 1;
                gravity = 1;
                onPlatform = false;
                isFalling = true;
            }
            
            if(isFalling)
            {
                if(getY() + getHeight()/2 >= GROUND_TOP)
                {
                    if(direction.equals("right"))
                    {
                        setRotation(90);
                    }
                    else
                         setRotation(-90);
                    
                    dy = 0;
                    dx = 0;
                    gravity = 0;
                    setLocation(getX(), GROUND_TOP - 10);
                    setAutoAdvance(false);
                    setFrame(0);
                    dead = true;
                    
                }
            }
        }
    }
    
    public void wrapAroundTest()
    {
       int w = this.getImage().getWidth();
       
       if(getX() < -w) 
           setLocation(getWorld().getWidth() + this.getImage().getWidth(), getY());
       if(getX() > getWorld().getWidth() + w)
           setLocation(-w, getY());
    }
    
    public void climbLadderTest()
    {
        if(Greenfoot.isKeyDown("up"))    // attempt to ascend ladder
        {
            if(isTouching(Ladder.class))  // Is Mario currently touching a ladder?
            {
                if(!climbing)   // if he is not currently climbing
                {
                    Actor ladder = this.getOneIntersectingObject(Ladder.class);    // get reference to ladder
                    if(Math.abs(getX() - ladder.getX()) < 4)  // centers of Mario and Ladder must
                    {                                         // be within 4 pixels of each other
                        dy = -1;                           // prepare to start climbing    
                        dx = 0;                            // no horizonal movement while on ladder
                        climbing = true;                   // he is climbing
                        this.setAutoAdvanceRange(9, 15);   // use climbing frames to animate movement
                        setFrame(9);                       // start with frame 9
                    }
                }
                else  // still climbing
                {
                    dy = -1;
                }
            } 
            else // key "up" pressed but Mario not on ladder anymore, must be on a platform
            {
                dy = 0;                      // stop climbing
                climbing = false;            // he is not climbing
                setAutoAdvanceRange(0, 8);   // use walking frames
                onPlatform = true;           // he is on platform
            }
        }
        else if(Greenfoot.isKeyDown("down"))   // attempt to descend ladder
        {
            if(!climbing) // if he is not currently climbing
            {
                Actor ladder = getOneObjectAtOffset(0, getHeight(), Ladder.class);    // get reference to ladder
                if(ladder != null && Math.abs(getX() - ladder.getX()) < 4)  // centers of Mario and Ladder
                {                                                           // must be within 4 pixels
                    dy = 1;                             // prepare for descending ladder
                    dx = 0;                             // no horizontal movement while on ladder
                    climbing = true;                    // he is climbing
                    this.setAutoAdvanceRange(9, 15);    // use climbing frames to animate movement
                    setFrame(9);                        // start with frame 9
                    
                    // calculate location of the bottom of the ladder and store it in the variable ladderBottom
                    ladderBottom = ladder.getY() + (ladder.getImage().getHeight() / 2);
                } 
            }
            else   // still descending ladder
            {
                dy = 1;
                // check for stepping down on platform
                if(getY() + getHeight() / 2 >= ladderBottom)    // Has he reached the bottom of the ladder?
                {
                    dy = 0;                              // stop descending
                    climbing = false;                    // he is no longer climbing
                    this.setAutoAdvanceRange(0, 8);      // use walking frames
                }
                //check for stepping down on ground
                if(getY() + getHeight()/2 >= GROUND_TOP)  // 338 top of ground
                {
                    dy = 0;                              // stop descending
                    climbing = false;                    // he is not longer climbing
                    onPlatform = false;                  // he is on the ground, not a platform
                    setAutoAdvanceRange(0, 8);           // use walking frames
                }
            }
        }
        else  // no key pressed - don't move
        {
            if(climbing)   // freeze image and position
            {
                dy = 0;           // stop climbing
                setFrame(9);      // freeze frame at frame 9
            }
        }
   
    } 
}
