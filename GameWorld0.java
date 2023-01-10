import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * Visual Novel
 * 
 * You talk to Eve in your day-to-day life.
 * 
 * @author R.Z 
 * @version Dec 16 2022
 */
public class GameWorld0 extends World
{
    Label text = new Label("Hello", 35);
    //Label choice1 = new Label("I'm good?", 50);
    Label nameEve = new Label("Eve",45);
    
    String[] sentences = new String[10];
    int idx = 0;
    
    boolean paused = false;
    
    SimpleTimer pauseTimer = new SimpleTimer();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        
        EveNormal eveNormal = new EveNormal();
        addObject(eveNormal,500,250);
        
        TextBox textbox = new TextBox();
        addObject (textbox , 500, 250);
        //How the text should look
        addObject (text, 500, 390);
        //How the name should look
        addObject (nameEve, 210, 332);
        
        TextBox2 choice1 = new TextBox2();
        
        sentences[0] = "I'm Eve";
        sentences[1] = "What is your name?";
        sentences[2] = "What is your name?";
        sentences[3] = "What is your name?";
        
        pauseTimer.mark();
        
        Pointer pointer = new Pointer();
        addObject(pointer, -10, -10);
    }
    //This is to keep track the points to each ending
    int ending = 0;
    
    public void act ()
    {
        if(Greenfoot.isKeyDown("space"))
        {               
            if(!paused)
            {
                    text.setValue(nextSentence());
                    paused = true;
                    pauseTimer.mark();
                    if(idx == 3)
                    {
                        TextBox2 choice1 = new TextBox2();
                        addObject(choice1, 500, 250);
                        Label name = new Label("I'm John", 45);
                        addObject (name,500,180);
                        if (Greenfoot.mouseClicked(choice1))
                        {
                            removeObject(choice1);
                        }
                    }
            }
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
