import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld3 extends World
{
    MainTextbox mainTextbox = new MainTextbox(); 
    ResponseTextboxA responseA = new ResponseTextboxA();
    ResponseTextboxB responseB = new ResponseTextboxB();
    Eve eve = new Eve();
    Table table = new Table();
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[30];
    int idx = 0;

    String response = "normal";
    
    boolean paused = false;
    boolean choiceEnabled = false;
    
    SimpleTimer pauseTimer = new SimpleTimer();
    /**
     * Constructor for objects of class GameWorld1.
     * 
     */
    public GameWorld3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 500, 1);
        
        addObject(eve,500,250);
        addObject(table,500,250);
        addObject(mainTextbox,500,250);
        addObject(johnTextbox , 500, 250);
        
        mainTextbox.setName("Eve");
        johnTextbox.setText("You and Eve headed to the cafe and was steated");
        //Dialoges
        sentences[0] = " ";
        sentences[1] = "Hey John, what are you gonna order?";
        sentences[2] = "Hey John, what are you gonna order?";
        sentences[3] = "Okay then, your choice";
        sentences[4] = "Okay then, your choice";
        sentences[5] = " ";
        sentences[6] = "Um... John";
        sentences[7] = "Since we have some time before the drinks arrive";
        sentences[8] = "I would like to get to know you better";
        sentences[9] = "Would you mind a little about yourself?";
        sentences[10] = "Would you mind a little about yourself?";
        sentences[11] = "---";
        sentences[12] = "Thanks";
        sentences[13] = "---";
        sentences[14] = "---";
        sentences[15] = "---";
        sentences[16] = "I knew it!";
        sentences[17] = "I knew it!";
        sentences[18] = " ";
        sentences[19] = "You went to the same school as me right?";
        sentences[20] = "I knew I've seen you around from somewhere";
        
        mainTextbox.hide();
        mainTextbox.setText(" ");
        mainTextbox.setName(" ");
        responseA.hide();

        pauseTimer.mark();
        //the cursor
        Pointer pointer = new Pointer();
        addObject(pointer, -10, -10);
    }
    public int goodEnding = 0;
    public int badEnding = 0;
    public void act()
    {
        if(idx == 1)
        {
            johnTextbox.setText("She is taking her time looking at the menu...");
        }
        if(idx == 6)
        {
            johnTextbox.show();
            johnTextbox.setText("Eve called over a waiter and submitted our orders");
            mainTextbox.hide();
            mainTextbox.setName(" ");
        }
        if(idx == 7)
        {
            mainTextbox.show();
            mainTextbox.setName("Eve");
            johnTextbox.hide();
        }
        if(idx == 13)
        {
            eve.setState("happy");
        }
        if(idx == 14)
        {
            eve.setState("normal");
            mainTextbox.hide();
            mainTextbox.setName(" ");
            johnTextbox.show();
            johnTextbox.setText("You tell Eve a little about yourself");
        }
        if(idx == 15)
        {
            mainTextbox.hide();
            johnTextbox.show();
            johnTextbox.setText("Of course, you didn't tell her anything personal");
        }
        if(idx == 17)
        {
            mainTextbox.show();
            mainTextbox.setName("Eve");
            johnTextbox.hide();
            eve.setState("happy");
        }
        if(idx == 20)
        {
            eve.setState("normal");
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
                addObject(responseA,500,250);
                responseA.show();
                responseA.setText("I'll just have the drink");
                choiceEnabled = true;
            }
            if(idx == 11)
            {
                responseA.show();
                responseA.setText("Yeah sure");
                choiceEnabled = true;
            }
            if(idx == 18)
            {
                responseA.show();
                responseA.setText("?");
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
                responseB.setText(" ");
                responseB.hide();
                idx++;
                mainTextbox.setText(nextSentence());
                goodEnding++;
            }
            if(Greenfoot.mouseClicked(responseB))
            {
                choiceEnabled = false;
                // hide responseB
                responseA.setText(" ");
                responseA.hide();
                responseB.setText(" ");
                responseB.hide();
                idx++;
                mainTextbox.setText(nextSentence());
                badEnding++;
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