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
    Eve eve = new Eve();
    JohnTextbox johnTextbox = new JohnTextbox();
    
    String[] sentences = new String[23];
    int idx = 0;

    String response = "normal";
    
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
        
        addObject(eve,500,250);
        addObject(mainTextbox , 500, 250);
        
        //Dialoges
        sentences[0] = "You there";
        sentences[1] = "What is your name?";
        sentences[2] = "What is your name?";
        sentences[3] = "What is your name?";
        sentences[4] = "Hi John";
        sentences[5] = "I'm Eve";
        sentences[6] = "How are you?";
        sentences[7] = "How are you?";
        sentences[8] = "How are you?";
        sentences[9] = "Great!";
        sentences[10] = "Are you free right now?";
        sentences[11] = "I have a coupon for a very popular drink";
        sentences[12] = "It's at a near by cafe";
        sentences[13] = "I was suppose to go with a friends but he...";
        sentences[14] = "So will you go with me instead?";
        sentences[15] = "Don't worry! I'll pay for the whole thing!";
        sentences[16] = "So please? Pretty please??";
        sentences[17] = "So please? Pretty please??";
        sentences[18] = "So please? Pretty please??";
        sentences[19] = "Yes! Thanks John!";
        sentences[20] = "Let's right now before a line form!";
        sentences[21] = "Let's right now before a line form!";
        sentences[22] = "Let's right now before a line form!";

        pauseTimer.mark();
        //the cursor
        Pointer pointer = new Pointer();
        addObject(pointer, -10, -10);
    }
    //This is to keep track the points to each ending
    int ending = 0;

    public void act ()
    {
        // For Eve to change expression mid conversation
        if(idx == 5)
        {
                //The image should change to eve.Happy
                eve.setState("happy");
        }
        if(idx == 6)
        {
                //The image should change to eve.Normal
                eve.setState("normal");
                mainTextbox.setName("Eve");
        }
        if(idx == 10)
        {
                //The image should change to eve.Happy
                eve.setState("happy");
        }
        if(idx == 11)
        {
                //The image should change to eve.Normal
                eve.setState("normal");
        }
        if(idx == 20)
        {
                //The image should change to eve.Normal
                eve.setState("happy");
        }
        if(idx == 21)
        {
                //The image should change to eve.Normal
                eve.setState("normal");
        }
        if(idx == 22)
        {
                //Continue to the next world
                GameWorld1 gameWorld1 = new GameWorld1();
                Greenfoot.setWorld(gameWorld1);
        }
        //For the option box to show up
        if(Greenfoot.isKeyDown("space") && !paused && !choiceEnabled)
        {
            mainTextbox.setText(nextSentence());
            paused = true;
            pauseTimer.mark();
            if(idx == 3)
            {
                //Option 1
                addObject(responseA, 500, 250);
                responseA.setText("Uh, I'm John");
                choiceEnabled = true;
            }
            if(idx == 8)
            {
                //Option 2
                responseA.show();
                responseA.setText("I'm good...");
                choiceEnabled = true;
            }
            if(idx == 18)
            {
                //Option 2
                responseA.show();
                responseA.setText("Well, it is a free drink...");
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
