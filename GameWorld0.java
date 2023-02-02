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
    
    String[] sentences = new String[9];
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
        
        johnTextbox.setText("'So this day again...'");
        
        //Dialoges
        sentences[0] = "February 4, 20XX Saturday";
        sentences[1] = "'Mom said she had already prepared the flowers'";
        sentences[2] = "'...'";
        sentences[3] = "'.....'";
        sentences[4] = "'John you big idiot...'";
        sentences[5] = "'If only you said something-'";
        sentences[6] = "'...'";
        sentences[7] = "'I need some fresh air'";
        sentences[8] = "'I need some fresh air'";
    }
    
    public void act()
    {
        if(idx == 9)
        {
                //Continue to the next world
                GameWorld1 gameWorld1 = new GameWorld1();
                Greenfoot.setWorld(gameWorld1);
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
