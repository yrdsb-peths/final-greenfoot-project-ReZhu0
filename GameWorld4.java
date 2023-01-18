import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld4 extends World
{
    MainTextbox mainTextbox = new MainTextbox(); 
    ResponseTextboxA responseA = new ResponseTextboxA();
    Eve eve = new Eve();
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[50];
    int idx = 0;

    String response = "normal";
    
    boolean paused = false;
    boolean choiceEnabled = false;
    
    SimpleTimer pauseTimer = new SimpleTimer();
    /**
     * Constructor for objects of class GameWorld4.
     * 
     */
    public GameWorld4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1); 
        
        addObject(eve,500,250);
        addObject(mainTextbox,500,250);
        addObject(johnTextbox , 500, 250);
        addObject(responseA, 500, 250);
        
        eve.setState("normal");
        
        mainTextbox.setName("Eve");
        johnTextbox.setText("One and a half hour later...");
        
        sentences[0] = "Well, thank you for spending your day with me";
        sentences[1] = "I have to take my leave now";
        sentences[2] = "Have a good day!";
        sentences[3] = "Have a good day!";
        sentences[4] = "Have a good day!";
        sentences[5] = "Bye!";
        sentences[6] = " ";
        sentences[7] = " ";
        sentences[8] = " ";
        sentences[9] = " ";
        sentences[10] = " ";
        sentences[11] = " ";
        sentences[12] = " ";
        mainTextbox.hide();
        mainTextbox.setName(" ");
        responseA.hide();
    }
    public void act()
    {
        if(idx == 1)
        {
            johnTextbox.hide();
            mainTextbox.show();
            mainTextbox.setName("Eve");
        }
        if(idx == 6)
        {
            eve.setState("happy");
        }
        if(idx == 7)
        {
            eve.hideImage();
            mainTextbox.hide();
            mainTextbox.setName(" ");
            johnTextbox.show();
            johnTextbox.setText("The girl ran off");
        }
        if(idx == 8)
        {
            johnTextbox.setText("'The way she acted at the cafe...'");
        }
        if(idx == 9)
        {
            johnTextbox.setText("'It was just like how she acted that day'");
        }
        if(idx == 10)
        {
            johnTextbox.setText("'And her hand, it was wrapped up'");
        }
        if(idx == 11)
        {
            johnTextbox.setText("'I wondered...'");
        }
        if(idx == 12)
        {
            johnTextbox.setText("'If I can get her to open up to me more...'");
        }
        if(idx == 13)
        {
            johnTextbox.setText("Creator Note: You made it to the end! Congrats!");
        }
        
        if(Greenfoot.isKeyDown("space") && !paused && !choiceEnabled)
        {
            mainTextbox.setText(nextSentence());
            paused = true;
            pauseTimer.mark();
            if(idx == 4)
            {
                responseA.show();
                responseA.setText("Yeah, you too");
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
