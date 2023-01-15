import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld1 extends World
{
    MainTextbox mainTextbox = new MainTextbox(); 
    ResponseTextbox responseA = new ResponseTextbox();
    Eve eve = new Eve();
    Table table = new Table();
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[20];
    int idx = 0;

    String response = "normal";
    
    boolean paused = false;
    boolean choiceEnabled = false;

    SimpleTimer pauseTimer = new SimpleTimer();
    /**
     * Constructor for objects of class GameWorld1.
     * 
     */
    public GameWorld1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        
        addObject(eve,500,250);
        addObject(table,500,250);
        addObject(mainTextbox,500,250);
        addObject(johnTextbox , 500, 250);
        addObject(responseA,500,250);
        
        mainTextbox.setName("Eve");
        johnTextbox.setText("You and Eve headed to the cafe and was steated");
        //Dialoges
        sentences[0] = " ";
        sentences[1] = "Hey John, what are you gonna order?";
        sentences[2] = "Hey John, what are you gonna order?";
        sentences[3] = "Okay then, your choice";
        sentences[4] = "Okay then, your choice";

        
        mainTextbox.hide();
        mainTextbox.setText(" ");
        mainTextbox.setName(" ");
        responseA.hide();

        pauseTimer.mark();
        //the cursor
        Pointer pointer = new Pointer();
        addObject(pointer, -10, -10);
    }
    
    public void act()
    {
        if(idx == 1)
        {
            johnTextbox.setText("She is taking her time looking at the menu...");
        }
        if(Greenfoot.isKeyDown("space") && !paused && !choiceEnabled)
        {
            mainTextbox.setText(nextSentence());
            paused = true;
            pauseTimer.mark();
            if(idx == 2)
            {
                mainTextbox.show();
                mainTextbox.setText("Hey John, what are you gonna order?");
                mainTextbox.setName("Eve");
                johnTextbox.hide();
            }
            if(idx == 3)
            {
                responseA.show();
                responseA.setText("I'll just have the drink");
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
                mainTextbox.setText(nextSentence());
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
