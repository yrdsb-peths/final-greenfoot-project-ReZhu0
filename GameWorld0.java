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
    MainTextbox mainTextbox = new MainTextbox(); 
    ResponseTextbox responseA = new ResponseTextbox();
    
    String[] sentences = new String[10];
    int idx = 0;

    boolean paused = false;
    boolean choiceEnabled = false;

    SimpleTimer pauseTimer = new SimpleTimer();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);

        // Eve's image
        EveNormal eveNormal = new EveNormal();
        addObject(eveNormal,500,250);

        addObject(mainTextbox , 500, 250);
        

        sentences[0] = "I'm Eve";
        sentences[1] = "What is your name?";
        sentences[2] = "What is your name?";
        sentences[3] = "What is your name?";
        sentences[4] = "Hi John";
        sentences[5] = "I'm Eve";
        sentences[6] = "How are you?";
        sentences[7] = "How are you?";
        sentences[8] = "How are you?";

        pauseTimer.mark();

        Pointer pointer = new Pointer();
        addObject(pointer, -10, -10);
    }
    //This is to keep track the points to each ending
    int ending = 0;

    public void act ()
    {
        if(Greenfoot.isKeyDown("space") && !paused && !choiceEnabled)
        {               
            mainTextbox.setText(nextSentence());
            paused = true;
            pauseTimer.mark();
            if(idx == 3)
            {
                addObject(responseA, 500, 250);
                responseA.setText("I'm John");
                choiceEnabled = true;
            }
            
            if(idx == 8)
            {
                addObject(responseA, 500, 250);
                responseA.setText("I'm good");
                choiceEnabled = true;
            }
        } 
        
        if(choiceEnabled)
        {
            // if mouseclicked
            if(Greenfoot.mouseClicked(responseA))
            {
                choiceEnabled = false;
                // hide responseA
                responseA.setText(" ");
                responseA.hide();
                idx++;
            }
            // advance nextSentence
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
