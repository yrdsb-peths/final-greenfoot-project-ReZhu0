import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld1 extends World
{
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[9];
    int idx = 0;

    boolean paused = false;

    SimpleTimer pauseTimer = new SimpleTimer();
    /**
     * Constructor for objects of class GameWorld0.
     * 
     */
    public GameWorld1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        
        addObject(johnTextbox , 500, 250);
        
        johnTextbox.setText("'So this day again...'");
        
        //Dialoges
        sentences[0] = "'Can't believe it has been a whole year'";
        sentences[1] = "'It seems like it was just yesterday'";
        sentences[2] = "'Hm?'";
        sentences[3] = "'Hm?'";
    }
    
    public void act()
    {
        if(idx == 4)
        {
                //Continue to the next world
                GameWorld2 gameWorld2 = new GameWorld2();
                Greenfoot.setWorld(gameWorld2);
        }
        
        if(Greenfoot.isKeyDown("space") && !paused)
        {
            johnTextbox.setText(nextSentence());
            paused = true;
            pauseTimer.mark();
        } 
        
        if(pauseTimer.millisElapsed() > 100)
        {
            paused = false;
        }
    }
    
    private String nextSentence()
    {
        return sentences[idx++];
    }
}
