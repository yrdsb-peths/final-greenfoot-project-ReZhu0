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
    Drink1 drink1 = new Drink1();
    Drink2 drink2 = new Drink2();
    
    String[] sentences = new String[45];
    int idx = 0;

    String response = "menu";
    
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
        addObject(drink1, 500, 250);
        addObject(drink2, 500, 250);
        addObject(mainTextbox,500,250);
        addObject(johnTextbox , 500, 250);
        
        eve.setState("menu");
        
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
        sentences[15] = "I knew it!";
        sentences[16] = "I knew it!";
        sentences[17] = "I knew it!";
        sentences[18] = "You went to the same school as me right?";
        sentences[19] = "You went to the same school as me right?";
        sentences[20] = "I knew I've seen you around from somewhere";
        sentences[21] = "I knew I've seen you around from somewhere";
        sentences[22] = "Yup, but you were two grades higher than me";
        sentences[23] = "So I didn't know you very well";
        sentences[24] = "But again I also didn't came to school very often";
        sentences[25] = "Well, enough from you";
        sentences[26] = "It's now my turn to tell you a little about me";
        sentences[27] = "Well, where should I start...";
        sentences[28] = "Oh here's something about me, I'm an artist!";
        sentences[29] = "No, I don't mean I draw for fun, well, I do";
        sentences[30] = "My parents sell my paintings online";
        sentences[31] = "And surprisingly there is a demand for my work!";
        sentences[32] = "And surprisingly there is a demand for my work!";
        sentences[33] = "And surprisingly there is a demand for my work!";
        sentences[34] = "Yeah, it is really fun";
        sentences[35] = "It's just... I don't have any motivation to draw";
        sentences[36] = "It's just... I don't have any motivation to draw";
        sentences[37] = "It's just... I don't have any motivation to draw";
        sentences[38] = "...";
        sentences[39] = "...";
        sentences[40] = " ";
        
        drink1.hide();
        drink2.hide();
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
            eve.setState("normal");
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
        if(idx == 16)
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
        if(idx == 25)
        {
            eve.setState("away");
        }
        if(idx == 26)
        {
            eve.setState("normal");
        }
        if(idx == 29)
        {
            eve.setState("happy");
        }
        if(idx == 30)
        {
            eve.setState("normal");
        }
        if(idx == 35)
        {
            eve.setState("happy");
        }
        if(idx == 36)
        {
            eve.setState("away");
        }
        if(idx == 39)
        {
            eve.setState("down");
        }
        if(idx == 40)
        {
            mainTextbox.hide();
            mainTextbox.setName(" ");
            johnTextbox.show();
            johnTextbox.setText("The girl looked down in silence");
        }
        if(idx == 41)
        {
            drink1.show();
            drink2.show();
            johnTextbox.setText("The waiter broke the silence by handing us our drinks");
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
            if(idx == 17)
            {
                responseA.show();
                responseA.setText("?");
                choiceEnabled = true;
            }
            if(idx == 21)
            {
                responseA.show();
                responseA.setText("Oh, is that so?");
                choiceEnabled = true;
            }
            if(idx == 33)
            {
                responseA.show();
                responseA.setText("Wow, that's great");
                choiceEnabled = true;
            }
            if(idx == 37)
            {
                responseA.show();
                responseA.setText("Why were you not at to school?");
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
