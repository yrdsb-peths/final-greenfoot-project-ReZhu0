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
    Hand hand = new Hand();
    Table table = new Table();
    JohnTextbox johnTextbox = new JohnTextbox();
    Drink1 drink1 = new Drink1();
    Drink2 drink2 = new Drink2();
    
    String[] sentences = new String[50];
    int idx = 0;

    String response = "menu";
    
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
        addObject(hand,500,250);
        addObject(table,500,250);
        addObject(drink1, 500, 250);
        addObject(drink2, 500, 250);
        addObject(mainTextbox,500,250);
        addObject(johnTextbox , 500, 250);
        
        eve.setState("menu");
        
        mainTextbox.setName("Eve");
        johnTextbox.setText("You and Eve headed to the cafe and was steated");
        
        hand.hide();
        drink1.hide();
        drink2.hide();
        mainTextbox.hide();
        mainTextbox.setText(" ");
        mainTextbox.setName(" ");
        responseA.hide();
    }
}
