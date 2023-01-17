import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld0 extends World
{
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[23];
    int idx = 0;

    boolean paused = false;

    SimpleTimer pauseTimer = new SimpleTimer();
    /**
     * Constructor for objects of class GameWorld0.
     * 
     */
    public GameWorld0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        
        addObject(johnTextbox , 500, 250);
        
        johnTextbox.setText("It's that day again...");
        
        //Dialoges
        sentences[0] = " ";
    }
    
    public void act()
    {
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
