import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * Visual Novel
 * 
 * @author Rebecca Zhu 
 * @version Dec 16 2022
 */
public class GameWorld0 extends World
{
    Label text = new Label("Hello", 35);
    Label nameEve = new Label("Eve",45);
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
        addObject (text, 210, 390);
        //How the name should look
        addObject (nameEve, 210, 332);
        
    }
    
    public void act ()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            removeObject(text);
            Label text1 = new Label("How are you?", 35);
            addObject (text1, 266, 390);
        }
    }
}
